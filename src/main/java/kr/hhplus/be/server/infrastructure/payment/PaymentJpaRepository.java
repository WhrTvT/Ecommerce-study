package kr.hhplus.be.server.infrastructure.payment;

import jakarta.persistence.LockModeType;
import kr.hhplus.be.server.domain.payment.Payment;
import kr.hhplus.be.server.domain.user.UserWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {

    @Query("""
        SELECT uw
        FROM UserWallet uw
        INNER JOIN Orders o ON o.userId = uw.userId
        WHERE
            o.orderId = ?1
            AND o.finalPrice <= uw.currentAmount
    """)
    UserWallet findUserWalletWithPaymentByOrderId(long orderId);

    @Query("""
        SELECT
            CASE
                WHEN COUNT(p) > 0
                THEN TRUE
                ELSE FALSE
            END
        FROM Payment p
        WHERE p.orderId = ?1 AND p.status = ?2
    """)
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    boolean existsByOrderIdAndStatusWithLock(long orderId, String status);

    @Query("SELECT p FROM Payment p WHERE p.orderId = ?1")
    Payment findByOrderId(long orderId);
}

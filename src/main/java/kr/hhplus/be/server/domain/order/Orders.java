package kr.hhplus.be.server.domain.order;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kr.hhplus.be.server.domain.coupon.UserCoupon;
import kr.hhplus.be.server.domain.user.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Orders {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(insertable=false, updatable=false)
    private long userId;

    @Column(insertable=false, updatable=false)
    private Long userCouponId;

    private BigDecimal couponDiscount;

    @NotNull
    private BigDecimal totalPrice;

    @NotNull
    private BigDecimal finalPrice;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne
    @JoinColumn(name = "userCouponId")
    private UserCoupon userCoupon;

    public BigDecimal getCouponDiscount(BigDecimal totalPrice, BigDecimal discount, boolean isPercent) {
        if(isPercent){
            return totalPrice.divide(discount, 0, RoundingMode.HALF_UP);
        } else {
            return totalPrice.subtract(discount);
        }
    }

    public BigDecimal getTotalPrice(List<OrderDetail> orderDetails) {
        // 총 가격 계산
        return orderDetails.stream()
                .map(detail -> detail.getUnitPrice().multiply(BigDecimal.valueOf(detail.getSelectQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getFinalPrice(BigDecimal totalPrice, BigDecimal couponDiscount) {
        // 최종 가격 계산
        return totalPrice.subtract(couponDiscount);
    }
}

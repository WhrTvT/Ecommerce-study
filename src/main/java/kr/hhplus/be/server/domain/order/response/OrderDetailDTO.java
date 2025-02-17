package kr.hhplus.be.server.domain.order.response;

import java.math.BigDecimal;

public record OrderDetailDTO(
        long userId,
        long orderId,
        long productId,
        long selectQuantity,
        BigDecimal unitPrice
) {

}

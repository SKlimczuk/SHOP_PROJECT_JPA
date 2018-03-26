package com.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOrderdDTO {
    private Long id;
    private Date date;
    private BigDecimal discount;
    private Integer qunatity;
    private Long paymentId;
    private Long productId;
    private Long customerId;
}

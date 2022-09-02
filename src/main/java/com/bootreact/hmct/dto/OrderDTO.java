package com.bootreact.hmct.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OrderDTO {
    private int orderNo;
    private String userId;
    private String orderStatus;
 	private LocalDate orderDate;
 	private String 	orderMemo;
 	private String orderAmount;
 	private String orderDiscount;
 	private String orderFee;
}

package com.saxo.assignment.client;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class ClientPortfolio {
	
	private int clientId;
	private String clientFirstName;
	private String clietLastName;
	private String clientFund;
	private String email;
	private String phoneNo;
	private BigDecimal clinetInvestedAmount;
	private BigDecimal clientCurrentAmout;

}

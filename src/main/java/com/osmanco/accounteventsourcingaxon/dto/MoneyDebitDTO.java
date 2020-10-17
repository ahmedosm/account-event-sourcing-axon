package com.osmanco.accounteventsourcingaxon.dto;

import lombok.Data;

@Data
public class MoneyDebitDTO {
	public double accountBalance;
	public String currency;
}

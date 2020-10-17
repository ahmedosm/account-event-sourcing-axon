package com.osmanco.accounteventsourcingaxon.services;

import java.util.concurrent.CompletableFuture;

import com.osmanco.accounteventsourcingaxon.dto.AccountCreateDTO;
import com.osmanco.accounteventsourcingaxon.dto.MoneyCreditDTO;
import com.osmanco.accounteventsourcingaxon.dto.MoneyDebitDTO;

public interface AccountCommandService {
	public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);

	public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);

	public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}

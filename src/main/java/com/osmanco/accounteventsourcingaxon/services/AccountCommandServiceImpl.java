package com.osmanco.accounteventsourcingaxon.services;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.osmanco.accounteventsourcingaxon.commands.CreateAccountCommand;
import com.osmanco.accounteventsourcingaxon.commands.CreditMoneyCommand;
import com.osmanco.accounteventsourcingaxon.commands.DebitMoneyCommand;
import com.osmanco.accounteventsourcingaxon.dto.AccountCreateDTO;
import com.osmanco.accounteventsourcingaxon.dto.MoneyCreditDTO;
import com.osmanco.accounteventsourcingaxon.dto.MoneyDebitDTO;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {

	private final CommandGateway commandGateway;

	public AccountCommandServiceImpl(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO) {
		return commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(),
				accountCreateDTO.getAccountBalance(), accountCreateDTO.getCurrency()));
	}

	public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO) {
		return commandGateway.send(new CreditMoneyCommand(accountNumber, moneyCreditDTO.getAccountBalance(),
				moneyCreditDTO.getCurrency()));
	}

	public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO) {
		return commandGateway.send(
				new DebitMoneyCommand(accountNumber, moneyDebitDTO.getAccountBalance(), moneyDebitDTO.getCurrency()));
	}

}

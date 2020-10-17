package com.osmanco.accounteventsourcingaxon.services;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

@Service
public class AccountQueryServiceImpl implements AccountQueryService {

	private final EventStore eventStore;

	public AccountQueryServiceImpl(EventStore eventStore) {
		super();
		this.eventStore = eventStore;
	}

	public List<Object> listEventsForAccount(String accountNumber) {
        return eventStore.readEvents(accountNumber).asStream().map( s -> s.getPayload()).collect(Collectors.toList());
	}

}

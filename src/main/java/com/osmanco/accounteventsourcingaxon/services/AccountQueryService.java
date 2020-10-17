package com.osmanco.accounteventsourcingaxon.services;

import java.util.List;

public interface AccountQueryService {
    public List<Object> listEventsForAccount(String accountNumber);
}
package io.code.crm.core.service.account;


import java.util.List;
import java.util.UUID;

import io.code.crm.core.model.EntityNotFoundException;
import io.code.crm.core.model.account.Account;

public interface IAccountService {

	List<Account> getAccountList();

	Account getByUuid(UUID id) throws EntityNotFoundException;

}
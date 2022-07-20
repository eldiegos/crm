package io.code.crm.core.service.account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import io.code.crm.core.model.EntityNotFoundException;
import io.code.crm.core.model.account.Account;
import io.code.crm.core.model.account.AccountRepository;
import lombok.extern.java.Log;

@Log
@Service
@Primary
@Qualifier("dataServiceRepo")
public class AccountService implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;

	

    @Override
    public List<Account> getAccountList() {
        return this.accountRepository.findAll();
    }

	
	@Override
	public Account getByUuid(UUID id) throws EntityNotFoundException {
		
		log.fine("Using DataServiceRepo Data Access");

		Account obj;

		Optional<Account> opFind = accountRepository.findById(id);
		if (opFind.isPresent()) {

			obj = opFind.get();
			
		} else
			throw new EntityNotFoundException(Account.class, "The account does not exists");

		return obj;
	}
}
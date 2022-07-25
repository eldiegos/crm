package io.code.crm.model.account;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import io.code.crm.core.model.account.Account;
import io.code.crm.core.model.account.AccountRepository;

@SpringBootTest
class AccountRepoTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	AccountRepository accountRepo;
	
	@Test
	void testGetAllAccounts(){

		Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
		
		Page<Account> rList = this.accountRepo.findAll(firstPageWithTwoElements);
		rList.stream().forEach(a -> System.out.println(a));
		
		assertTrue(rList!=null && !rList.isEmpty() && rList.getSize()==2);
	}

}

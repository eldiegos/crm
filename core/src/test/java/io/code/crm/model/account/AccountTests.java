package io.code.crm.model.account;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.code.crm.core.model.account.Account;
import io.code.crm.core.service.account.AccountService;

@SpringBootTest
class AccountTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	AccountService accountService;
	
	@Test
	void testGetAllAccounts(){

		List<Account> rList = this.accountService.getAccountList();
		for(Account cc : rList){
			System.out.println(cc.toString());
		}
		assertTrue(rList!=null && !rList.isEmpty());
	}

}

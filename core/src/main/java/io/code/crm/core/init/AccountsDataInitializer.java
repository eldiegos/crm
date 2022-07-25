package io.code.crm.core.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.code.crm.core.model.account.Account;
import io.code.crm.core.model.account.AccountRepository;
import lombok.extern.java.Log;

@Log
@Configuration
public class AccountsDataInitializer {

	@Autowired 
	private AccountRepository repo;

    @Bean
    void loadDemoAccounts() {

        Account c0 = new Account("Apple", "Apple inc.").withVat("US008756001");
        Account c1 = new Account("Google", "Alphabet").withVat("US089438349");
        Account c2 = new Account("Coca Cola", "Coca Cola Company");
        Account c3 = new Account("Microsoft España", "Microsoft España S.A.").withVat("ES3230042345");;
        Account c4 = new Account("Elsevier", "ELSEVIER ESPAÑA SL").withVat("ES0392838292");
        Account c5 = new Account("Cisco", "Cisco Systems");
        

        List<Account> list = List.of(c0, c1, c2, c3, c4, c5);
        repo.saveAll(list);
        
        log.fine("Accounts demo data loaded");
    }

}

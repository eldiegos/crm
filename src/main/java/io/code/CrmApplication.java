package io.code;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import io.code.config.init.SetupService;
import lombok.extern.java.Log;

@Log
@SpringBootApplication
public class CrmApplication {

	//Method executed 
	@PostConstruct
	void doPostConstruct(){
		log.fine("Post construct");
	}

	//Method executed after start to setup application.
	@Bean(initMethod="execute")
    SetupService init() {
        return new SetupService();
    }

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
		log.fine("CRM started");
	}

}

package io.code.crm.core.init;

import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Log
@Service
public class SetupService {

    public void execute() {
        log.info("CRM Setup");

    }

}

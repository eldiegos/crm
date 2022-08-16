package io.code.crm.core.model.contact;

import java.time.Instant;
import java.util.UUID;

import io.code.crm.core.model.BaseDTO;
import lombok.Data;


@Data
public class ContactDTO extends BaseDTO {

	/*
	private UUID id;
    private Instant createdAt;
    private Instant modifiedAt;
    */
    private String firstName;
    private String surname1;
    private String surname2;
	
}

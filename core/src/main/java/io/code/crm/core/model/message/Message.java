package io.code.crm.core.model.message;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.code.crm.core.model.BaseEntity;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "message")
public class Message extends BaseEntity {
	
	String message;
	
	public Message(String message) {
		super();
		this.message = message;
	}
	
}

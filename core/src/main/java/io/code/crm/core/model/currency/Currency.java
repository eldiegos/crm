package io.code.crm.core.model.currency;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.code.crm.core.model.NamedEntity;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "currency")
public class Currency extends NamedEntity {

	private String cod;
	private int currencyNumber;
	
	public Currency(@NonNull String name, @NonNull String cod, int currencyNumber) {
		super(name);
		this.cod=cod;
		this.currencyNumber=currencyNumber;
	}
	
}

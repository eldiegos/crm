package io.code.crm.core.model.country;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.code.crm.core.model.BaseEntity;
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
@Table(name = "country")
public class Country extends BaseEntity {

	private String cod2;
	private String cod3;
	private int country_number;
	private boolean eees;
	private boolean sepa;

	public Country(@NonNull String name, @NonNull String cod2, @NonNull String cod3, int country_number, boolean eees, boolean sepa) {
		super(name);
		this.cod2 = cod2;
		this.cod3 = cod3;
		this.country_number=country_number;
		this.eees=eees;
		this.sepa=sepa;
	}
	

}

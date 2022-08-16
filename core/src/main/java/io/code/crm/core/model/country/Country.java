package io.code.crm.core.model.country;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Table(name = "country",
uniqueConstraints={
        @UniqueConstraint(columnNames = "cod2"),
        @UniqueConstraint(columnNames = "cod3"),
        @UniqueConstraint(columnNames = "country_number")
       }
)
public class Country extends NamedEntity {

	@Column(columnDefinition = "char(2)", nullable = false)
	private String cod2;
	
	@Column(columnDefinition = "char(3)", nullable = false)
	private String cod3;
	
	@Column(name="country_number", nullable = false)
	private int countryNumber;
	
	@Column(nullable = false)
	private boolean eees;
	
	@Column(nullable = false)
	private boolean sepa;

	public Country(@NonNull String name, @NonNull String cod2, @NonNull String cod3, int countryNumber, boolean eees, boolean sepa) {
		super(name);
		this.cod2 = cod2;
		this.cod3 = cod3;
		this.countryNumber=countryNumber;
		this.eees=eees;
		this.sepa=sepa;
	}
	

}

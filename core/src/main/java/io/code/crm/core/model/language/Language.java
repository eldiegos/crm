package io.code.crm.core.model.language;

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
@Table(name = "language")
public class Language extends NamedEntity {

	private String cod;
	
	public Language(@NonNull String name, @NonNull String cod) {
		super(name);
		this.cod = cod;
	}
	
}

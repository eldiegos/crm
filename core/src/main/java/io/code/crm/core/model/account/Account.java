package io.code.crm.core.model.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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
@ToString(onlyExplicitlyIncluded = true, callSuper=true)
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "account")
public class Account extends NamedEntity {
    
	
	@Size(min = 2, max = 150)
	@Column(nullable = false, length = 150)
    private String legalName;
    
    private String vat;
    

    public Account(@NonNull String name, @NonNull String legalName){
        super(name);
        this.legalName=legalName;
        
    }

    public Account withVat(@NonNull String vat){
        this.vat=vat;
        return this;
    }
    
    

}

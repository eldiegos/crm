package io.code.crm.core.model.contact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.code.crm.core.model.AuditListener;
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
@EntityListeners(AuditListener.class)
@Entity
@Table(name = "contact")
public class Contact extends NamedEntity {
    
	@Size(min = 2, max = 50)
	@Column(nullable = false, length = 50)
    private String firstName;
	
	@Size(min = 2, max = 50)
	@Column(nullable = false, length = 50)
    private String surname1;
	
	@Column(length = 50)
    private String surname2;

    public Contact(@NonNull String firstName, @NonNull String surname1){
        super(firstName.concat(" ").concat(surname1));
        this.firstName=firstName;
        this.surname1=surname1;
    }

    public Contact withSurname2(@NonNull String surname2){
        this.surname2=surname2;
        return this;
    }

    public String getSurname(){
        String result = this.surname1;
        if(this.surname2!=null && !this.surname2.isBlank()){
            result=result.concat(" ").concat(this.surname2);
        }
        return result;
    }

    public String getFullName(){
        return this.firstName.concat(" ").concat(this.getSurname());
    }

    public String getSurnameAndName(){
        return this.getSurname().concat(", ").concat(this.firstName);
    }

}

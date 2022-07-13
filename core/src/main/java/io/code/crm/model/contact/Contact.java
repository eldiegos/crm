package io.code.crm.model.contact;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.code.crm.model.BaseEntity;
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
@Table(name = "contact")
public class Contact extends BaseEntity {
    
    private String firstName;
    private String surname1;
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

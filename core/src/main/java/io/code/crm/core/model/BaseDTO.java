package io.code.crm.core.model;

import java.time.Instant;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public abstract class BaseDTO {

	
	@ToString.Include
    private UUID id;


    /*
    @CreatedBy
    User creator;
    
    @LastModifiedBy
    User modifier;
    */

    
    private Instant createdAt;
    private Instant modifiedAt;

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof BaseDTO)) {
            return false;
        }
        BaseDTO other = (BaseDTO) obj;
        return getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}

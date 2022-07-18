package io.code.crm.core.model;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class BaseEntity {

    @ToString.Include
    @EqualsAndHashCode.Include
    @Id
    private UUID id;

    @ToString.Include
    private String name;

    /*
    @CreatedBy
    User creator;
    
    @LastModifiedBy
    User modifier;
    */

    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant modifiedAt;

    protected BaseEntity(@NonNull String name) {

        this.name = name.length() > 100 ? name.substring(0, 100) : name;
        //this.createdTime = Instant.now();
        //this.updatedTime = Instant.now();
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof BaseEntity)) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        return getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
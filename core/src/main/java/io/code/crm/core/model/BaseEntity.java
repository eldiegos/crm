package io.code.crm.core.model;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

	@Column(columnDefinition = "UUID")
    @ToString.Include
    @EqualsAndHashCode.Include
    @Id
    private UUID id;


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

    protected BaseEntity() {

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

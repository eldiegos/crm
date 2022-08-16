package io.code.crm.core.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class NamedEntity extends BaseEntity {

    @ToString.Include
    @Column(nullable = false)
    private String name;

    protected NamedEntity(@NonNull String name) {
    	super();
        this.name = name.length() > 100 ? name.substring(0, 100) : name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof NamedEntity)) {
            return false;
        }
        NamedEntity other = (NamedEntity) obj;
        return getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

}

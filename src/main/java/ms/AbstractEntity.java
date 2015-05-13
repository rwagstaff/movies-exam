package ms;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Base class for an identified domain object. Stolen from Implementing DDD
 * 
 * Copyright 2012,2013 Vaughn Vernon
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Column(name = "ID")
    private String id;

    protected AbstractEntity() {
        super();
        this.setId(UUID.randomUUID().toString());
    }

    private void setId(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof AbstractEntity)) {
            return false;
        }
        AbstractEntity castOther = (AbstractEntity) other;
        return new EqualsBuilder().append(id(), castOther.id()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id()).toHashCode();
    }

}

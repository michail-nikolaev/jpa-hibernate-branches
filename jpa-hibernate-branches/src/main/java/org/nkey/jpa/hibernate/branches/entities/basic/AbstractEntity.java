package org.nkey.jpa.hibernate.branches.entities.basic;

import org.nkey.jpa.hibernate.branches.entities.IdentifiableEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 2:15
 */
@MappedSuperclass
public class AbstractEntity implements IdentifiableEntity<Long> {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Version
    private Long version;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

package org.nkey.jpa.hibernate.branches.entities.branchable;

import org.nkey.jpa.hibernate.branches.entities.IdentifiableEntity;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 2:17
 */
@MappedSuperclass
public class AbstractBranchableEntity implements IdentifiableEntity<BranchableEntityId> {
    @EmbeddedId
    private BranchableEntityId id = new BranchableEntityId();

    @Version
    private Long version;

    @Override
    public BranchableEntityId getId() {
        return id;
    }

    public void setId(BranchableEntityId id) {
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

package org.nkey.jpa.hibernate.branches.entities.branchable;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 2:19
 */
@Embeddable
public class BranchableEntityId implements Serializable {
    // hibernate only feature
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logicalId;
    @Column
    private String branchName;

    public BranchableEntityId(Long logicalId, String branchName) {
        this.logicalId = logicalId;
        this.branchName = branchName;
    }

    public BranchableEntityId(String branchName) {
        this.branchName = branchName;
    }

    public BranchableEntityId() {}

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Long getLogicalId() {
        return logicalId;
    }

    public void setLogicalId(Long logicalId) {
        this.logicalId = logicalId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(logicalId, branchName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BranchableEntityId) {
            BranchableEntityId id = (BranchableEntityId) obj;
            return Objects.equal(logicalId, id.logicalId) && Objects.equal(branchName, id.branchName);
        } else {
            return false;
        }
    }
}

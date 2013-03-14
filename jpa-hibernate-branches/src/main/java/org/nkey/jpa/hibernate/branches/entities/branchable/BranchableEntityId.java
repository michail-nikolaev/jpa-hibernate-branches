package org.nkey.jpa.hibernate.branches.entities.branchable;

import com.google.common.base.Objects;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 2:19
 */
@Embeddable
public class BranchableEntityId implements Serializable {
    // hibernate only feature
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long logicalId;
    private String branchName;

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

package org.nkey.jpa.hibernate.branches.entities.generator;

import org.hibernate.search.bridge.TwoWayStringBridge;
import org.nkey.jpa.hibernate.branches.entities.branchable.BranchableEntityId;

/**
 * @author m.nikolaev Date: 19.03.13 Time: 3:04
 */
public class BranchableEntityIdBridge implements TwoWayStringBridge {
    @Override
    public String objectToString(Object object) {
        if (object instanceof BranchableEntityId) {
            BranchableEntityId id = (BranchableEntityId) object;
            return String.format("%s|%s", id.getLogicalId(), id.getBranchName());
        } else {
            return null;
        }
    }

    @Override
    public Object stringToObject(String stringValue) {
        if (stringValue != null) {
            BranchableEntityId result = new BranchableEntityId();
            String[] parts = stringValue.split("|", 0);
            if (parts.length >= 1) {
                result.setLogicalId(Long.valueOf(parts[0]));
            }
            if (parts.length >= 2) {
                result.setLogicalId(Long.valueOf(parts[1]));
            }
            return result;
        } else {
            return null;
        }
    }
}

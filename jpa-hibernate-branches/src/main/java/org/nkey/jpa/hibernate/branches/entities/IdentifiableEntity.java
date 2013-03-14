package org.nkey.jpa.hibernate.branches.entities;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 2:13
 */
public interface IdentifiableEntity<ID> {
    ID getId();
    Long getVersion();
}

package org.nkey.jpa.hibernate.branches.entities.basic;

import org.nkey.jpa.hibernate.branches.entities.branchable.ProjectEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 2:12
 */
@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity {
    @Column(nullable = false, updatable = false)
    private String username;
    @Column(nullable = true)
    private String displayName;

    @ManyToMany
    private Set<ProjectEntity> projects = new HashSet<>();

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectEntity> projects) {
        this.projects = projects;
    }

}

package org.nkey.jpa.hibernate.branches.entities.branchable;

import org.nkey.jpa.hibernate.branches.entities.basic.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 2:12
 */
@Entity
@Table(name = "projects")
public class ProjectEntity extends AbstractBranchableEntity {
    @Column(nullable = false)
    private String projectName;
    @ManyToMany
    private Set<UserEntity> users = new HashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<SourceFileEntity> sourceFiles;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set<SourceFileEntity> getSourceFiles() {
        return sourceFiles;
    }

    public void setSourceFiles(Set<SourceFileEntity> sourceFiles) {
        this.sourceFiles = sourceFiles;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }
}

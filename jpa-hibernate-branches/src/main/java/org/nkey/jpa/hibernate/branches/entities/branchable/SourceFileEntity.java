package org.nkey.jpa.hibernate.branches.entities.branchable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 2:12
 */
@Entity
@Table(name = "source_files")
public class SourceFileEntity extends AbstractBranchableEntity {
    @Column(nullable = false)
    private String fileName;
    @Column(nullable = true)
    private long size;

    @ManyToOne
    private ProjectEntity project;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }
}

package org.nkey.jpa.hibernate.branches.repositories;

import org.nkey.jpa.hibernate.branches.entities.branchable.BranchableEntityId;
import org.nkey.jpa.hibernate.branches.entities.branchable.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 2:32
 */
public interface ProjectRepository extends JpaRepository<ProjectEntity, BranchableEntityId> {
}

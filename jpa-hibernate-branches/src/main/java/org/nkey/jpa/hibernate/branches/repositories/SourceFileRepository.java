package org.nkey.jpa.hibernate.branches.repositories;

import org.nkey.jpa.hibernate.branches.entities.branchable.BranchableEntityId;
import org.nkey.jpa.hibernate.branches.entities.branchable.SourceFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 3:25
 */
public interface SourceFileRepository extends JpaRepository<SourceFileEntity, BranchableEntityId> {
}

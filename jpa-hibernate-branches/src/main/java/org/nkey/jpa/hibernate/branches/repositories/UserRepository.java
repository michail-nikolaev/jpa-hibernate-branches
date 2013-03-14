package org.nkey.jpa.hibernate.branches.repositories;

import org.nkey.jpa.hibernate.branches.entities.basic.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 2:30
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

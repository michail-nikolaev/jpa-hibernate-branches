package org.nkey.jpa.hibernate.branches.repository;

import org.junit.Test;
import org.nkey.jpa.hibernate.branches.SpringTestBase;
import org.nkey.jpa.hibernate.branches.entities.basic.UserEntity;
import org.nkey.jpa.hibernate.branches.entities.branchable.ProjectEntity;
import org.nkey.jpa.hibernate.branches.repositories.ProjectRepository;
import org.nkey.jpa.hibernate.branches.repositories.SourceFileRepository;
import org.nkey.jpa.hibernate.branches.repositories.UserRepository;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 3:27
 */
public class RepositoryTest extends SpringTestBase {
    @Inject
    private UserRepository userRepository;
    @Inject
    private ProjectRepository projectRepository;
    @Inject
    private SourceFileRepository sourceFileRepository;

    @Test
    public void userRepositoryTest() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("username");

        userEntity = userRepository.saveAndFlush(userEntity);
        assertNotNull(userEntity);
        assertNotNull(userEntity.getId());
        assertEquals(0L, userEntity.getVersion().longValue());

        UserEntity userEntity2 = userRepository.findOne(userEntity.getId());
        assertNotNull(userEntity2);
        assertEquals(userEntity.getId(), userEntity2.getId());

        userEntity.setDisplayName("displayName");
        userEntity = userRepository.saveAndFlush(userEntity);
        assertEquals(1L, userEntity.getVersion().longValue());


        userRepository.delete(userEntity);
    }

    @Test
    public void projectRepositoryTest() {
        ProjectEntity projectMaster = new ProjectEntity();
        projectMaster.setProjectName("jpa-hibernate-branches");
        projectMaster.getId().setBranchName("master");

        projectMaster = projectRepository.saveAndFlush(projectMaster);
        assertNotNull(projectMaster);
        assertNotNull(projectMaster.getId().getLogicalId());
        assertNotNull(projectMaster.getId().getBranchName());
        assertEquals(0, projectMaster.getVersion().longValue());

        ProjectEntity projectDev = new ProjectEntity();
        projectDev.setProjectName("jpa-hibernate-branches");
        projectDev.getId().setBranchName("dev");
        projectDev.getId().setLogicalId(projectMaster.getEntityLogicalId());


        projectDev = projectRepository.saveAndFlush(projectDev);
        assertNotNull(projectDev);
        assertNotNull(projectDev.getId().getLogicalId());
        assertNotNull(projectDev.getId().getBranchName());

        assertEquals(projectMaster.getEntityLogicalId(), projectDev.getEntityLogicalId());


        projectMaster.setProjectName("updated");
        projectMaster = projectRepository.saveAndFlush(projectMaster);
        assertEquals(1, projectMaster.getVersion().longValue());

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("username");

        userRepository.delete(userEntity);
        projectRepository.delete(projectMaster);
        projectRepository.delete(projectDev);

    }
}

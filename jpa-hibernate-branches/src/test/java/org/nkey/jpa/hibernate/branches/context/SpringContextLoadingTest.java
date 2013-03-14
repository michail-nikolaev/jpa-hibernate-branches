package org.nkey.jpa.hibernate.branches.context;

import org.junit.Test;
import org.nkey.jpa.hibernate.branches.SpringTestBase;
import org.nkey.jpa.hibernate.branches.repositories.ProjectRepository;
import org.nkey.jpa.hibernate.branches.repositories.SourceFileRepository;
import org.nkey.jpa.hibernate.branches.repositories.UserRepository;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 2:43
 */
public class SpringContextLoadingTest extends SpringTestBase {
    @Inject
    private MockBean mockBean;
    @Inject
    private UserRepository userRepository;
    @Inject
    private ProjectRepository projectRepository;
    @Inject
    private SourceFileRepository sourceFileRepository;


    @Test
    public void testInjects() {
        assertNotNull(mockBean);
        assertNotNull(userRepository);
        assertNotNull(projectRepository);
        assertNotNull(sourceFileRepository);
    }
}

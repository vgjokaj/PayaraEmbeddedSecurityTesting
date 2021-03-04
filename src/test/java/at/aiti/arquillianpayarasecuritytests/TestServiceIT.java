package at.aiti.arquillianpayarasecuritytests;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author gjokaj
 */
@RunWith(Arquillian.class)
public class TestServiceIT {

    @Inject
    private TestService testService;

    @Inject
    private UserRole userRole;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "jee-security-testing.jar")
                .addClasses(TestService.class, UserRole.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
    }

    @Test
    public void testUnprotectedMethod() {
        assertTrue(testService.unprotectedMethod());
    }

    @Test
    public void testProtectedMethod() throws Exception {
        userRole.call(() -> {
            assertTrue(testService.protectedMethod());
            return false;
        });
    }

}

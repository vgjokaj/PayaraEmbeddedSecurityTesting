package at.aiti.arquillianpayarasecuritytests;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author gjokaj
 */
@Stateless
public class TestService {

    @PermitAll
    public boolean unprotectedMethod() {
        return true;
    }

    @RolesAllowed({"User"})
    public boolean protectedMethod() {
        return true;
    }

}

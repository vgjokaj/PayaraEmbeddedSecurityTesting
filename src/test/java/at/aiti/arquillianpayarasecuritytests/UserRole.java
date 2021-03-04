package at.aiti.arquillianpayarasecuritytests;

import java.util.concurrent.Callable;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.Stateless;

/**
 *
 * @author gjokaj
 */
@Stateless
@RunAs("User")
@PermitAll
public class UserRole {

    public <V> V call(Callable<V> callable) throws Exception {
        return callable.call();
    }

}

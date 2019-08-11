import com.jason.jason_ssm.domain.UserInfo;
import com.jason.jason_ssm.service.IUserService;
import com.jason.jason_ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestUserService {
    @Autowired
    private IUserService userService;

    @Autowired
    private UserService userService1;

    @Test
    public void testFindAll() throws Exception {
        List<UserInfo> all = userService.findAll();
        for (UserInfo userInfo : all) {
            System.out.println(userInfo.getUsername());
        }
    }

    @Test
    public void testLoadUser() {
        System.out.println(userService1.loadUserByUsername("jason").getUsername());
        Collection<? extends GrantedAuthority> jason = userService1.loadUserByUsername("jason").getAuthorities();
        for (GrantedAuthority grantedAuthority : jason) {
            System.out.println(grantedAuthority.getAuthority().toString());
        }




    }
}

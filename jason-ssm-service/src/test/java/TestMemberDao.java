import com.jason.jason_ssm.dao.IMemberDao;
import com.jason.jason_ssm.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class TestMemberDao {
    @Autowired
    private IMemberDao IMemberDao;

    @Test
    public void testGetMemberById() {
        Member member = IMemberDao.getMemberById("E61D65F673D54F68B0861025C69773DB");
        System.out.println(member.getName());
    }

}

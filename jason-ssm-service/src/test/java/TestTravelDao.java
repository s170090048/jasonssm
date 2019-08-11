import com.jason.jason_ssm.dao.ITraverlerDao;
import com.jason.jason_ssm.domain.Traveller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class TestTravelDao {
    @Autowired
    private ITraverlerDao traverlerDao;
    @Test
    public void testGetTravellerByOrdersId() throws Exception {
        Traveller traveller = traverlerDao.getTravellerByOrdersId("5DC6A48DD4E94592AE904930EA866AFA");
        System.out.println(traveller.getId());
    }
}

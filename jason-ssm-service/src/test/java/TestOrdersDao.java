import com.jason.jason_ssm.dao.IOrderDao;
import com.jason.jason_ssm.domain.Orders;
import com.jason.jason_ssm.service.IOrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.stream.Location;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestOrdersDao {

@Autowired
private IOrderDao orderDao;
    @Test
    public void testIOrdersDao(){

        List<Orders> all = orderDao.findAll();
        for (Orders orders : all) {
            System.out.println(orders.getId()+orders.getOrderDesc());
        }
    }
}

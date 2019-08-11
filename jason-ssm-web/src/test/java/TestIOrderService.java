import com.github.pagehelper.PageInfo;
import com.jason.jason_ssm.domain.Orders;
import com.jason.jason_ssm.service.IOrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestIOrderService {

    @Autowired
    private IOrdersService ordersService;
    @Test
    public void testfindAll(){
        List<Orders> all = ordersService.findAll(1, 3);
        for (Orders orders : all) {
            System.out.println(orders.getId());
        }

        PageInfo pageInfo=new PageInfo(all);
        System.out.println(pageInfo.getPageSize());
        List<Orders> list = pageInfo.getList();
        for (Orders orders : list) {
            System.out.println(orders.getProduct());

        }

    }



}

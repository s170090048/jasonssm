import com.jason.jason_ssm.dao.IProductDao;
import com.jason.jason_ssm.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class TestProductDao {
    @Autowired
    private IProductDao productDao;

    @Test
    public void testFindAll() throws Exception {
        List<Product> products = productDao.findAll();

        for (Product product : products) {
            System.out.println(product.getProductName());
        }

    }
    @Test
    public void testGetProductById() throws Exception {
        Product product = productDao.getProductById("676C5BD1D35E429A8C2E114939C5685A");
        System.out.println(product.getProductName());
    }
}

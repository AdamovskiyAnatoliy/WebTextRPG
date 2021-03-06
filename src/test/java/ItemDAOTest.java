import com.art.dao.ItemDAO;
import com.art.dao.ItemDAOImp;
import com.art.init.TestHibernateConfig;
import com.art.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    classes = {TestHibernateConfig.class,ItemDAOImp.class})
public class ItemDAOTest {

    @Autowired
    private ItemDAO itemDAO;
    @Test
    public void findByIdTest() {
        Item byId = itemDAO.findById(100);
        assertNull(byId);
        Item byId1 = itemDAO.findById(1);
        assertNotNull(byId1);
        assertEquals("knife",byId1.getName());
    }

}

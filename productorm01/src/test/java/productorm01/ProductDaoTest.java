package productorm01;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ecommerce.product.dao.ProductDao;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.util.HibernateUtil;

public class ProductDaoTest {

	
	private Product product;
	private ProductDao productDao;
	@BeforeEach()
	public void beforeEach() {
		product=new Product("iPhone 3",500000.00);
		productDao=new ProductDao();
	}
	
	@Test
	public void testCreateProduct() {
		Assertions.assertTrue(productDao.createProduct(product));
	}
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(productDao.findAll());
	}
	
	@Test
	public void testFindOneNotNull() {
		product=productDao.findOne(19);
		Assertions.assertNotNull(product);
		System.out.println("id=19 |"+product);
	}
	
	
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(productDao.findOneandDelete(22));
	}
	
	@Test
	public void testFindOneAndUpdate() {
		product.setProductName("Samsung Tab");
		Assertions.assertTrue(productDao.findOneandUpdate(19, product));
	}
}

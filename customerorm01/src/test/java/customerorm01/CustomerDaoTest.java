package customerorm01;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ecommerce.customer.dao.CustomerDao;
import com.ecommerce.customer.model.Customer;
import com.ecommerce.customer.util.HibernateUtil;

public class CustomerDaoTest {

	
	private Customer customer;
	private CustomerDao customerDao;
	@BeforeEach()
	public void beforeEach() {
		customer=new Customer("Justin","7463696963","justin@gmail.com");
		customerDao=new CustomerDao();
	}
	
	@Test
	public void testCreateBook() {
		Assertions.assertTrue(customerDao.createCustomer(customer));
	}
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(customerDao.findAll());
	}
	@Test
	public void testFindOneNotNull() {
		customer=customerDao.findOne(11);
		Assertions.assertNotNull(customer);
		System.out.println("id=11 |"+customer);
	}
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(customerDao.findOneandDelete(10));
	}
	
	@Test
	public void testFindOneAndUpdate() {
		customer.setPhone("6363396636");
		Assertions.assertTrue(customerDao.findOneandUpdate(10, customer));
	}
}

//package ecommerceOTO;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//
//import ecommerceOTO.dao.CustomerDao;
//import ecommerceOTO.model.Customer;
//
//public class CustomerDaoTest {
//	
//	private Customer customer;
//	private CustomerDao customerdao;
//	
//	@BeforeEach()
//	public void beforeEach() {
//		customer=new Customer("vinit","1234567898","vinit@gmail.com","11 road");
//		customerdao=new CustomerDao();
//	}
//
//	@Test
//	public void testcreate(){
//		Assertions.assertTrue(customerdao.create(customer));
//	}
//	@Disabled
//	@Test
//	public void testFindAllNotNull() {
//		Assertions.assertNotNull(customerdao.findAll());
//	}
//	@Disabled
//	@Test
//	public void testFindOneNotNull() {
//		customer=customerdao.findOne(1);
//		Assertions.assertNotNull(customer);
//		System.out.println("id=1 |"+customer);
//	}
//	
//	@Disabled
//	@Test
//	public void testFindOneAndDelete() {
//		Assertions.assertTrue(customerdao.findOneandDelete(4));
//	}
//	@Disabled
//	@Test
//	public void testFindOneAndUpdate() {
//		customer.setName("shruti");
//		Assertions.assertTrue(customerdao.findOneandUpdate(2, customer));
//	}
//
//	
//
//}

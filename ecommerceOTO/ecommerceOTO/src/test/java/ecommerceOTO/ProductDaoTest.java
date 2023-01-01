//package ecommerceOTO;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//import ecommerceOTO.dao.ProductDao;
//import ecommerceOTO.model.Product;
//
//
//public class ProductDaoTest {
//	
//	private Product product;
//	private ProductDao productsdao;
//	
//	@BeforeEach()
//	public void beforeEach() {
//		product=new Product("vinit",1234);
//		productsdao=new ProductDao();
//	}
//
//	@Test
//	public void testcreate(){
//		Assertions.assertTrue(productsdao.create(product));
//	}
//	
//	@Test
//	public void testFindAllNotNull() {
//		Assertions.assertNotNull(productsdao.findAll());
//	}
//
//	@Test
//	public void testFindOneNotNull() {
//		product=productsdao.findOne(2);
//		Assertions.assertNotNull(product);
//		System.out.println("id=2 |"+product);
//	}
//	@Disabled
//	@Test
//	public void testFindOneAndDelete() {
//		Assertions.assertTrue(productsdao.findOneandDelete(4));
//	}
//	
//	@Test
//	public void testFindOneAndUpdate() {
//		product.setPname("Tshirt");
//		Assertions.assertTrue(productsdao.findOneandUpdate(2, product));
//	}
//
//}

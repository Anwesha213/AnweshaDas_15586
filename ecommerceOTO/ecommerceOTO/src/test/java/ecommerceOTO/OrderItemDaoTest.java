package ecommerceOTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import ecommerceOTO.dao.OrderItemDao;
import ecommerceOTO.model.OrderItem;

public class OrderItemDaoTest {
	
	private OrderItem orderitem;
	private OrderItemDao orderitemdao;
	
	@BeforeEach()
	public void beforeEach() {
		orderitem=new OrderItem("shirt","cotton",1234);
		orderitemdao=new OrderItemDao();
	}

	@Test
	public void testcreate(){
		Assertions.assertTrue(orderitemdao.create(orderitem));
	}
	
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(orderitemdao.findAll());
	}
	
	@Test
	public void testFindOneNotNull() {
		orderitem=orderitemdao.findOne(1);
		Assertions.assertNotNull(orderitem);
		System.out.println("id=1 |"+orderitem);
	}
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(orderitemdao.findOneandDelete(4));
	}
	
	@Test
	public void testFindOneAndUpdate() {
		orderitem.setName("shruti");
		Assertions.assertTrue(orderitemdao.findOneandUpdate(1, orderitem));
	}


}

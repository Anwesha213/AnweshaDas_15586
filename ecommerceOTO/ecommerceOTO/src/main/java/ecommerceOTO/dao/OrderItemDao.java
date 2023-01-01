package ecommerceOTO.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import ecommerceOTO.util.HibernateUtil;

import ecommerceOTO.model.OrderItem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class OrderItemDao implements IDao<OrderItem> {
	private Session session;
	private Transaction transaction;
	private Query query;

	@Override
	public boolean create(OrderItem OrderItems) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		if(session.save(OrderItems)!=null) {
			result=true;
		}		
		transaction.commit();
		return result;
	}

	@Override
	public List<OrderItem> findAll() {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from OrderItem");//select * from OrderItem
		final List<OrderItem> customerList=query.list();
		transaction.commit();
		return customerList;
	}

	@Override
	public OrderItem findOne(int id) {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from OrderItem o where o.id="+id);//select * from OrderItem
		final OrderItem orderitem=(OrderItem) query.getSingleResult();
		transaction.commit();
		return orderitem;
	}

	@Override
	public boolean findOneandDelete(int id) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Delete from OrderItem o where o.id=:id");
		query.setParameter("id",id);
		final int statusDelete=query.executeUpdate();		
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if(statusDelete>0) {
			result=true;
		}
		return result;
	}

	@Override
	public boolean findOneandUpdate(int id, OrderItem newObj) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Update OrderItem o set o.name=:name where id=:id");
		query.setParameter("id",id);
		query.setParameter("name",newObj.getName());
		final int statusUpdate=query.executeUpdate();		
		transaction.commit();
		if(statusUpdate>0) {
			result=true;
		}
		return result;
	}

}

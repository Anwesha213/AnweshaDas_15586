package ecommerceOTO.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import ecommerceOTO.model.Customer;
import ecommerceOTO.util.HibernateUtil;

public class CustomerDao implements IDao<Customer> {
	private Session session;
	private Transaction transaction;
	private Query query;

	@Override
	public boolean create(Customer customer) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		if(session.save(customer)!=null) {
			result=true;
		}		
		transaction.commit();
		return result;
	}

	@Override
	public List<Customer> findAll() {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Customer");//select * from Customer
		final List<Customer> customerList=query.list();
		transaction.commit();
		return customerList;
	}

	@Override
	public Customer findOne(int id) {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Customer c where c.id="+id);//select * from Customer
		final Customer customers=(Customer) query.getSingleResult();
		transaction.commit();
		return customers;
	}

	@Override
	public boolean findOneandDelete(int id) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Delete from Customer c where c.id=:id");
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
	public boolean findOneandUpdate(int id, Customer newObj) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Update Customer c set c.name=:name where id=:id");
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

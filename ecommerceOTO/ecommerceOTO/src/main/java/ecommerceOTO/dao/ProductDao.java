package ecommerceOTO.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ecommerceOTO.model.Product;
import ecommerceOTO.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ProductDao implements IDao<Product> {
	private Session session;
	private Transaction transaction;
	private Query query;

	@Override
	public boolean create(Product products) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		if(session.save(products)!=null) {
			result=true;
		}		
		transaction.commit();
		return result;
	}

	@Override
	public List<Product> findAll() {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Product");//select * from Product
		final List<Product> customerList=query.list();
		transaction.commit();
		return customerList;
	}

	@Override
	public Product findOne(int id) {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Product p where p.id="+id);//select * from Product
		final Product product=(Product) query.getSingleResult();
		transaction.commit();
		return product;
	}

	@Override
	public boolean findOneandDelete(int id) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Delete from Product p where p.id=:id");
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
	public boolean findOneandUpdate(int id, Product newObj) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Update Product p set p.pname=:pname where id=:id");
		query.setParameter("id",id);
		query.setParameter("pname",newObj.getPname());
		final int statusUpdate=query.executeUpdate();		
		transaction.commit();
		if(statusUpdate>0) {
			result=true;
		}
		return result;
	}

}

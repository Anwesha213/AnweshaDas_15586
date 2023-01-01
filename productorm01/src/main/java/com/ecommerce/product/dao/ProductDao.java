package com.ecommerce.product.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.util.HibernateUtil;

public class ProductDao implements IDao<Product> {
	private Session session;
	private Transaction transaction;
	private Query query;
	public boolean createProduct(Product product) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		if(session.save(product)!=null) {
			result=true;
		}		
		transaction.commit();
		return result;
	}
	
	


	public List<Product> findAll() {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Product");//select * from product
		final List<Product> productList=query.list();
		transaction.commit();
		return productList;
	}

	public Product findOne(int id) {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Product p where p.productId="+id);//select * from product
		final Product product=(Product) query.getSingleResult();
		transaction.commit();
		return product;
	}

	public boolean findOneandDelete(int productId) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Delete from Product p where p.productId=:id");
		query.setParameter("id",productId);
		final int statusDelete=query.executeUpdate();		
		transaction.commit();
        System.out.println("statusDeleted: "+statusDelete);
		if(statusDelete>0) {
			result=true;
		}
		return result;
	}

	public boolean findOneandUpdate(int id, Product newObj) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Update Product p set p.productName=:productName where productId=:productId");
		query.setParameter("productId",id);
		query.setParameter("productName",newObj.getProductName());
		final int statusUpdate=query.executeUpdate();		
		transaction.commit();
		if(statusUpdate>0) {
			result=true;
		}
		return result;
	}
	
	
	

}

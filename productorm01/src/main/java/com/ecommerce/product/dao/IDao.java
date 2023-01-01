package com.ecommerce.product.dao;

import java.util.List;

public interface IDao<T> {

	 boolean createProduct(T obj);
	 List<T> findAll();
	 T findOne(int id);
	 boolean findOneandDelete(int id);
	 boolean findOneandUpdate(int id,T newObj);
}

package ecommerceOTO.dao;

import java.util.List;

public interface IDao<T> {
	
	boolean create(T obj);
	 List<T> findAll();
	 T findOne(int id);
	 boolean findOneandDelete(int id);
	 boolean findOneandUpdate(int id,T newObj);

}
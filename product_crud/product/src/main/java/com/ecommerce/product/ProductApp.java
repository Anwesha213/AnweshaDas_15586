package com.ecommerce.product;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.product.controller.ProductController;
import com.ecommerce.product.dao.ProductDao;
import com.ecommerce.product.dao.DbConnection;
import com.ecommerce.product.model.Product;

public class ProductApp {


	public static void main(String[] args) {
		try {
			final ProductController productController = 
					ProductController.getProductController();
		    System.out.println("1. Display all Products");
		    System.out.println("2. Product Details by pid");
		    System.out.println("3. Delete Product by pid");
		    System.out.println("4. Update unitPrice by pid");
			int choice=1;
			System.out.println("1. Display all Products");
			mainOptions(productController, choice);
			System.out.println("2. Product Details by pid");
			choice=2;
			mainOptions(productController, choice);
			
			System.out.println("3. Delete Product by pid");
			choice=3;
			mainOptions(productController, choice);
			
			System.out.println("4. Update unitPrice by pid");
			choice=4;
			mainOptions(productController, choice);
			choice=1;
			System.out.println("1. Display all Products");
			mainOptions(productController, choice);
			
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			final DbConnection db=DbConnection.getDb();
			final ProductDao dao=new ProductDao(db);
//			Display all products			
			printProducts(dao);
//			Find by pid
			System.out.println("Find Products by pid");
			final Product product=dao.findOne(1);
			System.out.println(product);
//			Create new Product
			System.out.println("After New product added");
			final Product newProduct=new Product("Hoodies & Jackets",2000000);
			if(dao.createNew(newProduct)) {
				System.out.println(newProduct+" Created ");
			}else {
				System.out.println(newProduct+" Not Created ");
			}
			
			printProducts(dao);
			System.out.println("After Delete");
			if(dao.findOneAndDelete(0)) {
				System.out.println("pid : 0 records deleted");
			}
			printProducts(dao);
			System.out.println("After update");
			product.setunitPrice(9999);
			if(dao.findOneAndUpdate(1,product)) {
				System.out.println(product+" updated");
			}
			printProducts(dao);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void mainOptions(final ProductController productController, int choice) throws SQLException {
		switch(choice) {
		case 1: 
			List<Product> list = productController.findAll();
			for(Product product:list) {
				System.out.println(product);
			}
			break;
		case 2: 
			final Product product = productController.findOne(1);
			System.out.println(product);
			
			break;
		case 3: 
			if(productController.findOneAndDelete(3)) {
				System.out.println("pid: 3 Records Deleted");
			}
			
			break;
		case 4:
			final Product updateProduct = productController.findOne(1);
			updateProduct.setunitPrice(1234);
			if(productController.findOneAndUpdate(3,updateProduct)) {
				System.out.println("pid: 3 Records Updated");
			}
			break;
		case 5:
			final Product newProduct = new Product("Jeans and Yoga-pants", 98765);
			if(productController.createNew(newProduct)) {
				System.out.println(newProduct + " Created in DB");
			}
			break;
		default:
			System.out.println("Please select 1 to 5 options");
			break;
		}
	}

	private static void printProducts(ProductDao dao) throws SQLException {
		final List<Product> list=dao.findAll();
		for(Product a: list) {
			System.out.println(a);
		}
	}

}

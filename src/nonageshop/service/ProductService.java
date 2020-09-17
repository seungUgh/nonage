package nonageshop.service;

import java.sql.Connection;
import java.util.List;

import nonageshop.dao.impl.ProductDaoImpl;
import nonageshop.ds.JndiDS;
import nonageshop.dto.Product;

public class ProductService {
	private ProductDaoImpl  dao = ProductDaoImpl.getInstance();
	private Connection con = JndiDS.getConnection();
	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	public List<Product> getNewProduct() {
		return dao.listNewProduct();
	}
	
}

package com.shoestore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoestore.Entity.Product;
import com.shoestore.Entity.ProductDetail;
import com.shoestore.Repository.ProductDAO;
import com.shoestore.Repository.ProductDetailDAO;

@Service
public class ProductService {

	@Autowired
	ProductDAO dao;

	@Autowired 
	ProductDetailDAO daoDetail;
	
	public List<Product> findAlls() {
		List<Product> list = dao.findProductData();
		return list;
	}

	public List<Product> searchByname(String name) {
		List<Product> list = dao.findByNameLike(name);
		return list;
	}
	
	public Product getByProductId(Integer id) {
		
		Product product = dao.getReferenceById(id);
		return product;
	}
	
	// Lấy ra Sản phẩm chi tiết có ID = 
	public List<ProductDetail> getProductDetailByID(Integer name) {
		List<ProductDetail> list = daoDetail.findByProductId(name);
		return list;
	}
	
}

package com.shoestore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoestore.Entity.Category;
import com.shoestore.Repository.CategoryDAO;

@Service
public class CategoryService {


	@Autowired
	CategoryDAO dao;
	
	public List<Category> getAll(){
		List<Category> list = dao.findAll();	
		return list;
	}
	
	public void saveCate(Category category){					
		dao.save(category);		
	}
	
	public void delCate(String id){	
		Category category = dao.getReferenceById(id);	
		dao.delete(category);		
	}
	
	public Category getByCate(String idCate){		
		Category Category = dao.getReferenceById(idCate);		
		
		return Category;
	}
}

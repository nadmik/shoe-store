package com.shoestore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoestore.Entity.Category;

@Repository
public interface CategoryDAO  extends JpaRepository<Category, String>{

	@Query(value = "select p.category from Product p where p.id =?1")
	Category getCate(Integer id);
	
}

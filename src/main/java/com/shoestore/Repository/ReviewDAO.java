package com.shoestore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoestore.Beans.Review;

@Repository
public interface ReviewDAO  extends JpaRepository<Review, Integer>{

}

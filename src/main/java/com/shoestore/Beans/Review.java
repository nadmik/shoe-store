package com.shoestore.Beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	@Id
	//@Column(name = "id")
	private Integer id;
	
	//@Column(name = "id")
	private String username;
	//@Column(name = "reviews")
	private String reviews;
}

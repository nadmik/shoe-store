package com.shoestore.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Categories")
public class Category {
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "name")
	private String name;	
	
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL)
	List<Product> product;
}

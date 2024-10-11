package com.shoestore.Entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Products")
public class Product {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private float price;
		
	
	@Column(name="createdate")
	private Date createdate;
	
	@Column(name="quantity")
	private int quantity = 0;
	
	@Column(name="description")
	private String description;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="imgp")
	private String imgProduct; 
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	Category category;
	
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL)
	List<ProductDetail> productDetails;
	

}

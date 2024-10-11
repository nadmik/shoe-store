package com.shoestore.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "productdetail")
public class ProductDetail {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private Integer id;
	

	@Column(name="size")
	private String size;
	
	@Column(name="color")
	private String color;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productid", referencedColumnName = "id")
	Product product;
	
	@OneToMany(mappedBy="productDetail", cascade = CascadeType.ALL)
	List<ProductImg> productimgs;
}

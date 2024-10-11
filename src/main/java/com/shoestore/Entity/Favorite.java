package com.shoestore.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Favorite", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"productid", "userid"})
})
public class Favorite {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private Integer id;		
	
	@Column(name = "reviews")
	private String reviews;	
	
	@ManyToOne @JoinColumn(name="productid")
	Product product;
	
	@ManyToOne @JoinColumn(name="userid")
	User User;	
}

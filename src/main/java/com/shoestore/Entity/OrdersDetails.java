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
@Table(name="ordersdetails", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"orderid", "productid"})
})
public class OrdersDetails {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="price")
	private float price;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@ManyToOne @JoinColumn(name="productid")
	Product product;
	
	@ManyToOne @JoinColumn(name="orderid")
	Order order;
}

package com.shoestore.Entity;

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
@Table(name = "orders")
public class Order {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private Integer id;		
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "createdate")
	private java.util.Date createdate;

	@ManyToOne()
	@JoinColumn(name="usernameid" , referencedColumnName = "id")
	private User user;
	
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL)
	List<OrdersDetails> orderDetail;
	
}

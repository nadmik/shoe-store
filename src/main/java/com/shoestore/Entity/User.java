package com.shoestore.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private Integer id;
	
	@NotBlank(message = "User Name Not Null")
	@NotNull(message = "User Name Not Null")
	private String username;

	@Column(name = "password")
	@NotBlank(message = "Password Not Null")
	private String password;

	@Column(name = "fullname")
	@NotBlank(message = "Full Name Not Null")
	private String fullname;

	@Column(name = "email")
	@NotBlank(message = "Email Not Null")
	private String email;

	@Column(name = "activated")
	private Integer activated;

	@Column(name = "admin")
	private Integer admin;

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Order> orther;
	
	
}

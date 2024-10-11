package com.shoestore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoestore.Entity.Order;
import com.shoestore.Repository.OrderDAO;

@Service
public class OrderService {
	@Autowired
	private OrderDAO dao;

	public List<Order>getAllOrder(){
		List<Order> list = dao.findAll();
		return list;
	}
}

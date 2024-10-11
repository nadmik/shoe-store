package com.shoestore.ControllersAdmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shoestore.Entity.Product;
import com.shoestore.Repository.ProductDAO;
import com.shoestore.Service.FavoriteService;

@Controller
public class Admin_ThongKeProduct {

	@Autowired
	FavoriteService service;
	@Autowired
	ProductDAO dao;
	@GetMapping("index/favotite")
	public String viewFavorite(Model model) {
		List<Object[]> list = service.getAllFavoriteProductDataUser();
		model.addAttribute("list", list);
		return "Admin/tblFavoriteProduct";
	}
	
	@GetMapping("index/inventory")
	public String inventory(Model model) {
		List<Product> list = dao.findProductInventory();
		model.addAttribute("listInventory", list);
		return "Admin/tblInventory";
	}
	
}

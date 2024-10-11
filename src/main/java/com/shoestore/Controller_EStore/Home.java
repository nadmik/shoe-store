package com.shoestore.Controller_EStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shoestore.Entity.Favorite;
import com.shoestore.Entity.Product;
import com.shoestore.Entity.User;
import com.shoestore.Repository.FavoriteDAO;
import com.shoestore.Repository.ProductDAO;
import com.shoestore.Repository.UserDAO;
import com.shoestore.Service.HomeService;
import com.shoestore.Utils.CookieService;

@Controller

public class Home {

	@Autowired
	HomeService serviceHome;

	@Autowired
	FavoriteDAO Fdao;

	@Autowired
	ProductDAO Pdao;

	@Autowired
	UserDAO Udao;

	@Autowired
	CookieService cookieService;

	@GetMapping("/home")
	public String wishList(Model model) {
		String userName = cookieService.getValue("uName");
		if(!userName.equals("")) {		
			User user = Udao.findByUserName(userName);
			model.addAttribute("admin", user);
			model.addAttribute("count", serviceHome.getCountFavorite(user.getId()));
		}
			
		model.addAttribute("listFeatured", serviceHome.getProductDataFavorite());// Sản phẩm TOP 6 được yêu thích nhiều																		// nhất
		model.addAttribute("listRecent", serviceHome.getProductDataTop6Date()); // sản phẩm mới đăng
		return "User/homeShop";
	}

	@GetMapping("cart/{id}")
	public String cart(Model model, @PathVariable("id") Integer id) {

		return "redirect:/product-detail";
	}

	@GetMapping("/favorite/{id}")
	public String favorite(Model model, @PathVariable("id") Integer id) {


			Favorite favorite = new Favorite();
			String userName = cookieService.getValue("uName");
			User user = Udao.findByUserName(userName);
			Product product = Pdao.getReferenceById(id);

			favorite.setProduct(product);
			favorite.setUser(user);
			Fdao.save(favorite);	
		return "redirect:/home";
	}

}

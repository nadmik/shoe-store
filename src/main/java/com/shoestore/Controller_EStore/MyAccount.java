package com.shoestore.Controller_EStore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shoestore.Entity.Order;
import com.shoestore.Entity.OrdersDetails;
import com.shoestore.Entity.User;
import com.shoestore.Repository.OrderDAO;
import com.shoestore.Repository.Order_DetailDAO;
import com.shoestore.Repository.UserDAO;
import com.shoestore.Service.Order_DetailService;
import com.shoestore.Service.UserService;
import com.shoestore.Utils.CookieService;
import com.shoestore.Utils.HashPass;

@Controller
public class MyAccount {

	@Autowired
	UserDAO dao;
	@Autowired
	UserService userService;

	@Autowired
	CookieService cookie;

	@Autowired
	Order_DetailService detailService;

	@Autowired
	OrderDAO daoO;

	@Autowired
	Order_DetailDAO daoPD;

	@Autowired
	HashPass hashPass;

	private Integer idUser;
	private String password;

	@GetMapping("/account/order")
	public String viewOrder(Model model, @ModelAttribute("accountUser") User us) {
		String username = cookie.getValue("uName");
		if (us.equals(null)) {
			return "redirect:/login";
		}
		if (username != null) {
			us = userService.findUser(username);

			List<OrdersDetails> listOrder = detailService.findAllOrderById(us.getId());
			model.addAttribute("listOrder", listOrder);
		}

		return "User/_order";
	}

	@GetMapping("/account/payment")
	public String viewsPayment() {
		return "User/_payment";
	}

	@GetMapping("/account/address")
	public String viewAddress() {
		return "User/_address";
	}

	@GetMapping("/account")
	public String account() {
		return "User/MyAccount";
	}

	@GetMapping("/account/editaccount")
	public String viewProfile(Model model, @ModelAttribute("accountUser") User us) {
		// lấy tên username trong cookie
		String username = cookie.getValue("uName");

		if (us.equals(null)) {
			return "redirect:/login";
		}
		if (username != null) {
			// set username trong findUser để lấy ra user

			us = userService.findUser(username); // để tính bảo mật nên trên profile k hiển thị mật khẩu
			idUser = us.getId();
			password = us.getPassword();

			model.addAttribute("accountUser", us);

		}
		return "User/_editProfile";

	}

	@PostMapping("/account/editaccount/save")
	public String saveProfile(Model model, @ModelAttribute("accountUser") User us) {

		if (us != null) {
			us.setId(idUser);
			us.setPassword(password);
			userService.addUser(us);

			model.addAttribute("message", true);
		} else {
			model.addAttribute("message", false);
		}
		return "User/_editProfile";
	}

	// ----------------------------------------------------------------------------------------

	@GetMapping("/account/editaccount/savePass")
	public String viewsaveProfilePass() {
		return "User/_changePass";
	}

	@PostMapping("/account/editaccount/savePass")
	public String saveProfilePass(Model model, @RequestParam("password") String password,
			@RequestParam("passwordNew") String passwordNew, @RequestParam("passwordConfirm") String passwordConfirm) {
		String username = cookie.getValue("uName");
		User us = userService.findUser(username);
		// Boolean success = false;
		if (us != null) {
			Boolean checkPass = hashPass.verify(password, us.getPassword());
			if (checkPass == true && passwordNew.equals(passwordConfirm)) {
				us.setPassword(hashPass.hash(passwordConfirm));
				dao.save(us);

				model.addAttribute("message", true);
			} else {
				model.addAttribute("message", false);
			}
		}
		return "User/_changePass";
	}

	// -----------------------------------------------------------------------------------------
	@GetMapping("/cancel-order/{id}")
	public String Cancel(@PathVariable("id") Integer idO) {
		Order order = daoO.getReferenceById(idO);
		daoO.delete(order);
		return "redirect:/account";
	}

	@ResponseBody
	@GetMapping("/order-viewid/{id}")
	public List<Object[]> detail(Model model, @PathVariable("id") Integer idO) {
		List<Object[]> object = daoPD.findAllOrderDetailUser(idO);
		model.addAttribute("detail", daoPD.findAllOrderDetailUser(idO));
		return object;
	}
}

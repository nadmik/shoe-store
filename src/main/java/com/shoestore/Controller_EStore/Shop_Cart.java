package com.shoestore.Controller_EStore;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shoestore.Repository.CategoryDAO;
import com.shoestore.Repository.ProductDAO;
import com.shoestore.Service.AddToCartService;

@Controller
public class Shop_Cart {

	@Autowired
	ProductDAO Pdao;

	@Autowired
	HttpServletRequest request;

	@Autowired
	AddToCartService cartService;

	@Autowired
	CategoryDAO daoC;

	@Autowired
	AddToCartService addToCartService;

	int idP;

	@GetMapping("/shop-cart")
	public String shopCart(Model model) {
//		for (ProductDetail productDetail : listPD) {
//			System.out.println(productDetail.getProduct().getCategory().getName());
//		}
//		
//		model.addAttribute("countCart",listPD.size());
//		model.addAttribute("details",listPD);

//		for (Cart productDetail : addToCartService.getAll()) {
//			System.out.println("category: "+productDetail.getCategory());
//		}
//		model.addAttribute("nhien",Pdao.findProductData());
//		model.addAttribute("cart",listPD);
		model.addAttribute("products", addToCartService.getAll());
		model.addAttribute("total", addToCartService.getAmount());
		model.addAttribute("size", addToCartService.getTotalProduct());
		return "User/shopCart";

	}

	@PostMapping("/shop-cart")
	public String removeCart(@RequestParam("id") Integer id) {
		addToCartService.remove(id);
		return "redirect:/shop-cart";
	}

//	@GetMapping("/cart")
//	public String cart(Model model) {
//		for (Product product : Pdao.findProductDataTop6Brand("bitits")) {
//			System.out.println("Brand: "+product.getBrand());
//		}
//		System.out.println(Pdao.findProductDataTop6Brand("bitits"));
//		model.addAttribute("products",Pdao.findAll());
//		model.addAttribute("products",addToCartService.getAll());
//		return "User/shopCart";
//	}

//	
//	Product product = new Product();
//	Category cate = new Category();
//	private List<Product> pro = new ArrayList<>();
//	@ResponseBody
//	@GetMapping("/shop-carts")
//	public List<ProductDetail> shopCarts (Model model) {
//		
//		return listPD;
//	}
//	int i=0;
//	@GetMapping("/addtocart")
//	public String addtoCart(Model model,
//			@RequestParam("id") int id,
//			@RequestParam("quantity") int quantity,
//			@RequestParam("color") String color,
//			@RequestParam("size") String size
//		
//			
//	) {
//		HttpSession session = request.getSession();
//		product = Pdao.getReferenceById(1);
//		ProductDetail productDetail = new ProductDetail();
//		productDetail.setId(i++);
//		productDetail.setColor(color);
//		productDetail.setSize(size);
//		productDetail.setProduct(product);
//		product.setProductDetails(listPD);
//		pro.add(product);
//		cate.setProduct(pro);
//	
//		listPD.add(productDetail);
//		
//		session.setAttribute("order", productDetail);
//		session.setAttribute("cate", cate);
//		idP = id;
//		
//		return "redirect:/product-detail" + "?id="+ product.getId();
//	}

//	List<OrdersDetails> list = new ArrayList<>();
//	OrdersDetails details = new OrdersDetails();
//	Order order = new Order();
//	Product product = new Product();
//	Category cate = new Category();
//	
//	@GetMapping("/addtocart")
//	public String addtoCart(	Model model,
//			@RequestParam("id") int id,
//			@RequestParam("quantity") int quantity,
//			@RequestParam("color") String color,
//			@RequestParam("size") String size
//		
//			
//	) {
//		Product pr = Pdao.getReferenceById(id);
//		pr.setCategory(new Category());
//	
//		if(pr!=null) {
//			HttpSession session = request.getSession();
//			if(session.getAttribute("order") == null) {
//				
//				product.setId(pr.getId());
//				product.setBrand(pr.getBrand());
//				product.setCategory(pr.getCategory());
//				product.setCreatedate(pr.getCreatedate());
//				product.setDescription(pr.getDescription());
//				product.setImgProduct(pr.getImgProduct());
//				product.setName(pr.getName());
//				product.setPrice(pr.getPrice());
//				product.setQuantity(pr.getQuantity());
//				
//				details.setId(1);
//				details.setStatus(1);
//				details.setQuantity(quantity);
//				details.setPrice(pr.getPrice());
//				details.setProduct(product);
//				
//				list.add(details);
//				
//				order.setOrderDetail(list);
//				session.setAttribute("order", order);
//			}else {
//			//	order = (Order)session.getAttribute("order");
//				List<OrdersDetails> list =  order.getOrderDetail();
//				boolean check = false;
//				for (OrdersDetails ordersDetails : list) {
//					if(ordersDetails.getId() == pr.getId()) {
//						ordersDetails.setQuantity(ordersDetails.getQuantity()+quantity);
//						check = true;
//					}
//				}
//				if(check == false) {
//					OrdersDetails details = new OrdersDetails();
//					details.setQuantity(quantity);
//					details.setPrice(product.getPrice());
//					details.setProduct(product);
//					list.add(details);
//				}
//				session.setAttribute("order", order);
//				
//			}
//		
//			for (OrdersDetails details : order.getOrderDetail()) {
//					System.out.println(details.getProduct().getName());
//			}
//				
//			
//		}
//		return "redirect:/product-detail" + "?id="+ pr.getId();
//	}

}

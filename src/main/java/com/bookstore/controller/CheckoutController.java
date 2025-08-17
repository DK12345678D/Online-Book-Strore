package com.bookstore.controller;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.model.Book;
import com.bookstore.model.Customer;
import com.bookstore.service.BillingService;
import com.bookstore.service.EmailService;
import com.bookstore.service.ShoppingCartService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

	private final BillingService billingService;
	private final EmailService emailService;
	private final ShoppingCartService shoppingCartService;

	public CheckoutController(BillingService billingService, EmailService emailService,
			ShoppingCartService shoppingCartService) {
		this.billingService = billingService;
		this.emailService = emailService;
		this.shoppingCartService = shoppingCartService;
	}

	@GetMapping(value = { "", "/" })
	public String checkout(Model model) {
		List<Book> cart = shoppingCartService.getCart();
		if (cart.isEmpty()) {
			return "redirect:/cart";
		}
		model.addAttribute("customer", new Customer());
		model.addAttribute("productsInCart", cart);
		model.addAttribute("totalPrice", shoppingCartService.totalPrice().toString());
		model.addAttribute("shippingCosts", shoppingCartService.getshippingCosts());
		return "checkout";
	}

	@PostMapping("/placeOrder")
	public String placeOrder(@Valid Customer customer, BindingResult result, RedirectAttributes redirect) {
	    if (result.hasErrors()) {
	        return "/checkout";
	    }

	    // 1. Create the order
	    billingService.createOrder(customer, shoppingCartService.getCart());

	    // 2. Send a simple email
	    try {
	        String subject = "Bookstore - Order Confirmation";
	        String message = "Your order has been confirmed.";
	        emailService.sendEmail(customer.getEmail(), subject, message);
	    } catch (Exception e) {
	        e.printStackTrace();
	        redirect.addFlashAttribute("errorMessage", "Order placed but email could not be sent.");
	        shoppingCartService.emptyCart();
	        return "redirect:/cart";
	    }

	    // 3. Empty the shopping cart
	    shoppingCartService.emptyCart();

	    // 4. Add flash message
	    redirect.addFlashAttribute("successMessage", "The order is confirmed, check your email.");

	    return "redirect:/cart";
	}

	

}
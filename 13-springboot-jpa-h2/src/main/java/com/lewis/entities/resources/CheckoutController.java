package com.lewis.entities.resources;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lewis.ecommerce.dto.Purchase;
import com.lewis.ecommerce.dto.PurchaseResponse;
import com.lewis.repositories.services.CheckoutService;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin( "http://localhost:4200/")
public class CheckoutController {

	
	private CheckoutService checkoutService;
	
	public CheckoutController(CheckoutService checkoutService)
	{
		this.checkoutService = checkoutService;
	}
	
	
	@PostMapping("/purchase")
	public PurchaseResponse placeOrder(@RequestBody Purchase purchase)
	{
		PurchaseResponse purchaseResponse = 
				checkoutService.placeOrder(purchase);
		
		return purchaseResponse;
		
	}
}

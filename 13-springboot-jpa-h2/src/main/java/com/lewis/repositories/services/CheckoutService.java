package com.lewis.repositories.services;

import com.lewis.ecommerce.dto.Purchase;
import com.lewis.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);
	

}

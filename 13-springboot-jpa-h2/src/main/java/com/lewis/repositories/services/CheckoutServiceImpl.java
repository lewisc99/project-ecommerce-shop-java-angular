package com.lewis.repositories.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lewis.ecommerce.dto.Purchase;
import com.lewis.ecommerce.dto.PurchaseResponse;
import com.lewis.entities.Customer;
import com.lewis.entities.Order;
import com.lewis.entities.OrderItem;
import com.lewis.repositories.CustomerRepository;


@Service
public class CheckoutServiceImpl implements CheckoutService {

	 
	 private CustomerRepository customerRepository;
	    
	    
	    @Autowired
	    public CheckoutServiceImpl(CustomerRepository customerRepository)
	    {
	        this.customerRepository = customerRepository;
	    }

	
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
	
	
		Order order = purchase.getOrder();
		
		
		LocalDate localDate = LocalDate.now();
		
		Date date = new Date();
		ZoneId defaultZoneId = ZoneId.systemDefault();
         date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

	
		order.setDateCreated(date);
		
		String orderTrackingNumber = generateOrderTrackingNumber();
		
		
		order.setOrderTrackingNumber(orderTrackingNumber);
		
		// populate order with orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		
		orderItems.forEach(item -> order.add(item));
		
		
		//populate with billingAddress and shippingAddress
		order.setShippingAddress(purchase.getShippingAddress());
		
		
		//populate customer with order
		Customer customer = purchase.getCustomer();
		
		customer.add(order);
		
		customerRepository.save(customer);
		
		
		//return a response
		
		
		
		return new PurchaseResponse(orderTrackingNumber);
		
		
	}

	
	private String generateOrderTrackingNumber()
	{
		return UUID.randomUUID().toString();
	}
}

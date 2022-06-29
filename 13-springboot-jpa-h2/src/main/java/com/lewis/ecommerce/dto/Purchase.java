package com.lewis.ecommerce.dto;

import java.util.Set;

import com.lewis.entities.Address;
import com.lewis.entities.Customer;
import com.lewis.entities.Order;
import com.lewis.entities.OrderItem;

public class Purchase {

	
	private Customer customer;
	private Address shippingAddress;

	private Order order;
	private Set<OrderItem> orderItems;
	
	public Purchase() {}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	
	
}

package com.sampleprograms.spring.orm.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.sampleprograms.spring.orm.model.Order;

public class OrderDaoImpl implements OrderDao {
	
	private final SessionFactory sessionFactory;

	public OrderDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	public List<Order> findAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteOrderByName(String name) {
		// TODO Auto-generated method stub
		
	}

	public Order findBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

}

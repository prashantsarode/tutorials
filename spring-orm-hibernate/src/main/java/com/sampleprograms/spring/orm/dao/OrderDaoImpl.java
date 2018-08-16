package com.sampleprograms.spring.orm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sampleprograms.spring.orm.model.Order;

@Service
public class OrderDaoImpl implements OrderDao {
	
	private final SessionFactory sessionFactory;

	public OrderDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrder(Order order) {
		getSession().persist(order);
	}

	@Transactional
	public List<Order> findAllOrders() {
		return ((List<Order>) getSession().createCriteria(Order.class).list());
	}

	@Transactional
	public void deleteOrderByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public Order findByName(String name) {
		return (Order) getSession().createCriteria(Order.class).add(Restrictions.eq("name", name)).uniqueResult();
	}

	@Transactional
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
}

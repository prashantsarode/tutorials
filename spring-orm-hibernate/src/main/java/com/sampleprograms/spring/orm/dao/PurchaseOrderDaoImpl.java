package com.sampleprograms.spring.orm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sampleprograms.spring.orm.model.PurchaseOrder;

@Service
public class PurchaseOrderDaoImpl implements PurchaseOrderDao {
	
	private final SessionFactory sessionFactory;

	public PurchaseOrderDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void savePurchaseOrder(PurchaseOrder order) {
		getSession().save(order);
	}

	@Transactional
	public List<PurchaseOrder> findAllOrders() {
		return ((List<PurchaseOrder>) getSession().createCriteria(PurchaseOrder.class).list());
	}

	@Transactional
	public void deleteOrderByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public PurchaseOrder findByName(String name) {
		return (PurchaseOrder) getSession().createCriteria(PurchaseOrder.class).add(Restrictions.eq("name", name)).uniqueResult();
	}

	@Transactional
	public void updateOrder(PurchaseOrder order) {
		// TODO Auto-generated method stub
		
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
}

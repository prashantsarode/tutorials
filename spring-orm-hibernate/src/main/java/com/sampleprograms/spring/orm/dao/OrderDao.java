package com.sampleprograms.spring.orm.dao;

import java.util.List;

import com.sampleprograms.spring.orm.model.Order;

public interface OrderDao {
	
	void saveOrder(Order order);
    
    List<Order> findAllOrders();
     
    void deleteOrderByName(String name);
     
    Order findBySsn(String ssn);
     
    void updateOrder(Order order);

}

package com.sampleprograms.spring.orm.dao;

import java.util.List;

import com.sampleprograms.spring.orm.model.PurchaseOrder;

public interface PurchaseOrderDao {
	
	void savePurchaseOrder(PurchaseOrder order);
    
    List<PurchaseOrder> findAllOrders();
     
    void deleteOrderByName(String name);
     
    PurchaseOrder findByName(String name);
     
    void updateOrder(PurchaseOrder order);

}

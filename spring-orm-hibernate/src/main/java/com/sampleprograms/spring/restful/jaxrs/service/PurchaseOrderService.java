package com.sampleprograms.spring.restful.jaxrs.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sampleprograms.spring.orm.dao.PurchaseOrderDao;
import com.sampleprograms.spring.orm.model.PurchaseOrder;

public class PurchaseOrderService {
	
	private final PurchaseOrderDao orderDao;
	
	public PurchaseOrderService(PurchaseOrderDao orderDao) {
		super();
		this.orderDao = orderDao;
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PurchaseOrderResponse helloWorld(PurchaseOrderRequest purchaseOrderRequest) {
		PurchaseOrder order = new PurchaseOrder();
		order.setName(purchaseOrderRequest.getName());
		order.setTotalCost(purchaseOrderRequest.getTotalCost());
		orderDao.savePurchaseOrder(order);
		PurchaseOrderResponse purchaseOrderResponse = new PurchaseOrderResponse();
		purchaseOrderResponse.setOrderId(order.getOrderId());
		return purchaseOrderResponse;
	}
	
	@GET
	@Path("/GetAllPOs")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PurchaseOrder> getAllPOs() {
		return orderDao.findAllOrders();
	}
}

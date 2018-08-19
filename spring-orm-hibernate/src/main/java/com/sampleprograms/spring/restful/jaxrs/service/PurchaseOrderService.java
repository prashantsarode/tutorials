package com.sampleprograms.spring.restful.jaxrs.service;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

	@GET
	@Path("/create/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public PurchaseOrder helloWorld(@PathParam("name") String name) {
		PurchaseOrder order = new PurchaseOrder();
		order.setName(name);
		order.setTotalCost(new BigDecimal(100));
		orderDao.savePurchaseOrder(order);
		return order;
	}
	
}

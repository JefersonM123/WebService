package com.course.dto;

import java.io.Serializable;
import java.time.Instant;

import com.course.entities.Order;
import com.course.entities.User;
import com.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	private Integer orderStatus;
	private Long clientId;
	private String clientName;
	private String clientEmail;

	public OrderDTO() { }

	public OrderDTO(Long id, Instant moment, Integer orderStatus, Long clientId, String clientName,
			String clientEmail) {
		super();
		this.id = id;
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientEmail = clientEmail;
	}

	public OrderDTO(Order order) {
		if(order.getClient() == null) {
			throw new IllegalArgumentException("Error instantiating OrderDTO: client was null");
		}
		
		this.id = order.getId();
		this.moment = order.getMoment();
		this.orderStatus = order.getOrderStatus().getCode();
		this.clientId = order.getClient().getId();
		this.clientName = order.getClient().getName();
		this.clientEmail = order.getClient().getEmail();		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	
	public Order toEntity() {
		User client  = new User(clientId, clientName, clientEmail, null, null);
		return new Order(id, moment, OrderStatus.valueOf(orderStatus),client);		
	}
}

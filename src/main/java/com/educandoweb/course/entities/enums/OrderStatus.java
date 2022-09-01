package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	//Construtor:
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//Get para acessar o enum:
	public int getCode() {
		return code;
	}
	
	//Método para retornar o valor do ENUM:
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value: OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid order status code");
		
	}
	

}

package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ORDERS")
public class OrderEntity 
{
	@Id
	Long id;
	
	@Column("ORDER_NO")
	String orderNo;
	
	@Column("PRODUCT_NAME")
	String productName;
	
	@Column("PRICE")
	float price;
	
	@Column("QUANTITY")
	int quantity;
	
	public OrderEntity()
	{
	}
	
	public OrderEntity(long idVal, String orderNoVal, String nameVal, float priceVal, int quantityVal) {
		this.id = idVal;
		this.orderNo = orderNoVal;
		this.productName = nameVal;
		this.price = priceVal;
		this.quantity = quantityVal;	
	}
	
	public long getId()
	{
		return this.id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getOrderNo()
	{
		return this.orderNo;
	}
	
	public void setOrderNo(String orderNo)
	{
		this.orderNo = orderNo;
	}
	
	public String getProductName()
	{
		return this.productName;
	}
	
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	
	public float getPrice()
	{
		return this.price;
	}
	
	public void setPrice(float price)
	{
		this.price = price;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

}

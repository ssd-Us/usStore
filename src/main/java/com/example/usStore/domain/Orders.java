package com.example.usStore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("serial")
public class Orders implements Serializable {

  /* Private Fields */
  private int orderId;
  private String userId;
  private String courier;
  private double totalPrice;
  private String creditCard;
  private String expiryDate;
  private String cardType;
  private String locale;
  private Date orderDate;
  private String shipAddress1;
  private String shipAddress2;
  private String shipCity;
  private String shipZip;
  private String shipCountry;
  private String shipToName;
  private String billAddress1;
  private String billAddress2;
  private String billCity;
  private String billZip;
  private String billCountry;
  private String billToName;
  private String status;

  /* JavaBeans Properties */
	public int getOrderId() { return orderId;}
	
	public void setOrderId(int orderId) {this.orderId = orderId;}
	
	public String getUserId() {return userId;}
	
	public void setUserId(String userId) {this.userId = userId;}
	
	public String getCourier() {return courier;}
	
	public void setCourier(String courier) {this.courier = courier;}
	
	public double getTotalPrice() {return totalPrice;}
	
	public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}
	
	public String getCreditCard() {return creditCard;}
	
	public void setCreditCard(String creditCard) {this.creditCard = creditCard;}
	
	public String getExpiryDate() {return expiryDate;}
	
	public void setExpiryDate(String expiryDate) {this.expiryDate = expiryDate;}
	
	public String getCardType() {return cardType;}
	
	public void setCardType(String cardType) {this.cardType = cardType;}
	
	public String getLocale() {return locale;}
	
	public void setLocale(String locale) {	this.locale = locale;}
	
	public Date getOrderDate() {return orderDate;}
	
	public void setOrderDate(Date orderDate) {this.orderDate = orderDate;}
	
	public String getShipAddress1() {return shipAddress1;}
	
	public void setShipAddress1(String shipAddress1) {this.shipAddress1 = shipAddress1;}
	
	public String getShipAddress2() {return shipAddress2;}
	
	public void setShipAddress2(String shipAddress2) {this.shipAddress2 = shipAddress2;}
	
	public String getShipCity() {return shipCity;}
	
	public void setShipCity(String shipCity) {this.shipCity = shipCity;}
	
	public String getShipZip() {return shipZip;}
	
	public void setShipZip(String shipZip) {this.shipZip = shipZip;}
	
	public String getShipCountry() {return shipCountry;}
	
	public void setShipCountry(String shipCountry) {this.shipCountry = shipCountry;}
	
	
	public String getShipToName() {return shipToName;}

	public void setShipToName(String shipToName) {this.shipToName = shipToName;}

	public String getBillToName() {return billToName;}

	public void setBillToName(String billToName) {this.billToName = billToName;}

	public String getBillAddress1() {return billAddress1;}
	
	public void setBillAddress1(String billAddress1) {this.billAddress1 = billAddress1;}
	
	public String getBillAddress2() {return billAddress2;}
	
	public void setBillAddress2(String billAddress2) {this.billAddress2 = billAddress2;	}
	
	public String getBillCity() {	return billCity;}
	
	public void setBillCity(String billCity) {this.billCity = billCity;}
	
	public String getBillZip() {return billZip;}
	
	public void setBillZip(String billZip) { this.billZip = billZip;}
	
	public String getBillCountry() { return billCountry;}
	
	public void setBillCountry(String billCountry) {this.billCountry = billCountry;}
	
	
	public List<LineItem> getLineItems() {return lineItems;}

	public void setLineItems(List<LineItem> lineItems) {this.lineItems = lineItems;}

	private List<LineItem> lineItems = new ArrayList<LineItem>();

	public String getStatus() { return status; }

	public void setStatus(String status) { this.status = status; }
  

	
/* Public Methods */



	public void initOrder(Account account, Cart cart, String status) { //여기서 status는 OrderStatus테이블에서 가져옴 
	    userId = account.getUserId();
	    orderDate = new Date();
	
	    shipToName = account.getName();
	    shipAddress1 = account.getAddress1();
	    shipAddress2 = account.getAddress2();
	    shipCity = account.getCity();
	    shipZip = account.getZip();
	    shipCountry = account.getCountry();
	
	    billToName = account.getName();
	    billAddress1 = account.getAddress1();
	    billAddress2 = account.getAddress2();
	    billCity = account.getCity();
	    billZip = account.getZip();
	    billCountry = account.getCountry();
	
	    totalPrice = cart.getSubTotal();
	
	    creditCard = "999 9999 9999 9999";
	    expiryDate = "12/03";
	    cardType = "Visa";
	    courier = "UPS";
	    locale = "CA";
	    status = "P";
	
	    Iterator<CartItem> i = cart.getAllCartItems();
	    while (i.hasNext()) {
	      CartItem cartItem = (CartItem) i.next();
	      addLineItem(cartItem);
	    }
	  }

	public void addLineItem(CartItem cartItem) {
	    LineItem lineItem = new LineItem(lineItems.size() + 1, cartItem);
	    addLineItem(lineItem);
	  }
	
	public void addLineItem(LineItem lineItem) {
	    lineItems.add(lineItem);
	  }
}
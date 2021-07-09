package com.lee.CarCenterApp.Model;

import com.lee.CarCenterApp.controller.CarController;

public class CarModify {
	private String cause; //고장이 난 원인
	private int dateIn; //접수 일자
	private int dateOut; //수리완료 일자
	private int price; //수리비
	private CarController carCon;
	
	int priceSum;
	
	public CarModify(CarController carCon) {
		this.carCon = carCon;
	}
	
	public CarModify(String cause, int dateIn, int dateOut, int price) {
		super();
		this.cause = cause;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.price = price;
	}
	
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}

	public int getDateIn() {
		return dateIn;
	}
	public void setDateIn(int dateIn) {
		this.dateIn = dateIn;
	}

	public int getDateOut() {
		return dateOut;
	}
	public void setDateOut(int dateOut) {
		this.dateOut = dateOut;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String str = "수리내역 : " + cause + "\n";
		str += "접수날짜 : " + dateIn + "\n";
		str += "수리완료일 : " + dateOut + "\n";
		str += "수리비 : " + price + "\n";
		
		return str;
	}

	public void PriceSum() {
		priceSum = priceSum + price;
	}
	
}

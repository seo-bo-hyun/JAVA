package com.lee.CarCenterApp.Model;

public class Car {
	private String model;
	private int year; //연식
	
	public Car(String model, int year) {
		super();
		this.model = model;
		this.year = year;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		
		String str = "수리차량 : " + model + "\n";
		str += "연식 : " + year + "\n";
		
		return str;
	}

	

}

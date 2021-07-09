package com.lee.CarCenterApp.view;

import java.util.Scanner;

import com.lee.CarCenterApp.Model.Car;
import com.lee.CarCenterApp.Model.CarModify;
import com.lee.CarCenterApp.Model.Customer;
import com.lee.CarCenterApp.controller.CarController;

public class Menu {
	
	public static final int MAIN_MENU_ADD = 1;
	public static final int MAIN_MENU_VIEW = 2;
	public static final int MAIN_MENU_ADMIN = 3;
	public static final int MAIN_MENU_EXIT = 4;
	
	public static final int SUB_MENU_AUTO = 1;
	public static final int SUB_MENU_MENUAL = 2;
	public static final int SUB_MENU_EXIT = 3;
	
	public static final int ADMIN_MENU_SUM = 1;
	public static final int ADMIN_MENU_REPORT = 2;
	public static final int ADMIN_MENU_PASTDAY = 3;/*
	public static final int ADMIN_MENU_NEXTDAY = 4;*/
	public static final int ADMIN_MENU_EXIT = 3;
	
	/*public static final int ADMIN_PAST_SUM = 1;
	public static final int ADMIN_PAST_REPORT = 2;
	public static final int ADMIN_PAST_ALLVIEW = 3;
	public static final int ADMIN_PAST_EXIT = 4;*/
	
	Scanner sc = new Scanner(System.in);
	
	CarController control/* = new CarController()*/;
	
	Customer cust;
	Car car;
	CarModify modify;
	
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}

	public CarModify getModify() {
		return modify;
	}
	public void setModify(CarModify modify) {
		this.modify = modify;
	}

	
	public int mainMenu() {
		System.out.println("=====================");
		System.out.println("|카센터 관리 프로그램 v1.0|");
		System.out.println("=====================");
		System.out.println("1. 고객정보 등록");
		System.out.println("2. 고객정보 보기");
		System.out.println("3. 관리자 모드");
		System.out.println("4. 프로그램 종료");
		System.out.println("====================");
		System.out.print("메뉴를 선택하세요 : ");
		
		return sc.nextInt();
	}	
	
	public int addsubMenu() {
		System.out.println("====================");
		System.out.println("|1. 자동생성          |");
		System.out.println("|2. 수동입력          |");
		System.out.println("|3. 뒤로 가기         |");
		System.out.println("====================");
		System.out.print("서브메뉴 선택 : ");
		
		return sc.nextInt();
	}
	
	public void addManual() {
		System.out.println("===============");
		System.out.println("|고객 등록정보 입력 |");
		System.out.println("===============");
		
		System.out.print("고객명 : ");
		String name = sc.next();
		System.out.print("고객 전화번호 : ");
		String tel = sc.next();
		System.out.print("멤버쉽 마크 유무(Y : true, N : False) : ");
		boolean mCard = sc.nextBoolean();
		System.out.print("고객 생일 : ");
		String birthday = sc.next();
		System.out.print("고객 메일주소 : ");
		String email = sc.next();
		
		System.out.print("차량모델 : ");
		String model = sc.next();
		System.out.print("연식 : ");
		int year = sc.nextInt();
		
		System.out.print("고장 원인 : ");
		String cause = sc.next();
		System.out.print("접수 일자 : ");
		int dateIn = sc.nextInt();
		System.out.print("수리 완료 일자 : ");
		int dateOut = sc.nextInt();
		System.out.print("수리비 : ");
		int price = sc.nextInt();
		
		
		cust = new Customer(name, tel, mCard, birthday, email);
		car = new Car(model, year);
		modify = new CarModify(cause, dateIn, dateOut, price);
		
		control.addCustData(cust, car, modify);
		
		
		/*control.addCustData(new Customer(name, tel, mCard, birthday, email),
							new Car(model, year),
							new CarModify(cause, dateIn, dateOut, price));*/
	}
	
	
	public int adminMenu() {
		System.out.println("===================");
		System.out.println("=====-관리자 모드-=====");
		System.out.println("===================");
		System.out.println("1. 일일 매출합계");
		System.out.println("2. 차량수리 내역보기");
		System.out.println("3. 지난 기록 보기");
		System.out.println("4. 일일 마감하기");
		System.out.println("5. 메인메뉴 이동");
		System.out.println("===================");
		System.out.print("메뉴를 선택하세요 : ");
		return sc.nextInt();
	}
	
	public int adminPastdayMenu() {
		System.out.println("======================");
		System.out.println("=====-자료 탐색 모드-=====");
		System.out.println("======================");
		System.out.println("1. 일일 매출합계");
		System.out.println("2. 차량수리 내역보기");
		System.out.println("3. 모든 자료 보기");
		System.out.println("4. 열람 종료");
		
		return sc.nextInt();
	}
}

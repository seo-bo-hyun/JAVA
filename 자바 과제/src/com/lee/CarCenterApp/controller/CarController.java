package com.lee.CarCenterApp.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.lee.CarCenterApp.Model.Car;
import com.lee.CarCenterApp.Model.CarModify;
import com.lee.CarCenterApp.Model.Customer;
import com.lee.CarCenterApp.util.AdminPage;
import com.lee.CarCenterApp.util.carAppRand;
import com.lee.CarCenterApp.view.Menu;


public class CarController {
	
	int Sum;
	int day = 1;
	Scanner sc = new Scanner(System.in);
	carAppRand rand = new carAppRand();
	
	Menu m;
	
	ArrayList<Customer> custList = new ArrayList<Customer>();
	ArrayList<Car> carList = new ArrayList<Car>();
	ArrayList<CarModify> modifyList = new ArrayList<CarModify>();
	//ArrayList는 크기가 가변적이다.
	
	ArrayList<Customer> custList_past = new ArrayList<Customer>();
	ArrayList<Car> carList_past = new ArrayList<Car>();
	ArrayList<CarModify> modifyList_past = new ArrayList<CarModify>();
	
	public CarController(Menu m1) {
		this.m = m1;
		//메인에서 m이라는 이름을 갖는 객체를 생성한 뒤 매개변수로 던져주었다.
		//이후 this.m = m;이라는 명령문을 통해 클래스 자체의
	}
	
	public void addRandCustData() {//자동
		
		System.out.print("몇 명을 입력하겠습니까? : ");
		int customer = sc.nextInt();
		
		for (int i = 0; i < customer; i++) {		
			custList.add(new Customer(
							rand.getName(),
							rand.getTel(),
							rand.getMemCard(),
							rand.getBirthday(), 
							rand.getEmail()));
			
			carList.add(new Car(
							rand.getModel(), 
							rand.getYear()));
			
			modifyList.add(new CarModify(
							rand.getCause(), 
							rand.getDateIn(), 
							rand.getDateOut(), 
							rand.getPrice()));
			/*con에는 리스트가 있다. 랜덤한 값을 생성하는 rand객체를 통해
			 * 각 변수별로 무작위 값을 con 속의 리스트에 하나씩 넣는다.*/

		}
		System.out.println(customer + "명을 입력했습니다.");
	}	
	
	
	public ArrayList<CarModify> getModifyList() {
		return modifyList;
	}


	public void setModifyList(ArrayList<CarModify> modifyList) {
		this.modifyList = modifyList;
	}


	public void addCustData(Customer cust, Car car, CarModify modify) { //수동
		custList.add(cust);
		carList.add(car);
		modifyList.add(modify);		
	}
	
	public void viewCustData() {			
		for (int i = 0; i < custList.size(); i++) {
			System.out.println(custList.get(i).toString());
			System.out.println(carList.get(i).toString());
			System.out.println(modifyList.get(i).toString());			
		}
		System.out.println(custList.size() + "명의 자료를 출력했습니다.");
	}
	
	
	public void loginMenu() {
		System.out.println("===================");
		System.out.println("|====관리자 로그인====|");
		System.out.println("===================");
		System.out.print("ID : ");
		String name = sc.next();
		System.out.print("PassWord : ");
		String passwd = sc.next();
		
		if (name.equals(AdminPage.AdminID) && passwd.equals(AdminPage.AdminPass)) {
			System.out.println(day + "일차입니다.");
			adminMenu();
		}
		else if (!name.equals(AdminPage.AdminID) && !passwd.equals(AdminPage.AdminPass)) {
			System.out.println("아이디와 비밀번호가 다릅니다.");
		}
		else if (!name.equals(AdminPage.AdminID)){
			System.out.println("아이디가 다릅니다.");
		}
		else if (!passwd.equals(AdminPage.AdminPass)){
			System.out.println("비밀번호가 다릅니다.");
		}

	}
	
	public void adminMenu() {
		int select;
		
		while (true) {			
			select = m.adminMenu();
			
			switch (select) {
			case Menu.ADMIN_MENU_SUM:
				doAdminSum();
				continue;
				
			case Menu.ADMIN_MENU_REPORT:
				doAdminReport();
				continue;
				
			/*case Menu.ADMIN_MENU_PASTDAY:
				doAdminPastDay();
				continue;
			
			case Menu.ADMIN_MENU_NEXTDAY:
				doAdminNextDay();
				continue;*/
				
			case Menu.ADMIN_MENU_EXIT:
				break;
			}
			break;
		}
	}

	
	public void doAddWork(Menu m2) { //매개변수로 받은 것은 Menu 클래스가 담긴 객체, 정보가 담겨있음
									//따라서 m2는 Menu 클래스에 담긴 정보를 품고 있음
		while (true) {
			int menu = m2.addsubMenu();
			if (menu == Menu.SUB_MENU_AUTO) {
				addRandCustData();					
			}
			else if (menu == Menu.SUB_MENU_MENUAL) {
				m2.addManual();
				addCustData(m2.getCust(), m2.getCar(), m2.getModify());
			}
			else if (menu == Menu.SUB_MENU_EXIT) {
				System.out.println();
				System.out.println("메인메뉴 복귀");
				break;
			}
		}
	}
	
	public void doAdminSum() {
		for (int i = 0; i < modifyList.size(); i++) {
			Sum += modifyList.get(i).getPrice();
		}
		System.out.println("총 매출 합계는 " + Sum + "입니다.");
		Sum = 0;
	}
	
	public void doAdminReport() {
		for (int i = 0; i < custList.size(); i++) {
			System.out.println("\n" + custList.get(i).getName());
			System.out.println("수리차량 모델 : " + carList.get(i).getModel());
			System.out.println("차량 연식 : " + carList.get(i).getYear());
			
			System.out.println("수리 사유 : " + modifyList.get(i).getCause());
			System.out.println("입고 일자 : " + modifyList.get(i).getDateIn());
			System.out.println("출고 일자 : " + modifyList.get(i).getDateOut() + "\n");
		}
		System.out.println("받은 손님은 " + custList.size() + "명입니다.");
	}
	
	public void showFixList() {
		//수리완료 정보
		//고객 이름, 전화번호, 차종, 수리완료여부, 수리비
		
		//수리 미완료 정보
	}
/*
	public void doAdminNextDay() {
		custList_past.addAll(custList);
		carList_past.addAll(carList);
		modifyList_past.addAll(modifyList);	
		
		custList.removeAll(custList);
		carList.removeAll(carList);
		modifyList.removeAll(modifyList);
		day++;
		System.out.println(day + "일차입니다.");
	}

	public void doAdminPastDay() {
		System.out.print("몇 일차의 자료를 보시겠습니까? : ");
		int pastDay = sc.nextInt();
		
		if (pastDay >= day) {
			System.out.println("당일 혹은 미래의 기록은 볼 수 없습니다.");
		}
		else {
			while (true) {
				int menuSelect = m.adminPastdayMenu();
				
				switch(menuSelect) {
				
				case Menu.ADMIN_PAST_SUM:
					for (int i = 0; i < modifyList_past.size(); i++) {
						Sum += modifyList_past.get(i).getPrice();
					}
					System.out.println("총 매출 합계는 " + Sum + "입니다.");
					Sum = 0;
					continue;
					
				case Menu.ADMIN_PAST_REPORT:
					
					continue;
					
				case Menu.ADMIN_PAST_ALLVIEW:
					
					continue;
					
				case Menu.ADMIN_PAST_EXIT:
					
					break;
				}
				break;
			}

		}
	}*/
}

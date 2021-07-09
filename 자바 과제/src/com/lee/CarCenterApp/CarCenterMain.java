package com.lee.CarCenterApp;

import java.util.Scanner;

import com.lee.CarCenterApp.Model.Car;
import com.lee.CarCenterApp.Model.CarModify;
import com.lee.CarCenterApp.Model.Customer;
import com.lee.CarCenterApp.controller.CarController;
import com.lee.CarCenterApp.util.AdminPage;
import com.lee.CarCenterApp.util.carAppRand;
import com.lee.CarCenterApp.view.Menu;

public class CarCenterMain {

	public static void main(String[] args) {
		Menu m = new Menu();
		CarController con = new CarController(m);
		/*m이라는 이름의 Menu 클래스를 가지는 객체를 생성한다.
		 * 이후 con이라는 이름의 CarController 클래스를 가지는 객체를 생성한 뒤,
		 * m이라는 이름의 객체를 매개변수로 집어넣는다.*/
	
		while (true) {
			switch (m.mainMenu()) {
			
			case Menu.MAIN_MENU_ADD:
				System.out.println("고객정보 등록");			
				con.doAddWork(m);
				break;
				
			case Menu.MAIN_MENU_VIEW:
				con.viewCustData();
				break;
				
			case Menu.MAIN_MENU_ADMIN:
				con.loginMenu();
				break;
				
			case Menu.MAIN_MENU_EXIT:
				System.out.println("*****프로그램을 종료합니다*****");
				System.exit(0);
				break;
			}
		}

	}

}

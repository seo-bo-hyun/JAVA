package com.lee.CarCenterApp.util;

import java.util.Scanner;

import com.lee.CarCenterApp.controller.CarController;

public class AdminPage {
	Scanner sc = new Scanner(System.in);
	
	public static final String AdminID = "droposin1";
	public static final String AdminPass = "minicar1";	
	private String id;
	private String password;
	CarController cont;
	
	public void Login() {
		
		System.out.print("ID : ");
		id = sc.next();
		System.out.print("PassWord : ");
		password = sc.next();
		
		if (id.equals(AdminID) && password.equals(AdminPass)) {
			try {
				System.out.println("접속 성공");
				System.out.println("손님 수 : " /*+ cont.getCustNumber()*/);
			}
			catch (Exception e) {
				System.out.println("자료가 비어있습니다.");
			}		
		}
		else {
			System.out.println("아이디 및 비밀번호가 다릅니다.");
		}
	}

}

package com.lee.CarCenterApp.util;

import java.util.Random;

public class carAppRand {
	
	String name[] = {"홍길동", "김길동", "박길동", "이길동", "최길동"};
	
	String tell[] = {"010-1234-5678", "010-4321-5678", "010-3478-1278",
				"010-4523-1978", "010-7890-2134"};
	
	boolean mCard[] = {true, false};
	
	String birthday[] = {"1990년 1월 20일", "1990년 2월 20일", "1990년 3월 20일"
			, "1990년 4월 20일", "1990년 5월 20일"};
	
	String email[] = {"hong1@naver.com", "hong2@naver.com", "hong3@naver.com",
			"hong4@naver.com", "hong5@naver.com"};

	String model[] = {"SM6", "쏘나타", "싼타페", "K7", "그랜져"};
	
	int year[] = {2016, 2017, 2016, 2017, 2016};
	
	String cause[] = {"엔진오일 교체", "와이퍼 교체", "에어컨가스 충전",
			"타이어 교체", "필터 교체"};
	
	int dateIn[] = {20210520, 20210521, 20210522, 20210523, 20210524};
	int dateOut[] = {20210620, 20210621, 20210622, 20210623, 20210624};
	int price[] = {100,200,300,400,500};
	
	int priceSum;
	
	Random r = new Random();

	public String getName() {
		return name[r.nextInt(name.length)];
	}
	public String getTel() {
		return tell[r.nextInt(tell.length)];
	}
	public boolean getMemCard() {
		return mCard[r.nextInt(2)];
	}
	public String getBirthday() {
		return birthday[r.nextInt(birthday.length)];
	}
	public String getEmail() {
		return email[r.nextInt(email.length)];
	}
	public String getModel() {
		return model[r.nextInt(model.length)];
	}
	public int getYear() {
		return year[r.nextInt(year.length)];
	}
	public String getCause() {
		return cause[r.nextInt(cause.length)];
	}
	public int getDateIn() {
		return dateIn[r.nextInt(dateIn.length)];
	}
	public int getDateOut() {
		return dateOut[r.nextInt(dateOut.length)];
	}
	public int getPrice() {
		return price[r.nextInt(price.length)];
	}

}

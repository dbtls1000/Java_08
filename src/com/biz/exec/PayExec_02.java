package com.biz.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.exec.model.PaymentVO;

public class PayExec_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("급여금액 >");
		String strPay = scan.nextLine();
		int intPay = Integer.valueOf(strPay);
		
		//총 급여액을 임시로 다른 변수에 대입해두고 출력할때 사용
		int intMyPay = intPay;
		
		List<PaymentVO> paperList = new ArrayList<PaymentVO>();
		
		int intMoney = 50000;
		int sw = 1;
		while(intMoney > 5) {
			PaymentVO vo = new PaymentVO();
			int intpaper = (int)(intPay/intMoney);
			vo.intMoney = intMoney;
			vo.paper = intpaper;
			paperList.add(vo);
			
			intPay -= (intMoney*intpaper);
			
			if ( sw > 0 ) intMoney /= 5;
			else intMoney /= 2;
			
			sw *= (-1);
		}
		
		// 총급여액을 다시 계산하는 방법
		int intTotalPay = 0;
		for(PaymentVO vo : paperList) {
			intTotalPay += (vo.intMoney*vo.paper);
		}
		
		
		System.out.println("========================");
		System.out.println("총급여액 : " + intTotalPay);
		System.out.println("========================");
		System.out.println("액면가\t\t매수");
		System.out.println("------------------------");
		for(PaymentVO vo : paperList) {
			System.out.printf("%7d\t\t%3d\n",vo.intMoney,vo.paper);
		}
		System.out.println("========================");
	}

}

package com.biz.exec.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.exec.model.PaymentVO;

public class PayService {
	List<PaymentVO> paperList;
	int intPayTotal;
	Scanner scan;

	public PayService() {
		paperList = new ArrayList<PaymentVO>();
		intPayTotal = 0;
		scan = new Scanner(System.in);
	}

	public void payCalse() {

		System.out.println("급여액 >");
		String strPay = scan.nextLine();
		int intPay = Integer.valueOf(strPay);
		intPayTotal = intPay;

		int intMoney = 50000;

		int sw = 1;
		while (intPay > 0) {
			PaymentVO vo = new PaymentVO();

			int intPaper = (int) (intPay / intMoney);

			vo.intMoney = intMoney;
			vo.paper = intPaper;
			paperList.add(vo);

			intPay -= (intPaper * intMoney);

			if (sw > 0)
				intMoney /= 5;
			else
				intMoney /= 2;

			sw *= (-1);

		}

	}

	public void printReport(String payReport) throws IOException {
//		
		FileWriter fileWriter;
		fileWriter = new FileWriter(payReport);
		PrintWriter printer = new PrintWriter(fileWriter);

		printer.println("========================");
		printer.println("총급여액 : " + intPayTotal);
		printer.println("========================");
		printer.println("액면가\t\t매수");
		printer.println("------------------------");
		for (PaymentVO vo : paperList) {
			printer.printf("%7d\t\t%3d\n", vo.intMoney, vo.paper);
		}
		printer.println("========================");
		printer.flush();
		printer.close();
		System.out.println("급여 명세서 파일 저장 완료");

	}

}

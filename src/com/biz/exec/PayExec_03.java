package com.biz.exec;

import java.io.IOException;

import com.biz.exec.service.PayService;

public class PayExec_03 {
	public static void main(String[] args) {
		PayService ps = new PayService();
		String payReport = "src/com/biz/exec/급여명세서.txt";
		ps.payCalse();
		try {
			ps.printReport(payReport);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

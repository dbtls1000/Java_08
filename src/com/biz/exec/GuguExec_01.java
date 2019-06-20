package com.biz.exec;

public class GuguExec_01 {
	public static void main(String[] args) {

		System.out.println("구구단");

		System.out.println("=========================================");

		for (int j = 2; j <= 9; j++) {
			System.out.printf("%3d%s\t\t", j, "단");
		}
		System.out.println();
		System.out.println("=========================================");

		for (int i = 2; i <= 9; i++) {

			for (int j = 2; j <= 9; j++) {
				System.out.printf("%3d x%3d =%3d\t", j, i, i * j);
			}
			System.out.println();
		}

	}
}

package j06_조건;

import java.util.Scanner;

public class Switch2 {

	public static void main(String[] args) {
		String select = "C선택";
		
		switch (select) {
			case "A선택" :
				System.out.println("PC(A)를 연결합니다.");
				break;
			case "B선택" :
				System.out.println("PC(B)를 연결합니다.");
				break;
			case "C선택" :
				System.out.println("PC(C)를 연결합니다.");
				break;
			case "D선택" :
				System.out.println("PC(D)를 연결합니다.");
			default : 
				System.out.println("else와 같은 역할");
		}
	}

}

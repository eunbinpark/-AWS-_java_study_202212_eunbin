package j07_반복;

import java.util.Scanner;

public class While3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		String select = null;
		
		// while문 조건 안에 true 를 넣어놓으면 무한반복
		while (true) {
			
			System.out.print("x입력시 멈춤 : ");
			select = scanner.nextLine();
			
			// 문자열 비교 시 equals사용
			if (select.equals("x") || select.equals("X")){
				System.out.println("프로그램을 멈춥니다.");
				break;
			}
			
			System.out.println("계속 실행!");
		}
		
		System.out.println("프로그램 종료됨.");
		
	}

}

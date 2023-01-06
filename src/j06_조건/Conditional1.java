package j06_조건;

import java.util.Scanner;

public class Conditional1 {
	public static void main(String[] args) {
		
		int num = 10;
		int num2 = 10;
		
		if (num > num2) {
			System.out.println("num이 num2보다 큽니다.");
			System.out.println("num : " + num);
		} 
		else if (num == num2) System.out.println("num과 num2는 집에 가고 싶어합니다.");
		else System.out.println("num이 num2보다 크지 않습니다.");
		
		
		/*
		 * if(num > num2) System.out.println("num이 num2보다 큽니다."); 
		 * else { 
		 * 		if (num == num2) System.out.println("num과 num2가 같습니다"); 
		 * 		else System.out.println("num이 num2보다 크지 않습니다."); 
		 * }
		 */
	}
	
}

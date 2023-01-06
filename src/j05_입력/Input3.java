package j05_입력;

import java.util.Scanner;

public class Input3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// nextLine 은 띄어쓰기를 허용함 이 외는 띄어쓰기를 허용하지 않음 
		System.out.print("문자열1 : ");
		String str1 = scanner.nextLine();
		
		System.out.print("문자열2 : ");
		String str2 = scanner.next();
		
		System.out.print("정수 : ");
		int num1 = scanner.nextInt();
		
		System.out.print("실수 : ");
		double num2 = scanner.nextDouble();
		
		System.out.println("문자열1 : " + str1);
		System.out.println("문자열2 : " + str2);
		System.out.println("정수 : " + num1);
		System.out.println("실수 : " + num2);
	}
}
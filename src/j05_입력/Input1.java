package j05_입력;

//ctrl + shift + o : 유틸 자동완성

import java.util.Scanner;

public class Input1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int inputNum1 = 0;
		int inputNum2 = 0;
		int inputNum3 = 0;
		int inputNum4 = 0;
		int inputNum5 = 0;
		
		System.out.print("입력1 : ");
		inputNum1 = scanner.nextInt();
		System.out.print("입력2 : ");
		inputNum2 = scanner.nextInt();
		System.out.print("입력3 : ");
		inputNum3 = scanner.nextInt();
		System.out.print("입력4 : ");
		inputNum4 = scanner.nextInt();
		System.out.print("입력5 : ");
		inputNum5 = scanner.nextInt();
		
		int sum = inputNum1 + inputNum2 + inputNum3 + inputNum4 + inputNum5;
		
		System.out.println("합 : " + sum);
	}
}
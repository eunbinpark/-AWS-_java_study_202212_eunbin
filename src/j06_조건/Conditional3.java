package j06_조건;

import java.util.Scanner;

public class Conditional3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int score = 0;
		String grade = null;
		
		System.out.print("점수 입력 : ");
		score = scanner.nextInt();
		
		/*
		 * if (score < 0 || score > 100) { System.out.println("어우 배고파"); } 
		 * else {
		 * 		if(score > 89) { grade = "A"; } 
		 * 		else if(score > 79) { grade = "B"; } 
		 * 		else if(score > 69) { grade = "D"; } 
		 * 		else if(score > 59) { grade = "D"; } 
		 * 		else { grade = "F"; }
		 * 
		 * 		if (score > 59 && (score % 10) > 4 || score == 100) { grade += "+"; }
		 * 
		 * 		System.out.println("점수(" + score + ") : " + grade + "학점"); 
		 * }
		 */
		
		if (score < 0 || score > 100) {
			grade = null;
		} else if(score > 89) {
			grade = "A";
		} else if(score > 79) {
			grade = "B";
		} else if(score > 69) {
			grade = "D";
		} else if(score > 59) {
			grade = "D";
		} else {
			grade = "F";
		}
		
		if ((score > 59 && score < 101) && (score % 10) > 4 || score == 100) {
			grade += "+";
		}
		
		if (grade == null) {
			System.out.println("어우 배고파");
		} else {
			System.out.println("점수(" + score + ") : " + grade + "학점");
		}
	}
}

package j04_연산자;

public class Operation6 {

	public static void main(String[] args) {
		/*
		 * 시험 성적을 학점으로 계산하는 프로그램
		 * 
		 * 정수자료형 score변수 선언 88점으로 초기화
		 * 
		 * 문자자료형 grade변수 선언
		 * 
		 * 조건 score가 0점보다 작거나 100점보다 크면 X를 출력 score가 90 ~ 100점이면 A학점 score가 80 ~ 89점이면
		 * B학점 score가 70 ~ 79점이면 C학점 score가 60 ~ 69점이면 D학점 score가 0 ~ 59점이면 F학점
		 * 
		 * System.out.println("점수(88) : B학점");
		 */

		int score = 100;
//		int sRem;

		String grade1 = (score < 0) || (score > 100) ? "X"
				: score > 94 ? "A+" 
				: score > 89 ? "A" 
				: score > 84 ? "B+" 
				: score > 79 ? "B" 
				: score > 74 ? "C+" 
				: score > 69 ? "C" 
				: score > 64 ? "D+"
				: score > 59 ? "D" : "F";
				
				
		System.out.println("점수(" + score + ") : " + grade1 + "학점");

		
				
//		char puls1 = (sRem = score % 10) > 4 ? '+' : '\0';
		
		char puls = score > 100 || score < 60 ? '\0' 
				: score % 10 > 4 || score == 100 ? '+' : '\0';
		
		char grade = (score < 0) || (score > 100) ? 'X'
				: score > 89 ? 'A'
				: score > 79 ? 'B' 
				: score > 69 ? 'C' 
				: score > 59 ? 'D' : 'F';
				
		
		System.out.println("점수(" + score + ") : " + grade + puls + "학점");
	}
}

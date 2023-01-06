package j07_반복;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean loopFlag1 = true;

		while (loopFlag1) {

			char select = '\0';

			// 메인 메뉴
			System.out.println("========<< 식당 메뉴 >>========");
			System.out.println("1. 김밥천국");
			System.out.println("2. 국밥");
			System.out.println("3. 중국집");
			System.out.println("4. 파스타");
			System.out.println("===============================");
			System.out.println("q. 프로그램 종료");
			System.out.println("===============================");

			// charAt(i) : 입력받은 문자열의 i번째 인덱스를 들고옴
			System.out.print("식당선택 : ");
			select = scanner.next().charAt(0);

			// 프로그램 종료
			if (select == 'q' || select == 'Q') {
				loopFlag1 = false;
			
			// 김밥천국
			} else if (select == '1') {
				boolean loopFlag2 = true;
				
				while(loopFlag2) {
					System.out.println();
					System.out.println("========<< 깁밥천국 >>========");
					System.out.println("1. 라면");
					System.out.println("2. 돌솥비빔밥");
					System.out.println("3. 오므라이스");
					System.out.println("4. 김치볶음밥");
					System.out.println("==============================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("==============================");

					// charAt(i) : 입력받은 문자열의 i번째 인덱스를 들고옴
					System.out.print("메뉴 번호 선택 : ");
					select = scanner.next().charAt(0);

					System.out.println();
					
					if (select == 'b') {
						loopFlag2 = false;
					} else if (select == 'q' || select == 'Q') {
						loopFlag1 = false;
						loopFlag2 = false;
					} else if (select == '1') {
						System.out.println("라면을 선택했습니다.");
					} else if (select == '2') {
						System.out.println("돌솥비빔밥을 선택했습니다.");
					} else if (select == '3') {
						System.out.println("오므라이스을 선택했습니다.");
					} else if (select == '4') {
						System.out.println("김치볶음밥을 선택했습니다.");
					} else {
						System.out.println();
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						System.out.println("사용할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요.");
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					}
					System.out.println();
				}
				
			// 국밥집
			} else if (select == '2') {
				// loopFlag2는 해당 if문 안에 있는 지역변수이므로
				// 이 명령문을 나가면 다른곳에서도 사용가능함
				boolean loopFlag2 = true;
				
				while(loopFlag2) {
					System.out.println();
					System.out.println("========<<   국밥   >>========");
					System.out.println("1. 돼지국밥");
					System.out.println("2. 순대국밥");
					System.out.println("3. 섞어국밥");
					System.out.println("4. 내장국밥");
					System.out.println("==============================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("==============================");

					// charAt(i) : 입력받은 문자열의 i번째 인덱스를 들고옴
					System.out.print("메뉴 번호 선택 : ");
					select = scanner.next().charAt(0);
					
					System.out.println();
					
					if (select == 'b') {
						loopFlag2 = false;
					} else if (select == 'q' || select == 'Q') {
						loopFlag1 = false;
						loopFlag2 = false;
					} else if (select == '1') {
						System.out.println("돼지국밥을 선택했습니다.");
					} else if (select == '2') {
						System.out.println("순대국밥을 선택했습니다.");
					} else if (select == '3') {
						System.out.println("섞어국밥을 선택했습니다.");
					} else if (select == '4') {
						System.out.println("내장국밥을 선택했습니다.");
					} else {
						System.out.println();
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						System.out.println("사용할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요.");
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					}
					System.out.println();
				}
				
			// 중국집
			} else if (select == '3') {
				boolean loopFlag2 = true;
				
				while(loopFlag2) {
					System.out.println();
					System.out.println("========<<  중국집  >>========");
					System.out.println("1. 짜장면");
					System.out.println("2. 짬뽕");
					System.out.println("3. 볶음밥");
					System.out.println("4. 탕수육");
					System.out.println("==============================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("==============================");

					// charAt(i) : 입력받은 문자열의 i번째 인덱스를 들고옴
					System.out.print("메뉴 번호 선택 : ");
					select = scanner.next().charAt(0);
					
					System.out.println();
					
					if (select == 'b') {
						loopFlag2 = false;
					} else if (select == 'q' || select == 'Q') {
						loopFlag1 = false;
						loopFlag2 = false;
					} else if (select == '1') {
						System.out.println("짜장면을 선택했습니다.");
					} else if (select == '2') {
						System.out.println("짬뽕을 선택했습니다.");
					} else if (select == '3') {
						System.out.println("볶음밥을 선택했습니다.");
					} else if (select == '4') {
						System.out.println("탕수육을 선택했습니다.");
					} else {
						System.out.println();
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						System.out.println("사용할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요.");
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					}
					System.out.println();
				}
				
			// 파스타
			} else if (select == '4') {
				boolean loopFlag2 = true;
				
				while(loopFlag2) {
					System.out.println();
					System.out.println("========<<  파스타  >>========");
					System.out.println("1. 알리오올리오");
					System.out.println("2. 까르보나라파스타");
					System.out.println("3. 봉골레파스타");
					System.out.println("4. 바질페스토파스타");
					System.out.println("==============================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("==============================");

					// charAt(i) : 입력받은 문자열의 i번째 인덱스를 들고옴
					System.out.print("메뉴 번호 선택 : ");
					select = scanner.next().charAt(0);
					
					System.out.println();
					
					if (select == 'b') {
						loopFlag2 = false;
					} else if (select == 'q' || select == 'Q') {
						loopFlag1 = false;
						loopFlag2 = false;
					} else if (select == '1') {
						System.out.println("알리오올리오를 선택했습니다.");
					} else if (select == '2') {
						System.out.println("까르보나라파스타를 선택했습니다.");
					} else if (select == '3') {
						System.out.println("봉골레파스타를 선택했습니다.");
					} else if (select == '4') {
						System.out.println("바질페스토파스타를 선택했습니다.");
					} else {
						System.out.println();
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						System.out.println("사용할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요.");
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					}
					System.out.println();
				}
				
			// 다른 번호 입력
			} else {
				System.out.println();
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("사용할 수 없는 번호입니다.");
				System.out.println("다시 입력하세요.");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			}

			System.out.println();
		}

		System.out.println("프로그램 정상 종료!");
	}
}

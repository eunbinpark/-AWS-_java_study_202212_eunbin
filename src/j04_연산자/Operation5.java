package j04_연산자;

public class Operation5 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 0;

		int result = num1 > num2 ? num1 * -1 : num2 * -1;
		
		System.out.println(result);
		
		int num = 79;
		
		// 조건을 일일이 확인해가며 다음항으로 넘어감
		// 조건이 여러개일 경우 다음줄로 넘겨서 작성
		int result2 = num / 90 == 1 ? 90
				: num / 80 == 1 ? 80 
				: num / 70 == 1 ? 70 : 0;
		
		System.out.println(result2);
	}

}

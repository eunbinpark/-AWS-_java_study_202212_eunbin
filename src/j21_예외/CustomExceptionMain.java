package j21_예외;

public class CustomExceptionMain {

	public static void main(String[] args) {
		
		try {
//			throw new IndexOutOfBoundsException("인덱스를 초과함");
			throw new CustomErrorException("뭔가 문제가 있음");
		} catch (CustomErrorException e) {
			String message = e.getMessage();
			System.out.println(message);
		}
		System.out.println("프로그램 종료");
	}
}

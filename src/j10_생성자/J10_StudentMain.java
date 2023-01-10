package j10_생성자;

public class J10_StudentMain {

	public static void main(String[] args) {
		
		// 주소에다 변수를 넣음
		// 해당변수는 클래스 내부의 생성자의 멤버변수로 들어감
		// 그것이 printInfo를 통하여 출력
		J10_Student s1 = new J10_Student("박은빈", 23);
		s1.printInfo();
		
		// 원래 생성 이후에 값을 넣어야 하는데(도색) 생성할 때 값을 바로 넣기 위해서 this사용
	}
}
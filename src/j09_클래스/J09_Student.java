package j09_클래스;

public class J09_Student {

	String name;
	int age;
	
	// 기본 생성자
	// 클래스 내에서는 변수를 초기화하지 않아도 생성될때 알아서 기본값을 넣어줌
	// 미리 초기값을 세팅해두면 그것이 기본값이 됨
	// 메소드는 초기화를 하지 않으면 안됨
	J09_Student() {
		System.out.println("생성됨!");
	}
	
	void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		
		
	}
}

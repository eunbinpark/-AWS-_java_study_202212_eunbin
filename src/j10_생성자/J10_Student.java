package j10_생성자;

public class J10_Student {
	
	// 참조변수, 레퍼런스변수, 멤버변수 라고불린다
	// 메소드도 마찬가지로 참조메소드, 레퍼런스메소드, 멤버메소드라고 불린다. 
	String name;
	int age;

	// 클래스에서는 지역변수와 멤버변수를 구분함 
	// s1.~~ : 생성된 이후에 값을 대입
	// 생성할 때 바로 메소드 사용하듯이 값을 넣어주면 바로 사용가능
	// 하지만 그러면 생성자 변수와 멤버변수의 이름이 같을때 문제가 생김
	// 따라서 this.를 사용하여 멤버변수를 특정해줌
	
	// 생성자들
	J10_Student() {
		System.out.println("기본생성자 호출");
	}
	
	J10_Student(int age) {
		System.out.println("학생의 나이 : " + age);
	}
	
	J10_Student(String name) {
		System.out.println("학생의 이름 : " + name);
	}
	
	// (주소).~~ 에서 .은 참조한다는 뜻
	// this는 자기 자신의 주소 : main 에서 사용하는 s1.~~ 과 같은 주소를 가짐
	J10_Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 이 메소드에서 사용되는 변수는 멤버변수
	void printInfo() {
		System.out.println("학생 이름 : " + name);
		System.out.println("학생 나이 : " + age);
	}
}











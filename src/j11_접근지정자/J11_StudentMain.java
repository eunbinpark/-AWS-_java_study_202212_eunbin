package j11_접근지정자;

// 다른 클래스가 public이어야 import가능
import j11_접근지정자.default1.J11_StudentDefault;

public class J11_StudentMain {

	public static void main(String[] args) {
		J11_Student s1 = new J11_Student();
//		s1.name = "박은빈";
		
		s1.printInfo();
		
		// 해당 생성자도 public 이어야 생성가능 
		J11_StudentDefault s2 = new J11_StudentDefault();
		
		// 변수, 메소드 등 모든 것을 public으로 바꾸어야 호출 가능
		s2.printInfo();
		
		// 외부에서 변수에 직접접근
//		s2.name = "박은빈";
		
		// 외부에서 변수에 직접접근, 멤버변수를 private으로 지정해두면 접근 불가
//		System.out.println("이름 : " + s2.name);
		// 메소드가 대신 접근, 메소드는 private로 설정하면 안됨
		System.out.println("이름 : " + s2.getName());
	}
}

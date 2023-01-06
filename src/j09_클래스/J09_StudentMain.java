package j09_클래스;

public class J09_StudentMain {

	public static void main(String[] args) {
		
		// 스택메모리 : 정적메모리, 힙 : 동적메모리
		// 컴파일 당시에 스택메모리를 할당해주었는데 추가로 메모리가 필요한 경우 힙메모리에서 빌려옴
		// 힙메모리에서 빌리는 과정을 생성이라고 함
		// 힙메모리에 할당된 주소는 매번 변경됨 
		// 따라서 힙메모리 주소를 정적메모리인 스택메모리에 넣어두고 이름을 지정해줌 
		// 따라서 이름을 알고 있으면 힙메모리의 주소를 불러올 수 있음(아래 Student1 같은 경우)
		
		new J09_Student();
		
		// 생성자의 주소는 해당 클래스의 자료형으로만 담을 수 있다
		J09_Student s1 = new J09_Student();
		J09_Student s2 = new J09_Student();
		
		s1.name = "박은빈";
		s1.age = 23;
		
		s1.printInfo();
		s2.printInfo();
		
//		System.out.println(s1);
//		System.out.println(s2);
	}

}

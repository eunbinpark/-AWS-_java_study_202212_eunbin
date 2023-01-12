package j17_스태틱;

public class Student {

	private static final int CODE = 20230000;
	
	private static int ai = 1; // auto_increment
	
	private int studentCode;
	private String name;
	
	public Student(String name) {
		studentCode = CODE + ai;
		ai++;
		this.name = name;
	}

	public static int getAutoIncrement() {
		// ai는 스태틱 변수라 생성이 되지 않아도 사용가능하다
		// 스태틱 메소드안에 꼭 생성이 되어야만 사용가능한 변수가 들어있으면 오류가 남
		// 스태틱메소드에서는 멤버변수가 스태틱이어야 사용가능(해당 메소드 내부의 지역변수는 사용가능)
		System.out.println("현재 AI : " + ai);
		// name은 생성이 된 이후에만 사용가능한 변수
//		System.out.println("학생이름 : " + name);
		return ai;
	}
	
	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", name=" + name + "]";
	}
}

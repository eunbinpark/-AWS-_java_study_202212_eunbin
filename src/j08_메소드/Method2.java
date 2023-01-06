package j08_메소드;

public class Method2 {

	public static void main(String[] args) {
		
		// 함수 호출
		method1();
		method2(100);
		method3(200, 300);
		
		System.out.println(method4());
		System.out.println();
		
		String data1 = method4();
		System.out.println(data1);
		System.out.println();
		
		System.out.println(method5(23));
	}
	
	// 매개변수 : x, 반환 : x
	public static void method1() {
		System.out.println("단순 실행");
		System.out.println();
	}
	
	public static void method2(int num) {
		System.out.println("num : " + num);
		System.out.println();
	}
	
	public static void method3(int num, int num2) {
		System.out.println("num : " + num);
		System.out.println("num2 : " + num2);
		System.out.println();
	}
	
	public static String method4() {
		return "데이터 반환";
	}
	
	public static String method5(int age) {
		return age + "살";
	}
}

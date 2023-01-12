package j18_제네릭;

public class Main {

	public static void main(String[] args) {
		// 자료형을 바꿔서 변수를 넘길때 제네릭 사용
		// 생성될 때 <>안에 자료형을 작성
		// 생성된 후에는 자료형 변경 불가
		TestData<Integer> td = new TestData<Integer>("김준일", 30);
		TestData<Double> td2 = new TestData<Double>("junil", 100.05);
		
		System.out.println(td);
		System.out.println(td2);
	}
}

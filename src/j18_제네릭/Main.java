package j18_제네릭;

public class Main {

	public static void main(String[] args) {
		// 자료형을 바꿔서 변수를 넘길때 제네릭 사용
		// 생성될 때 <>안에 자료형을 작성
		// 생성된 후에는 자료형 변경 불가
//		TestData<String, Integer> td = new TestData<String, Integer>("김준일", 30);
//		TestData<String, Double> td2 = new TestData<String, Double>("junil", 100.05);
//		
//		System.out.println(td);
//		System.out.println(td2);
//		
//		CMRespDto<TestData<String, Integer>> cm =
//				new CMRespDto<TestData<String, Integer>>(200, "성공", td);
//		
//		System.out.println(cm);
		
		TestData<?, ?> td = new TestData<String, Integer>("김준일", 30);
		TestData<?, ?> td2 = new TestData<String, Double>("junil", 100.05);
		
		System.out.println(td);
		System.out.println(td2);
		
		CMRespDto<?> cm = new CMRespDto<>(200, "성공", td);
		
		System.out.println(cm);
	}
}
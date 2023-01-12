package j17_스태틱.싱글톤;

public class KIA {

	private static KIA instance = null;
	
	private KIA() {}
	
	public static KIA getInstance() {
		// instance 는 스태틱변수라서 한번만 생성하면 그 뒤로 바뀌지 않음
		// 다른 클래스에서 getInstance 를 호출해도 생성없이 처음 생성한 변수를 호출함
		if(instance == null) {
			instance = new KIA();
		}
		return instance;
	}
	
	public void printCompanyName() {
		System.out.println(getClass().getSimpleName());
	}
}
package j18_제네릭;

public class TestData<T, E> {

	// 제네릭은 일반 자료형 사용불가능
	private T data1;
	private E data2;	// Wrapper Class(래퍼 클래스)
	
	public TestData(T data1, E data2) {
		this.data1 = data1;
		this.data2 = data2;
	}

	@Override
	public String toString() {
		return "TestData [data1=" + data1 + ", data2=" + data2 + "]";
	}
}
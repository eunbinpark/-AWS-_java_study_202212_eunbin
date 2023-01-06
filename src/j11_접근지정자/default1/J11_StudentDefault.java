package j11_접근지정자.default1;

public class J11_StudentDefault {

	// 멤버변수는 무조건  private : 외부로부터 정보를 은닉
	private String name;
	private int age;
	
	public J11_StudentDefault() {
		
	}
	
	public J11_StudentDefault(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
	
	// Getter : 값을 들고오는 것
	public String getName() {
		// 같은 클래스 내부에서는 접근 가능
		return name;
	}
	
	// Setter : 값을 대입하는 것
	// 변수를 직접입력할 수 없기 때문에 메소드가 대신 입력해줌 
	public void setName(String name) {
		this.name = name;
	}
	
	// 건들면 안되는 메소드 같은 것들도 모두 private 로 지정해둠 : 캡슐화
	
}

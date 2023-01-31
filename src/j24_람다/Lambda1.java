package j24_람다;

public class Lambda1 {

	public static void main(String[] args) {
		Instrument instrument = new Instrument() {
			
			@Override
			public String play(String instrument) {
				
				return instrument + "을(를) 연주합니다.";
			}
		};
		
		// 람다를 사용할수 있는 인터페이스 : 추상메소드를 하나만 가진 인터페이스
		Instrument instrument2 = (String itm) -> {
			return itm + "을(를) 연주합니다.";
		};
		
		// 매개변수의 자료형을 생략할 수 있다
		// 매개변수의 이름을 바꿀 수 있다
		Instrument instrument3 = (itm) -> {
			return itm + "을(를) 연주합니다.";
		};
		
		// 매개변수가 하나이면 매개변수를 감싸는 괄호를 생략할 수 있다
		Instrument instrument4 = itm -> {
			return itm + "을(를) 연주합니다.";
		};

		// 구현부의 명령이 하나일 때 중괄호를 생략할 수 있다
		// 이때 리턴자료형이 정해져 있으면 리턴값으로 사용이 된다.
		// 중괄호를 생략하면 리턴도 생략해야함
		Instrument instrument5 = itm -> itm + "을(를) 연주합니다.";
		
		int result = 10 + 20;
		
		Instrument instrument6 = itm -> itm + "을(를) 연주합니다." + result;		
		
		System.out.println(instrument.play("피아노"));
		
		String playText = instrument.play("드럼");
		System.out.println(playText);
		
		System.out.println(instrument6.play("기타"));
	}
}

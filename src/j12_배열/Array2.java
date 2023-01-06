package j12_배열;

public class Array2 {

	public static void printNames(String [] names) {
		
		// @.length : @의 크기를 참조하여 유동적으로 들고옴
		// names 이름은 동일하지만 다른 변수임 
		for (int i = 0; i < names.length; i++) {
			System.out.println("이름[" + (i + 1) + "] : " + names[i]);
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {

		// 배열을 미리 만들어놓고 그 뒤에 값을 넣는것
		// 들어갈 값이 정해져있지 않을때, 들어갈 내용과 용량이 확실할 때 사용
		String[] names = new String[3];

		names[0] = "김상현";
		names[1] = "임나영";
		names[2] = "김종환";
		
		// 배열 생성과 동시에 값을 넣는것
		// 다음과 같은 배열을 쓸 때는 크기를 지정해두면 안됨
		// 이 이후에 들어오는 값을 보고 공간을 할당해줌
		String[] names2 = new String[] {"이상현", "손지호", "이강용"};
		
		// 2번을 줄인것
		String[] names3 = {"김두영", "강대협", "이현수", "김재영"};
		
		
		printNames(names);
		
		// 이런식으로도 사용가능
		printNames(new String[] {"이상현", "손지호", "이강용"});
		printNames(names3);
	}
}

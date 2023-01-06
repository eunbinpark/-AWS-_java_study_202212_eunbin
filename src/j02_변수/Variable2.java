package j02_변수;

public class Variable2 {

	public static void main(String[] args) {
		char firstName1 = '은';
		char firstName2 = '빈';
		
		char alphabetA = 'A';
		
		System.out.println("박" + firstName1 + firstName2);
		System.out.println("알파벳A : " + alphabetA);
		System.out.println(alphabetA + 1); // 실행하면 66
		System.out.println(alphabetA + 'B'); // 실행하면 131
		System.out.println(alphabetA); // 실행하면 A
		System.out.println("\uAC00"); // 실행하면 가, 유니코드 표현
		System.out.println(firstName1 + 0); 
	}

}

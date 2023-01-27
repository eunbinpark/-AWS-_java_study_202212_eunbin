package Test1.Q2;

//반복문을 돌때의 인덱스값이 배열의 크기보다 커서 예외가 발생함
//IndexOutOfBoundsException을 사용하여 예외처리 하면 됨

import java.util.Arrays;
import java.util.List;

class SubjectService {
	private List<String> subjects;
	
	public SubjectService(List<String> subjects) {
		this.subjects = subjects;
	}
	
	public void showSubjects() {
		int length = 4;
		
		try {
			for (int i = 0; i < length; i++) {
				System.out.println(subjects.get(i));
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("예외 처리함");
		}
		
	}
}

public class Main {
	
	public static void main(String[] args) {
		List<String> subjects = Arrays.asList(new String[]{"C", "Java", "Python"});
		SubjectService subjectService = new SubjectService(subjects);
		subjectService.showSubjects();
	}
}

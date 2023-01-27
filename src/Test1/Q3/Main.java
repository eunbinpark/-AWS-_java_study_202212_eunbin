package Test1.Q3;

// null값이 들어있는 students 리스트를 forEach문으로 전부 실행하는 바람에 예외가 생김
// NullPointerException를 사용하여 예외처리

import java.util.ArrayList;
import java.util.List;

import j07_반복.Continue;

class Student {
	private int studentCode;
	private String studentName;
	
	public Student(int studentCode, String studentName) {
		this.studentCode = studentCode;
		this.studentName = studentName;
	}
	
	public void showStudent() {
		System.out.println("학번 : " + studentCode + ", " + "이름 : " + studentName);
	}
}

public class Main {

	public static void main(String[] args) {
		int findNUllIndex = 0;
		
		List<Student> students = new ArrayList<>();
		students.add(new Student (1001, "홍길동"));
		students.add(null);
		students.add(new Student (1003, "김영희"));

		try {
			for(Student student : students) {
				student.showStudent();
				findNUllIndex = students.indexOf(null);
			}
		} catch (NullPointerException e) {
			students.add(findNUllIndex, new Student (1002, "강철수"));
		}
	}
}

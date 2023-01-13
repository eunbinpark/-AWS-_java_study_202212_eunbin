package j19_컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListMain {
	
	/**
	 * 
	 * CRUD
	 * 
	 * C reate
	 * R ead
	 * U pdate
	 * D elete
	 * 
	 */

	public static void main(String[] args) {
		List<String> strList = new ArrayList<>();
	
		// *값 추가
		strList.add("java");
		strList.add("python");
		System.out.println(strList);
		
		// 값 원하는 위치에 추가
		strList.add(1, "android");
		System.out.println(strList);
		
		// *해당 인덱스의 값을 추출
		System.out.println(strList.get(0));
		String lang = strList.get(1);
		System.out.println(lang);
		
		// 리스트에 해당 값이 있는지 확인(T, F)
		System.out.println(strList.contains("C++"));
		System.out.println(strList.contains(lang));
		
		// 값 수정
		strList.set(2, "javascript");
		System.out.println(strList);
		
		// *값 삭제
		strList.remove("android");
		System.out.println(strList);
		strList.remove(1);
		System.out.println(strList);
		
		// *리스트의 크기 확인
		System.out.println(strList.size());
		
		// 리스트가 비었는지 확인
		System.out.println(strList.isEmpty());
		
		// 리스트 초기화
		strList.clear();
		System.out.println(strList.isEmpty());
		
		/* 
		 * *배열을 리스트로 변환
		 * Array.asList(배열);
		 */
		String[] langs = {"java", "C++", "python", "javascript"};
		List<String> tempList = Arrays.asList(langs);
		strList.addAll(tempList);
		strList.addAll(2, tempList);
		System.out.println(strList);
		
		// *해당 값의 위치(index) 왼쪽부터 찾기
		int findindexLeft = strList.indexOf("python");
		System.out.println(findindexLeft);

		// *해당 값의 위치(index) 오른쪽부터 찾기
		int findindexRight = strList.lastIndexOf("java");
		System.out.println(findindexRight);
		
		// fromIndex 부터 toIndex 전까지 부분만 리스트를 추출
		List<String> subList = strList.subList(1, 4);
		System.out.println(subList);
		
		System.out.println();
		
		///////////////////////////////////////////////////////////////////
		
		strList.set(1, "java");
		System.out.println(strList);
		strList.subList(strList.indexOf("java") +1, strList.size()).indexOf("java");
		
		
		///////////////////////////////////////////////////////////////////
		
		// =============<< 반복 >>=============
		// 일반 반목문
		for (int i = 0; i < strList.size(); i++) {
			System.out.println("[" + i + "] :" + strList.get(i));
		}
		System.out.println();
		
		// forEach
		for(String str : strList) {
			System.out.println("[값] : " + str);
		}
		System.out.println();
		
		// 람다식 forEach
		strList.forEach(str -> System.out.println("[값2] : " + str));
		System.out.println();
		
		// 반복자
		// 넥스트 하면 무조건 그 다음값을 꺼냄 그래서 한바퀴 돌고 다시 쓰려면 다시 값을 넣어줘야 함
		Iterator<String> iterator = strList.iterator();
		while(iterator.hasNext()) {
			String lang2 = iterator.next();
			System.out.println("[값3] : " + lang2);
		}
		
		iterator = strList.iterator();
		while(iterator.hasNext()) {
			String lang2 = iterator.next();
			System.out.println("[값3] : " + lang2);
		}
	}
}
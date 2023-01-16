package j19_컬렉션;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapStringMain {

	public static void main(String[] args) {
		Map<String, String> strMap = new HashMap<>();
		
		strMap.put("a", "A");
		strMap.put("b", "B");
		strMap.put("c", "C");
		strMap.put("d", "D");
		
		System.out.println(strMap);
		
		System.out.println(strMap.get("a"));
		System.out.println(strMap.get("e"));
		
		for(String k : strMap.keySet()) {
			System.out.println("key : " + k);
			System.out.println(strMap.get(k));
		}
		
		for(String v : strMap.values()) {
			System.out.println("value : " + v);
		}
		
		Set<Entry<String, String>> s = null;
		
		for(Entry<String, String> entry : strMap.entrySet()) {
			System.out.println(entry);
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			System.out.println();
		}
		
		System.out.println("=================================");
		
//		strMap.forEach(k, v) -> {
//			System.out.println("key : " + k);
//			System.out.println("value : " + v);
//		}
	}
}
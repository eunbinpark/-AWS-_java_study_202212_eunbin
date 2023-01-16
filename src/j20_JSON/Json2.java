package j20_JSON;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json2 {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("a", "test1");
		map.put("b", 10.5);
		map.put("c", new int[] {10, 20, 30, 40, 50});
		
		System.out.println(map);
		
		// 맵의 값을 문자열로 출력
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String mapJson = gson.toJson(map);
		
		System.out.println(mapJson);
	}
}

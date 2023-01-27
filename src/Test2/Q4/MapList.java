package Test2.Q4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapList {

	public static void main(String[] args) {
		
		Map<String, Object> cstMap = new HashMap<>();
		
//		cstMap.put("홍길동", new Map<String, Integer>("vip", 30));
//		cstMap.put("김기영", new Map<String, Integer>("gold", 35));
		
		List<Map<String, Object>> customers = new ArrayList<>();
		
		for (Map<String, Object> customer : customers) {
			System.out.println();
		}
	}
	
	// Map으로 이루어진 List... 시간이 너무 모자랍니다...... 
	// 위의 경우는 Map의 키값이 이름이고 Object에 정보가 들어가는 건가요...?
	// 그 정보를 리스트로 넣어야 하는지 맵으로 넣어야 하는지 배열로 넣어야 하는지...
	// 아니면 따로 userId 같은것을 두고 이름이 포함된 정보를 전부 배열로 넣어야 하는지...
	// 시험 한시간을 꼬박 쏟아부어 정말 치열하게 고민을 했습니다...
	// 죄송합니다... 별의 별 시도를 다 해봤는데 다 실패했어요...
	// 시험문제 내느라 수고하셨고... 재시험도 잘 부탁드립니다......
}

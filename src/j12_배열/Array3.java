package j12_배열;

import java.util.Random;

public class Array3 {

	public static void main(String[] args) {

		Random random = new Random();

		// nums 라는 10개의 공간을 만들어놓음
		int[] nums = new int[10];

//		// 0 ~ 9까지 랜덤하게 출력
//		System.out.println(random.nextInt(10));

//		for (int i = 0; i < 10; i++) {
//			nums[i] = i;
//			
//			System.out.println(i);
//		}
		
		// for문의 목적 : 배열의 처음부터 끝까지 값을 넣기위해
		// i : 배열의 인덱스 값
		for (int i = 0; i < nums.length; i++) {
			// 
			while (true) {
				boolean findFlag = true;
				
				// 랜덤한 값을 하나 만들어 변수에 넣어둠
				int randomNum = random.nextInt(nums.length) + 1;
				
				// 현재 nums[]안에 들어있는 값을 j값이 도는동안 꺼내와서 랜덤값과 비교
				// j가 증가할 동안 배열에 있는 값을 꺼내와 비교했을때 같은 값이 없으면 그냥 for문 다 돌고 종료
				for (int j = 0; j < nums.length; j++) {
					
					if (nums[j] == randomNum) {
						// 만약 값이 같으면 플래그를 false로 변경
						findFlag = false;
						// 배열을 비교하다 같은값이 있으면 멈추는 브레이크
						break;
					}
				}
				
				// 따로 값을 쓰지 않으면 ()안의 조건이 true일때라는 조건임
				if (findFlag) {
					nums[i] = randomNum;
					// while 의 무한루프를 멈춰주는 브레이크 
					break;
				}
			}
		}	
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}

package j12_배열;

public class Array5 {
	
	// 
	private static void transferArray(int[] oldArray, int[] newArray) {
		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
	
	// 배열을 받아와서 newArray에 받아온 배열의 크기에 1을 더하여 newArray에 대입
	// transferArray에 받은 배열과 newArray를 붙임
	private static int[] addArrayLength(int[] array) {
		
		int[] newArray = new int[array.length + 1];
		
		transferArray(array, newArray);
		
		return newArray;
	} 
	
	// 배열과 데이터를 받아와서 addArratLength를 통해 newArray에다 새 배열 등록
	public static int[] addData(int[] array, int data) {
		int[] newArray = addArrayLength(array);
		newArray[array.length] = data;
		
		return newArray;
	}

	// 메소드명만 보고도 하는 동작을 알수 있어야 함(클린코드)
	// 클래스간의 응집도는 높고 결합도가 낮아야 좋다 
	public static void main(String[] args) {
		
		int[] nums = new int[0];	
		
		// 새로만든 배열에 addData를 사용하여 값을 넣어줌
		nums = addData(nums, 1);
		nums = addData(nums, 2);
		nums = addData(nums, 3);
		nums = addData(nums, 4);
		nums = addData(nums, 5);
		
		//
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
 
package j07_반복;

public class Star {

	public static void main(String[] args) {

		// 별 찍기
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 별 거꾸로 찍기
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 별 오른쪽부터 찍기
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10 - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 별 오른쪽부터 거꾸로 찍기
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 10 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 별 삼각형으로 찍기
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10 - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 별 다이아몬드로 찍기
		for (int i = 0; i < 9; i++) {
			if (i < 5) {
				for (int j = 0; j < 10 - i - 1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < 2 * i + 1; j++) {
					System.out.print("*");
				}
			}
			if (i > 4) {
				for (int j = 0; j < i + 1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < 2 * i - 3 - (4 * (i - 5)); j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}

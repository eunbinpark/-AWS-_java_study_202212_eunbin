package j01_출력;

import j17_스태틱.싱글톤.KIA;

public class HelloJava {

	public static void main(String[] args) {
		KIA.getInstance().printCompanyName();
	}
}

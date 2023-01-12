package j17_스태틱;

public class CarMain {

	public static void main(String[] args) {
		
		Car[] cars = new Car[3];
		
		cars[0] = new Car("K3");
		cars[1] = new Car("K5");
		cars[2] = new Car("K7");
		
		for(Car c : cars) {
			System.out.println(c);
		}
	}
}
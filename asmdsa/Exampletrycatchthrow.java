package asmdsa;

public class Exampletrycatchthrow {

	public void validateAge(int age) {
		if (age < 18) {
			throw new IllegalArgumentException("Age must be 18 or older");
		}
		System.out.println("Age is valid.");
	}

}

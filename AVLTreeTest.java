import java.util.Scanner;

public class AVLTreeTest {

	// declare constants
	public static final String TESTING_INSERT = "Testing add()";
	public static final String INSERTING = "Adicionando ";

	public static final String TESTING_FIND = "Testing contains()";
	public static final String FINDING = "Procurando ";

	public static final String SUCCESS = "SUCCESS!";
	public static final String FAILED = "FAILED!";

	public static final String CORRECT = "CORRECT!";
	public static final String INCORRECT = "INCORRECT!";

	public static final String ELLIPSIS = "...";

	public AVLTreeTest() {

	}

	public static void print(String msg, boolean newLine) {
		if (newLine) {
			System.out.println(msg);
		} else {
			System.out.print(msg);
		}
	}

	public static void print(int value, boolean newLine) {
		if (newLine) {
			System.out.println(value);
		} else {
			System.out.print(value);
		}
	}
}

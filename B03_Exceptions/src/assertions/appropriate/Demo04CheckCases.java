package assertions.appropriate;

/**
 * Do Use Assertions, Even in Public Methods, to Check for Cases that You Know
 * Are Never, Ever Supposed to Happen
 *
 */
public class Demo04CheckCases {
	public static void main(String[] args) {
		doStuff();
	}

	public static void doStuff() {
		int y = 0;
		for (int i = 0; i < 4; i++) {
			switch (i) {
			case 1:
				System.out.println("i ist 1");
				break;
			case 2:
				System.out.println("i ist 2");
				break;
			default:
				assert false: "we are not supposed to get here!" + i;
				
			}
		}

	}
}

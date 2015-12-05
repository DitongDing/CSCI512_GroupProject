package test.untested;

import csci512.Run;

public class RunTest {
	public static void main(String[] args) throws Exception {
		// Existence test with border. Expect true
		// String argus[] = { "./input/border/original.png", "./input/border/border", "existence", "exist", "./output/result" };
		// Existence test with Sikuli. Expect true
		// String argus[] = { "./input/sikuli/original.png", "./input/sikuli/stackoverflow.png", "existence", "not exist", "./output/result" };
		// Color test with border. Expect true
		// String argus[] = { "./input/border/original.png", "./input/border/border", "color", "white", "./output/result" };
		// Color test with Sikuli. Expect true
		// String argus[] = { "./input/sikuli/original.png", "./input/sikuli/signinbtn.png", "color", "blue", "./output/result" };
		// Position test with border. Expect true
		// String argus[] = { "./input/border/original.png", "./input/border/border", "position", "center", "./output/result" };
		// Position test with Sikuli. Expect true
		String argus[] = { "./input/sikuli/original.png", "./input/sikuli/signinbtn.png", "position", "bottom", "./output/result" };

		Run.main(argus);
	}
}
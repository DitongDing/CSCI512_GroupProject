package test.untested;

import csci512.Run;

public class RunTest {
	public static void main(String[] args) throws Exception {
		// Existence test with border. Expect true
		// String argus[] = { "./input/border/original.png", "./input/border/border", "existence", "exist", "./output/result" };
		// Existence test with Sikuli. Expect true
		// String argus[] = { "./input/sikuli/original.png", "./input/sikuli/stackoverflow.png", "existence", "", "./output/result" };
		// Color test with border. Expect true
		// String argus[] = { "./input/border/original.png", "./input/border/border", "color", "white", "./output/result" };
		// Color test with Sikuli. Expect true
		// String argus[] = { "./input/sikuli/original.png", "./input/sikuli/signinbtn.png", "color", "4285f4", "./output/result" };
		// Position test with border. Expect true
		// String argus[] = { "./input/border/original.png", "./input/border/border", "position", "center", "./output/result" };
		// Position test with Sikuli. Expect true
		// String argus[] = { "./input/sikuli/original.png", "./input/sikuli/signinbtn.png", "position", "bottom", "./output/result" };
		// Size test with Sikuli. Expect true
		String argus[] = { "./input/sikuli/original.png", "./input/sikuli/signinbtn.png", "size", "smaller, 35, height", "./output/result", "reversed" };

		Run.main(argus);
	}
}
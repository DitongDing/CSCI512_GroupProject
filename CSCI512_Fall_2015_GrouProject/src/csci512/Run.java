package csci512;

import csci512.utils.checker.Checker;
import csci512.utils.checker.CheckerFactory;

// Used to check visual invariants
// input: original, subImage|borderedsDir, type, property(, reversed)
// output: resultImage (with suffix passed|failed)
public class Run {
	public static void main(String[] args) {
		if (args == null || !(args.length == 5 || (args.length == 6 && args[5].equals("reversed")))) {
			System.err.println("Usage: Run original subImage|borderedsDir type property resultImage( reversed)");
			System.exit(-1);
		}

		final String original = args[0];
		final String selector = args[1];
		final String type = args[2];
		final String property = args[3];
		final Boolean reversed = args.length == 6;
		final String resultImage = args[4];

		Checker checker = CheckerFactory.newChecker(original, selector, type, property, reversed);
		checker.validate(resultImage);
	}
}
package test.untested;

import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) throws Exception {
		System.out.println(Pattern.compile("left|right|top|bottom|(((vertical|horizontal) )?center)").matcher(null).matches());
	}
}
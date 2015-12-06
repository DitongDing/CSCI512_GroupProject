package csci512.utils.checker;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

public class ExistenceChecker extends Checker {
	public ExistenceChecker(Boolean reversed, BufferedImage original, List<Rectangle> rectangles) {
		super(reversed, original, rectangles);
	}

	// return true only if: 1) shouldExist = false, rectangles.isEmpty = true, or 2) shouldExist = true, rectangles.isEmpty = false
	@Override
	protected boolean check() {
		boolean result = rectangles.isEmpty();
		if (result)
			passed = rectangles;
		else
			failed = rectangles;
		return result;
	}

	@Override
	protected boolean checkRectangle(Rectangle rectangle) {
		return false;
	}
}
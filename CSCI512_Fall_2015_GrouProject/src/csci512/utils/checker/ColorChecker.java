package csci512.utils.checker;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

import csci512.utils.ImageUtils;

public class ColorChecker extends Checker {
	private static double percentageThreshold = 0.75;

	private Color expect;

	public ColorChecker(BufferedImage original, List<Rectangle> rectangles, Color expect) {
		super(original, rectangles);
		this.expect = expect;
	}

	@Override
	protected boolean checkRectangle(Rectangle rectangle) {
		boolean result = true;

		int xMin = (int) rectangle.getX();
		int xMax = (int) (rectangle.getX() + rectangle.getWidth());
		int yMin = (int) rectangle.getY();
		int yMax = (int) (rectangle.getY() + rectangle.getHeight());

		int passed = 0;
		double total = rectangle.getWidth() * rectangle.getHeight();
		for (int x = xMin; x < xMax; x++)
			for (int y = yMin; y < yMax; y++) {
				Color actual = new Color(original.getRGB(x, y));
				if (ImageUtils.sameColor(expect, actual))
					passed++;
			}

		result = passed / total > percentageThreshold;

		return result;
	}

}
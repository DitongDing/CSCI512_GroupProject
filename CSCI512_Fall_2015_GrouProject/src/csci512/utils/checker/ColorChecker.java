package csci512.utils.checker;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

public class ColorChecker extends Checker {
	private static double percentageThreshold = 0.75;
	private static int RGBThreshold = 256;

	private Color color;

	public ColorChecker(BufferedImage original, List<Rectangle> rectangles, Color color) {
		super(original, rectangles);
		this.color = color;
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
				// TODO: <1 HIGH> similarity function.
				if (Math.abs(actual.getRed() - color.getRed()) < RGBThreshold && Math.abs(actual.getGreen() - color.getGreen()) < RGBThreshold
						&& Math.abs(actual.getRed() - color.getRed()) < RGBThreshold)
					passed++;
			}

		result = passed / total > percentageThreshold;

		return result;
	}

	private double colorSimilarity(Color expect, Color actual) {
		return 0;
	}
}
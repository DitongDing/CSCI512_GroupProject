package csci512.utils.checker;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

public class PositionChecker extends Checker {
	// if diff/total < precentageThreshold, then treat it as center
	private static double percentageThreshold = 0.05;

	private String position;

	public PositionChecker(Boolean reversed, BufferedImage original, List<Rectangle> rectangles, String position) {
		super(reversed, original, rectangles);
		this.position = position;
	}

	@Override
	protected boolean checkRectangle(Rectangle rectangle) {
		boolean result = true;

		double leftSpace = rectangle.getX();
		double rightSpace = original.getWidth() - (rectangle.getX() + rectangle.getWidth());
		double topSpace = rectangle.getY();
		double bottomSpace = original.getHeight() - (rectangle.getY() + rectangle.getHeight());

		double horizontalPercentage = (leftSpace - rightSpace) / original.getWidth();
		double verticalPercentage = (topSpace - bottomSpace) / original.getHeight();

		if (position.equals("left"))
			result = horizontalPercentage <= -percentageThreshold;
		else if (position.equals("vertical center"))
			result = Math.abs(horizontalPercentage) < percentageThreshold;
		else if (position.equals("right"))
			result = horizontalPercentage >= percentageThreshold;
		else if (position.equals("top"))
			result = verticalPercentage <= -percentageThreshold;
		else if (position.equals("vertical center"))
			result = Math.abs(verticalPercentage) < percentageThreshold;
		else if (position.equals("bottom"))
			result = verticalPercentage >= percentageThreshold;
		else if (position.equals("center"))
			result = Math.abs(horizontalPercentage) < percentageThreshold && Math.abs(verticalPercentage) < percentageThreshold;

		return result;
	}
}
package csci512.utils.checker;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

public class SizeChecker extends Checker {
	private enum Metric {
		width, height, area
	};

	private enum Direction {
		smaller, equal, larger
	};

	private Direction direction;
	private Integer datum;
	private Metric metric;

	public SizeChecker(Boolean reversed, BufferedImage original, List<Rectangle> rectangles, String property) {
		super(reversed, original, rectangles);

		int index = property.indexOf(',');
		String sub = property.substring(0, index).toLowerCase();
		if (sub.equals("smaller"))
			direction = Direction.smaller;
		else if (sub.equals("equal"))
			direction = Direction.equal;
		else if (sub.equals("larger"))
			direction = Direction.larger;

		property = property.substring(index + 2);
		index = property.indexOf(',');
		sub = property.substring(0, index);
		datum = Integer.parseInt(sub);

		property = property.substring(index + 2).toLowerCase();
		sub = property;
		if ("width".equals(sub))
			metric = Metric.width;
		else if ("height".equals(sub))
			metric = Metric.height;
		else if ("area".equals(sub))
			metric = Metric.area;
	}

	@Override
	protected boolean checkRectangle(Rectangle rectangle) {
		boolean result = false;

		int actual = -1;

		switch (metric) {
		case width:
			actual = rectangle.width;
			break;
		case height:
			actual = rectangle.height;
			break;
		case area:
			actual = rectangle.width * rectangle.height;
			break;
		}

		switch (direction) {
		case smaller:
			result = actual < datum;
			break;
		case equal:
			result = actual == datum;
			break;
		case larger:
			result = actual > datum;
			break;
		}

		return result;
	}
}
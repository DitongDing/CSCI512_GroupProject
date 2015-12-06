package csci512.utils.checker;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

public class SizeChecker extends Checker {
	private enum Metric {
		width, height, area
	};

	private Boolean smaller;
	private Integer datum;
	private Metric metric;

	public SizeChecker(Boolean reversed, BufferedImage original, List<Rectangle> rectangles, String property) {
		super(reversed, original, rectangles);
		int index = property.indexOf(',');
		smaller = property.substring(0, index).equals("smaller");
		property = property.substring(index + 2);
		index = property.indexOf(',');
		datum = Integer.parseInt(property.substring(0, index));
		property = property.substring(index + 2).toLowerCase();
		if ("width".equals(property))
			metric = Metric.width;
		else if ("height".equals(property))
			metric = Metric.height;
		else if ("area".equals(property))
			metric = Metric.area;
	}

	@Override
	protected boolean checkRectangle(Rectangle rectangle) {
		boolean result = false;

		switch (metric) {
		case width:
			result = rectangle.width != datum && !smaller ^ rectangle.width < datum;
			break;
		case height:
			result = rectangle.height != datum && !smaller ^ rectangle.height < datum;
			break;
		case area:
			double area = rectangle.width * rectangle.height;
			result = area != datum && !smaller ^ area < datum;
			break;
		}

		return result;
	}
}
package csci512.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;

public class ImageUtils {
	public static Rectangle findRectangle(BufferedImage original, BufferedImage bordered) {
		if (original == null || bordered == null || original.getHeight() != bordered.getHeight() || original.getWidth() != bordered.getWidth()) {
			System.out.println("ImageUtils.findRectangle: images are null or not the same size");
			return null;
		}

		int xMin = original.getWidth(), yMin = original.getWidth(), xMax = -1, yMax = -1;

		for (int x = 0; x < original.getWidth(); x++)
			for (int y = 0; y < original.getHeight(); y++)
				if (original.getRGB(x, y) != bordered.getRGB(x, y)) {
					if (x < xMin)
						xMin = x;
					if (x > xMax)
						xMax = x;
					if (y < yMin)
						yMin = y;
					if (y > yMax)
						yMax = y;
				}

		return new Rectangle(xMin, yMin, xMax - xMin, yMax - yMin);
	}

	public static List<Rectangle> findRectangles(BufferedImage original, List<BufferedImage> bordereds) {
		List<Rectangle> result = new ArrayList<Rectangle>();

		for (BufferedImage bordered : bordereds) {
			Rectangle rectangle = findRectangle(original, bordered);
			if (rectangle != null)
				result.add(rectangle);
		}

		return result;
	}

	public static List<Rectangle> findRectangles(String original, String subImage) {
		List<Rectangle> result = new ArrayList<Rectangle>();

		try {
			Finder finder = new Finder(original);
			Pattern pattern = new Pattern(subImage);

			finder.find(pattern);

			while (finder.hasNext()) {
				Match m = finder.next();
				result.add(new Rectangle(m.getX(), m.getY(), m.getW(), m.getH()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static void drawOuterRectangle(BufferedImage original, Rectangle rectangle, int thickness, Color color) {
		Graphics2D graph = original.createGraphics();
		graph.setColor(color);

		int x = (int) (rectangle.getX() - thickness + 1);
		int y = (int) (rectangle.getY() - thickness + 1);
		int width = (int) (rectangle.getWidth() + 2 * (thickness - 1));
		int height = (int) (rectangle.getHeight() + 2 * (thickness - 1));
		for (int i = 0; i < thickness; i++) {
			graph.drawRect(x, y, width, height);
			x++;
			y++;
			width -= 2;
			height -= 2;
		}
	}
}
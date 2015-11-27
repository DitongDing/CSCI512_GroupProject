package csci512.utils;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

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
}
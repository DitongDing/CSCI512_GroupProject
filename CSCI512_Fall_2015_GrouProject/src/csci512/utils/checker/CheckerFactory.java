package csci512.utils.checker;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import csci512.utils.ImageUtils;

public class CheckerFactory {
	public static Checker newChecker(String originalFile, String selectorFile, String type, String property) {
		Checker result = null;

		try {
			BufferedImage original = ImageIO.read(new File(originalFile));
			List<Rectangle> rectangles = null;
			File selector = new File(selectorFile);
			if (selector.isFile())
				rectangles = ImageUtils.findRectangles(originalFile, selectorFile);
			else if (selector.isDirectory()) {
				List<BufferedImage> bordereds = new ArrayList<BufferedImage>();
				for (File file : selector.listFiles())
					bordereds.add(ImageIO.read(file));
				rectangles = ImageUtils.findRectangles(original, bordereds);
			} else
				throw new Exception("CheckerFactory.newChecker: the selector file(s) does not exist (" + selectorFile + ")");

			result = getChecker(original, rectangles, type, property);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// For position: left|right|top|bottom|(((vertical|horizontal) )?center)
	// For color: red|green|blue|yellow|black|white|#[0-9A-F]{6}
	// For existence: exist|(not exist)
	private static Checker getChecker(BufferedImage original, List<Rectangle> rectangles, String type, String property) {
		Checker result = null;

		// TODO: <2 MID> finish CheckerFactory.newChecker()
		if ("position".equals(type)) {
			if (Pattern.compile("left|right|top|bottom|(((vertical|horizontal) )?center)").matcher(property).matches())
				result = new PositionChecker(original, rectangles, property);
		} else if ("color".equals(type)) {
			if ("red".equals(property))
				result = new ColorChecker(original, rectangles, Color.RED);
			else if ("green".equals(property))
				result = new ColorChecker(original, rectangles, Color.GREEN);
			else if ("blue".equals(property))
				result = new ColorChecker(original, rectangles, Color.BLUE);
			else if ("yellow".equals(property))
				result = new ColorChecker(original, rectangles, Color.YELLOW);
			else if ("black".equals(property))
				result = new ColorChecker(original, rectangles, Color.BLACK);
			else if ("white".equals(property))
				result = new ColorChecker(original, rectangles, Color.WHITE);
			else if (Pattern.compile("#[0-9A-F]{6}").matcher(property).matches())
				result = new ColorChecker(original, rectangles, new Color(Integer.valueOf(property.substring(1), 16)));
		} else if ("existence".equals(type)) {
			if ("exist".equals(property))
				result = new ExistenceChecker(original, rectangles, true);
			else if ("not exist".equals(property))
				result = new ExistenceChecker(original, rectangles, false);
		}
		if (result == null)
			System.out.println(String.format("CheckerFactory.newChecker: type error, please check (type = %s, property = %s)", type, property));

		return result;
	}
}

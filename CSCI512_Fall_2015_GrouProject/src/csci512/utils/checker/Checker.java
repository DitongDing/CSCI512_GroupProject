package csci512.utils.checker;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import csci512.utils.ImageUtils;

public abstract class Checker {
	// for result image
	private static Color passedColor = Color.GREEN;
	private static Color failedColor = Color.RED;
	private static int thickness = 5;

	protected Boolean reversed;
	protected BufferedImage original;
	protected List<Rectangle> rectangles;
	protected List<Rectangle> failed;
	protected List<Rectangle> passed;

	protected Boolean result;

	public Checker(Boolean reversed, BufferedImage original, List<Rectangle> rectangles) {
		this.reversed = reversed;
		this.original = original;
		this.rectangles = rectangles;
		failed = new ArrayList<Rectangle>();
		passed = new ArrayList<Rectangle>();
		result = null;
	}

	// Default implementation
	protected boolean check() {
		boolean result = !rectangles.isEmpty();

		if (result)
			for (Rectangle rectangle : rectangles) {
				if (checkRectangle(rectangle))
					passed.add(rectangle);
				else {
					result = false;
					failed.add(rectangle);
				}
			}

		return result;
	}

	protected abstract boolean checkRectangle(Rectangle rectangle);

	public void validate(String resultImage) {
		result = check();
		if (reversed) {
			result = !result;
			List<Rectangle> tmp = failed;
			failed = passed;
			passed = tmp;
		}
		System.out.print(result ? "passed" : "failed");
		saveResult(resultImage);
	}

	private void saveResult(String resultImage) {
		if (result == null) {
			System.err.println("Checker.saveResult: use saveResult after call check");
		} else {
			resultImage += (result ? "_passed" : "_failed") + ".png";
			File result = new File(resultImage);

			for (Rectangle rectangle : failed)
				ImageUtils.drawOuterRectangle(original, rectangle, thickness, failedColor);

			for (Rectangle rectangle : passed)
				ImageUtils.drawOuterRectangle(original, rectangle, thickness, passedColor);

			try {
				ImageIO.write(original, "png", result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
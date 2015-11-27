package test.passed;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import csci512.utils.ImageUtils;

public class TestFindRectangle {
	public static void main(String[] args) throws Exception {
		String originalFile = "./input/initial/original.png";
		String borderFile = "./input/initial/border.png";

		BufferedImage original = ImageIO.read(new File(originalFile));
		BufferedImage bordered = ImageIO.read(new File(borderFile));

		Rectangle result = ImageUtils.findRectangle(original, bordered);

		System.out.println(result);
	}
}
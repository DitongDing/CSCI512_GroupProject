package test.passed;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import csci512.utils.ImageUtils;

public class TestOuterBorder {
	public static void main(String[] args) throws Exception {
		BufferedImage image = ImageIO.read(new File("./input/initial/original.png"));

		ImageUtils.drawOuterRectangle(image, new Rectangle(429, 320, 585, 39), 5, Color.RED);

		ImageIO.write(image, "png", new File("./output/outerBorder/test.png"));
	}
}

package test.passed;

import java.awt.Rectangle;
import java.util.List;

import org.sikuli.script.*;

import csci512.utils.ImageUtils;

public class SikuliSubImageSearch {
	public static void main(String[] args) throws Exception {
		List<Rectangle> result = ImageUtils.findRectangles("./input/sikuli/original", "./input/sikuli/enlarged");
		
		for(Rectangle rectangle : result)
			System.out.println(rectangle);
	}
}
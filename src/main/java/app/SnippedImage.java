package app;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class SnippedImage {

	/**
	 * Create a screenshot of the full screen
	 * @return BufferedImage screenshot of entire screen
	 * @throws AWTException
	 */
	public static BufferedImage createScreenshot() throws AWTException {
		return createScreenshot(Toolkit.getDefaultToolkit().getScreenSize());
	}

	/**
	 * Create screenshot
	 * @param width
	 * @param length
	 * @return BufferedImage screenshot
	 * @throws AWTException
	 */
	public static BufferedImage createScreenshot(int width, int length) throws AWTException {
		Dimension area = new Dimension(width, length);
		return createScreenshot(area);

	}

	/**
	 * Create a screenshot from Dimension
	 * @param area
	 * @return Screenshot of area.
	 * @throws AWTException
	 */
	public static BufferedImage createScreenshot(Dimension area) throws AWTException {
		Robot rbt = new Robot();
		Rectangle capture = new Rectangle(area);

		BufferedImage Image = rbt.createScreenCapture(capture); 

		return Image;
	}


}

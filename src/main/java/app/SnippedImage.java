package app;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class SnippedImage {

	private BufferedImage screenshot;
	private int width;
	private int length;

	SnippedImage(int width, int length) throws AWTException{		
		this.width = width;
		this.length = length;
		this.screenshot = createScreenshot(this.width, this.length);
	}
	
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
	


	/**
	 * @return the screenshot
	 */
	public BufferedImage getScreenshot() {
		return screenshot;
	}

	/**
	 * @param screenshot the screenshot to set
	 */
	public void setScreenshot(BufferedImage screenshot) {
		this.screenshot = screenshot;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

}

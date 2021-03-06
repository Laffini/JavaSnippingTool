package adapters;

import java.awt.image.BufferedImage;

import interfaces.Events;

/**
 * AbstractAdapter provides a default implementation of the Events interface that other adapters can extend.
 *   
 * @author Laffini
 *
 */
public class AbstractAdapter implements Events {

	/**
	 * Default implementation of onScreenshot (do nothing).
	 */
	public void onScreenshot(BufferedImage screenshot) {
	}



}

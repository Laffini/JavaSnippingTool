package adapters;

import app.SnippedImage;
import interfaces.Events;

/**
 * AbstractAdapter provides a default implementation of the Events interface that other adapters can extend.
 * 
 * @author Laffini
 *
 */
public class AbstractAdapter implements Events {

	public void onScreenshot(SnippedImage screenshot) {
		
	}

}

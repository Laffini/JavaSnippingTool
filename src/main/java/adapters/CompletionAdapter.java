package adapters;

import java.awt.image.BufferedImage;

/**
 * Adapter that terminates the application once a screenshot has taken place.
 * @author Laffini
 *
 */
public class CompletionAdapter extends AbstractAdapter {

	@Override
	public void onScreenshot(BufferedImage screenshot) {

		System.exit(0);
	}

}

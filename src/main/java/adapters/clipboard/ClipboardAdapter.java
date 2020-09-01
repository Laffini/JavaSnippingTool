package adapters.clipboard;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.image.BufferedImage;

import adapters.AbstractAdapter;

/**
 * Adapter copies image to system clipboard
 * @author Laffini
 *
 */
public class ClipboardAdapter extends AbstractAdapter {

	@Override
	public void onScreenshot(BufferedImage screenshot) {

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		TransferableImage image = new TransferableImage(screenshot);

		clipboard.setContents(image, null);
	}
}

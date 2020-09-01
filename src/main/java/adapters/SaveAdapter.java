package adapters;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Adapter that saves the screenshot taken.
 * @author Laffini
 *
 */
public class SaveAdapter extends AbstractAdapter {

	@Override
	public void onScreenshot(BufferedImage screenshot){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");  
		Date date = new Date();  
		String dateTime = formatter.format(date); 


		File outputfile = new File(dateTime+".jpg");

		try {
			ImageIO.write(screenshot, "jpg", outputfile);
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Unable to save image.","Error",JOptionPane.ERROR_MESSAGE);

		}
	}

}

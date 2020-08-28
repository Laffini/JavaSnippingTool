package adapters;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class SaveAdapter extends AbstractAdapter {

	@Override
	public void onScreenshot(BufferedImage screenshot){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");  
		Date date = new Date();  
		String dateTime = formatter.format(date); 

		// TODO: Have a config.properties file that sets save location
		File outputfile = new File(dateTime+".jpg");

		try {
			ImageIO.write(screenshot, "jpg", outputfile);
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Unable to save image.","Error",JOptionPane.ERROR_MESSAGE);

		}
	}

}

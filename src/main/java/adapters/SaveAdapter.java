package adapters;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class SaveAdapter extends AbstractAdapter {
	
	public void onScreenshot(BufferedImage screenshot){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    String dateTime = formatter.format(date);  
		File outputfile = new File(dateTime+".jpg");
		try {
			ImageIO.write(screenshot, "jpg", outputfile);
		} catch (IOException e) {
			/*
			 *  TODO Add event that has 'onError' which is called when an exception occurs,
			 *   so remove this try catch and throw it up to when called (in ImagePane) if it fails it will call it
			 */
			e.printStackTrace();
		}
	}

}

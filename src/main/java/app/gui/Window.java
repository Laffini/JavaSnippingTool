package app.gui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.SnippedImage;

public class Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
		
		this.setTitle("Java Snipping Tool");
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		
		// Get and display screenshot of desktop
		screenshotOfDesktop();
		

		
		
	}
	
	
	/**
	 * Get and display a screenshot of the desktop
	 */
	public void screenshotOfDesktop() {		
		BufferedImage desktop = null;
		
		try {
			desktop = SnippedImage.createScreenshot();
			
		} catch (AWTException e) {
			
			JOptionPane.showMessageDialog(this,
				    "Unable to create screenshot.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			
			// If unable to screenshot exit
			System.exit(0);
			
		}
		ImageIcon imgDesktop = new ImageIcon(desktop);
		JLabel label = new JLabel (imgDesktop);
		this.add(label);
	}

}

package app.gui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.EventHandler;
import app.SnippedImage;
import interfaces.Events;



public class Window extends JFrame {
	private EventHandler eventHandler;
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


		String systemLookAndFeel = UIManager.getSystemLookAndFeelClassName();
		setLookAndFeel(systemLookAndFeel);


		// Get and display screenshot of desktop
		BufferedImage desktop = null;
		try {
			desktop = SnippedImage.createScreenshot();

		} catch (AWTException e) {
			JOptionPane.showMessageDialog(this, "Unable to create screenshot.", "Error", JOptionPane.ERROR_MESSAGE);


		}



		ImageIcon imgDesktop = new ImageIcon(desktop);
		JLabel label = new JLabel(imgDesktop);
		this.add(label);

		ImagePane selection = new ImagePane(this, desktop);
		this.add(selection);


		// Get & set Adapters from adapters.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("adapters/adapters.xml");
		ArrayList<Events> listeners = (ArrayList<Events>) context.getBean("adapters");
		this.eventHandler = new EventHandler(listeners);






	}

	/**
	 * Set the look and feel of the window to the system's
	 */
	public void setLookAndFeel(String lookAndFeel) {
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e) {

			e.printStackTrace(); 
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {

			e.printStackTrace();
		}
	}

	/**
	 * @return the eventHandler
	 */
	public EventHandler getEventHandler() {
		return eventHandler;
	}

	/**
	 * @param eventHandler the eventHandler to set
	 */
	public void setEventHandler(EventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}






}

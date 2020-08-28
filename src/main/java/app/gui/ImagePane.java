package app.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class ImagePane extends JPanel {



	private BufferedImage background;
	private Rectangle selection;
	private JFrame frame;

	public ImagePane(final Window frame, BufferedImage img) {
		background = img;
		this.frame = frame;

		MouseAdapter ma = new MouseAdapter() {

			private Point clickPoint;

			@Override
			public void mousePressed(MouseEvent e) {
				clickPoint = e.getPoint();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				Point dragPoint = e.getPoint();

				int x = Math.min(clickPoint.x, dragPoint.x);
				int y = Math.min(clickPoint.y, dragPoint.y);
				int width = Math.abs(clickPoint.x - dragPoint.x);
				int height = Math.abs(clickPoint.y - dragPoint.y);

				selection = new Rectangle(x, y, width, height);
				repaint();


			}

			@Override
			public void mouseReleased(MouseEvent e) {
				BufferedImage areaSelected = getSubImage();

				// Notify listeners 
				frame.getEventHandler().notifyOnScreenshot(areaSelected);



			}

		};

		addMouseListener(ma);
		addMouseMotionListener(ma);
	}

	public void clearSelection() {
		selection = null;
		repaint();
	}

	public BufferedImage getSubImage() {

		BufferedImage img = null;
		if (selection != null) {

			img = background.getSubimage(selection.x, selection.y, selection.width, selection.height);

		}
		return img;

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(background.getWidth(), background.getHeight());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		int x = (getWidth() - background.getWidth()) / 2;
		int y = (getHeight() - background.getHeight()) / 2;
		g2d.drawImage(background, x, y, this);
		if (selection != null) {
			Color stroke = UIManager.getColor("List.selectionBackground");
			Color fill = new Color(stroke.getRed(), stroke.getGreen(), stroke.getBlue(), 128);
			g2d.setColor(fill);
			g2d.fill(selection);
			g2d.setColor(stroke);
			g2d.draw(selection);
		}
		g2d.dispose();
	}





}

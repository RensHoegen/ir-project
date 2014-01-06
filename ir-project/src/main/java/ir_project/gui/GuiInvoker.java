package ir_project.gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class GuiInvoker {

	private JFrame frmClusteredImageRetrieval;
	private JLabel statusbar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiInvoker window = new GuiInvoker();
					window.frmClusteredImageRetrieval.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiInvoker() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClusteredImageRetrieval = new JFrame();
		frmClusteredImageRetrieval.getContentPane().setBackground(
				new Color(96, 97, 98));
		frmClusteredImageRetrieval.getContentPane().setComponentOrientation(
				ComponentOrientation.LEFT_TO_RIGHT);
		frmClusteredImageRetrieval.setTitle("Clustered Image Retrieval System");
		frmClusteredImageRetrieval.getContentPane().setCursor(
				Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		frmClusteredImageRetrieval.setBackground(SystemColor.activeCaption);
		frmClusteredImageRetrieval.getContentPane().setFont(
				new Font("Century Gothic", Font.PLAIN, 16));

		frmClusteredImageRetrieval.getContentPane().setLayout(null);

		// Handlerclass2 handler2 = new Handlerclass2();
		// JButton btnQuit = new JButton("");
		// btnQuit.setIcon(new
		// ImageIcon(GuiInvoker.class.getResource("quit.png")));
		// btnQuit.setRolloverIcon(new ImageIcon(GuiInvoker.class
		// .getResource("quit_over.png")));
		// btnQuit.setBounds(1224, 6, 50, 50);
		// btnQuit.setBorderPainted(false);
		// btnQuit.setContentAreaFilled(false);
		// btnQuit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		// frmClusteredImageRetrieval.getContentPane().add(btnQuit);
		// btnQuit.addMouseListener(handler2);
		// btnQuit.addMouseMotionListener(handler2);

		statusbar = new JLabel("");
		statusbar.setHorizontalAlignment(SwingConstants.CENTER);
		statusbar.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		statusbar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		statusbar.setBounds(845, 358, 308, 45);
		statusbar.setPreferredSize(new Dimension(150, 150));
		statusbar.setText("Find this image!");
		frmClusteredImageRetrieval.getContentPane().add(statusbar);

		Handlerclass handler = new Handlerclass();

		JButton image_1 = new JButton("1");
		image_1.setBounds(21, 20, 150, 150);
		image_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_1.setAlignmentY(Component.TOP_ALIGNMENT);
		image_1.setIcon(new ImageIcon(GuiInvoker.class.getResource("1.jpg")));
		image_1.setIconTextGap(10);
		image_1.setPreferredSize(new Dimension(150, 150));
		image_1.setBorder(null);
		image_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_1);

		JButton image_2 = new JButton("2");
		image_2.setBounds(196, 20, 150, 150);
		image_2.setIcon(new ImageIcon(GuiInvoker.class.getResource("2.jpeg")));
		image_2.setPreferredSize(new Dimension(150, 150));
		image_2.setIconTextGap(10);
		image_2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_2.setBorder(null);
		image_2.setAlignmentY(0.0f);
		image_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_2);

		JButton image_3 = new JButton("3");
		image_3.setIcon(new ImageIcon(GuiInvoker.class.getResource("3.jpg")));
		image_3.setPreferredSize(new Dimension(150, 150));
		image_3.setIconTextGap(10);
		image_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_3.setBorder(null);
		image_3.setAlignmentY(0.0f);
		image_3.setBounds(371, 20, 150, 150);
		image_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_3);

		JButton image_4 = new JButton("4");
		image_4.setIcon(new ImageIcon(GuiInvoker.class.getResource("4.jpg")));
		image_4.setPreferredSize(new Dimension(150, 150));
		image_4.setIconTextGap(10);
		image_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_4.setBorder(null);
		image_4.setAlignmentY(0.0f);
		image_4.setBounds(546, 20, 150, 150);
		image_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_4);

		JButton image_5 = new JButton("5");
		image_5.setIcon(new ImageIcon(GuiInvoker.class.getResource("5.jpeg")));
		image_5.setPreferredSize(new Dimension(150, 150));
		image_5.setIconTextGap(10);
		image_5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_5.setBorder(null);
		image_5.setAlignmentY(0.0f);
		image_5.setBounds(21, 215, 150, 150);
		image_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_5);

		JButton image_6 = new JButton("6");
		image_6.setIcon(new ImageIcon(GuiInvoker.class.getResource("6.jpg")));
		image_6.setPreferredSize(new Dimension(150, 150));
		image_6.setIconTextGap(10);
		image_6.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_6.setBorder(null);
		image_6.setAlignmentY(0.0f);
		image_6.setBounds(196, 215, 150, 150);
		image_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_6);

		JButton image_7 = new JButton("7");
		image_7.setIcon(new ImageIcon(GuiInvoker.class.getResource("7.jpeg")));
		image_7.setPreferredSize(new Dimension(150, 150));
		image_7.setIconTextGap(10);
		image_7.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_7.setBorder(null);
		image_7.setAlignmentY(0.0f);
		image_7.setBounds(371, 215, 150, 150);
		image_7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_7);

		JButton image_8 = new JButton("8");
		image_8.setIcon(new ImageIcon(GuiInvoker.class.getResource("8.jpg")));
		image_8.setPreferredSize(new Dimension(150, 150));
		image_8.setIconTextGap(10);
		image_8.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_8.setBorder(null);
		image_8.setAlignmentY(0.0f);
		image_8.setBounds(546, 215, 150, 150);
		image_8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_8);

		JButton image_9 = new JButton("9");
		image_9.setIcon(new ImageIcon(GuiInvoker.class.getResource("9.jpg")));
		image_9.setPreferredSize(new Dimension(150, 150));
		image_9.setIconTextGap(10);
		image_9.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_9.setBorder(null);
		image_9.setAlignmentY(0.0f);
		image_9.setBounds(21, 411, 150, 150);
		image_9.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_9);

		JButton image_10 = new JButton("10");
		image_10.setIcon(new ImageIcon(GuiInvoker.class.getResource("10.jpeg")));
		image_10.setPreferredSize(new Dimension(150, 150));
		image_10.setIconTextGap(10);
		image_10.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_10.setBorder(null);
		image_10.setAlignmentY(0.0f);
		image_10.setBounds(196, 411, 150, 150);
		image_10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_10);

		JButton image_11 = new JButton("11");
		image_11.setIcon(new ImageIcon(GuiInvoker.class.getResource("11.jpeg")));
		image_11.setPreferredSize(new Dimension(150, 150));
		image_11.setIconTextGap(10);
		image_11.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_11.setBorder(null);
		image_11.setAlignmentY(0.0f);
		image_11.setBounds(371, 411, 150, 150);
		image_11.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_11);

		JButton image_12 = new JButton("12");
		image_12.setIcon(new ImageIcon(GuiInvoker.class.getResource("12.jpeg")));
		image_12.setPreferredSize(new Dimension(150, 150));
		image_12.setIconTextGap(10);
		image_12.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_12.setBorder(null);
		image_12.setAlignmentY(0.0f);
		image_12.setBounds(546, 411, 150, 150);
		image_12.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_12);

		JButton image_13 = new JButton("13");
		image_13.setIcon(new ImageIcon(GuiInvoker.class.getResource("13.jpeg")));
		image_13.setPreferredSize(new Dimension(150, 150));
		image_13.setIconTextGap(10);
		image_13.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_13.setBorder(null);
		image_13.setAlignmentY(0.0f);
		image_13.setBounds(21, 607, 150, 150);
		image_13.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_13);

		JButton image_14 = new JButton("14");
		image_14.setIcon(new ImageIcon(GuiInvoker.class.getResource("14.jpeg")));
		image_14.setPreferredSize(new Dimension(150, 150));
		image_14.setIconTextGap(10);
		image_14.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_14.setBorder(null);
		image_14.setAlignmentY(0.0f);
		image_14.setBounds(196, 607, 150, 150);
		image_14.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_14);

		JButton image_15 = new JButton("15");
		image_15.setIcon(new ImageIcon(GuiInvoker.class.getResource("15.jpg")));
		image_15.setPreferredSize(new Dimension(150, 150));
		image_15.setIconTextGap(10);
		image_15.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_15.setBorder(null);
		image_15.setAlignmentY(0.0f);
		image_15.setBounds(371, 607, 150, 150);
		image_15.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_15);

		JButton image_16 = new JButton("16");
		image_16.setIcon(new ImageIcon(GuiInvoker.class.getResource("16.jpg")));
		image_16.setPreferredSize(new Dimension(150, 150));
		image_16.setIconTextGap(10);
		image_16.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_16.setBorder(null);
		image_16.setAlignmentY(0.0f);
		image_16.setBounds(546, 607, 150, 150);
		image_16.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_16);

		JLabel search_image = new JLabel("search image");
		search_image.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("search_image.png")));
		search_image.setPreferredSize(new Dimension(308, 309));
		search_image.setIconTextGap(10);
		search_image
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		search_image.setBorder(null);
		search_image.setAlignmentY(0.0f);
		search_image.setBounds(845, 42, 308, 309);
		frmClusteredImageRetrieval.getContentPane().add(search_image);

		JLabel cluster1_image = new JLabel("1");
		cluster1_image.setBounds(814, 433, 66, 66);
		cluster1_image
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster1_image.setAlignmentY(Component.TOP_ALIGNMENT);
		cluster1_image.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("active_cluster.png")));
		cluster1_image.setIconTextGap(10);
		cluster1_image.setPreferredSize(new Dimension(60, 60));
		cluster1_image.setBorder(new LineBorder(new Color(64, 64, 64)));
		cluster1_image.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(cluster1_image);

		Handlerclass3 cluster1_handler = new Handlerclass3();

		JButton cluster1 = new JButton("");
		cluster1.setHorizontalAlignment(SwingConstants.LEFT);
		cluster1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster1.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster1_normal.png")));
		cluster1.setPreferredSize(new Dimension(557, 66));
		cluster1.setIconTextGap(10);
		cluster1.setBorder(null);
		cluster1.setAlignmentY(0.0f);
		cluster1.setBounds(880, 433, 400, 66);
		cluster1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cluster1.setRolloverIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster1_over.png")));
		cluster1.setPressedIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster1_over.png")));

		JLabel cluster2_image = new JLabel("2");
		cluster2_image.setPreferredSize(new Dimension(60, 60));
		cluster2_image.setIconTextGap(10);
		cluster2_image.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("active_cluster.png")));
		cluster2_image
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster2_image.setBorder(new LineBorder(new Color(64, 64, 64)));
		cluster2_image.setAlignmentY(0.0f);
		cluster2_image.setBounds(814, 499, 66, 66);
		frmClusteredImageRetrieval.getContentPane().add(cluster2_image);

		JButton cluster2 = new JButton("");
		cluster2.setHorizontalAlignment(SwingConstants.LEFT);
		cluster2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster2.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster2_normal.png")));
		cluster2.setPreferredSize(new Dimension(557, 66));
		cluster2.setIconTextGap(10);
		cluster2.setBorder(null);
		cluster2.setAlignmentY(0.0f);
		cluster2.setBounds(880, 499, 400, 66);
		cluster2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cluster2.setRolloverIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster2_over.png")));
		cluster2.setPressedIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster2_over.png")));

		JLabel cluster3_image = new JLabel("3");
		cluster3_image.setPreferredSize(new Dimension(60, 60));
		cluster3_image.setIconTextGap(10);
		cluster3_image.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("active_cluster.png")));
		cluster3_image
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster3_image.setBorder(new LineBorder(new Color(64, 64, 64)));
		cluster3_image.setAlignmentY(0.0f);
		cluster3_image.setBounds(814, 565, 66, 66);
		frmClusteredImageRetrieval.getContentPane().add(cluster3_image);

		JButton cluster3 = new JButton("");
		cluster3.setHorizontalAlignment(SwingConstants.LEFT);
		cluster3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster3.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster3_normal.png")));
		cluster3.setPreferredSize(new Dimension(557, 66));
		cluster3.setIconTextGap(10);
		cluster3.setBorder(null);
		cluster3.setAlignmentY(0.0f);
		cluster3.setBounds(880, 565, 400, 66);
		cluster3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cluster3.setRolloverIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster3_over.png")));
		cluster3.setPressedIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster3_over.png")));

		JLabel cluster4_image = new JLabel("4");
		cluster4_image.setPreferredSize(new Dimension(60, 60));
		cluster4_image.setIconTextGap(10);
		cluster4_image.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("active_cluster.png")));
		cluster4_image
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster4_image.setBorder(new LineBorder(new Color(64, 64, 64)));
		cluster4_image.setAlignmentY(0.0f);
		cluster4_image.setBounds(814, 631, 66, 66);
		frmClusteredImageRetrieval.getContentPane().add(cluster4_image);

		JButton cluster4 = new JButton("");
		cluster4.setHorizontalAlignment(SwingConstants.LEFT);
		cluster4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster4.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster4_normal.png")));
		cluster4.setPreferredSize(new Dimension(557, 66));
		cluster4.setIconTextGap(10);
		cluster4.setBorder(null);
		cluster4.setAlignmentY(0.0f);
		cluster4.setBounds(880, 631, 400, 66);
		cluster4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cluster4.setRolloverIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster4_over.png")));
		cluster4.setPressedIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster4_over.png")));

		JLabel cluster5_image = new JLabel("5");
		cluster5_image.setPreferredSize(new Dimension(60, 60));
		cluster5_image.setIconTextGap(10);
		cluster5_image.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("active_cluster.png")));
		cluster5_image
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster5_image.setBorder(new LineBorder(new Color(64, 64, 64)));
		cluster5_image.setAlignmentY(0.0f);
		cluster5_image.setBounds(814, 697, 66, 66);
		frmClusteredImageRetrieval.getContentPane().add(cluster5_image);

		JButton cluster5 = new JButton("");
		cluster5.setHorizontalAlignment(SwingConstants.LEFT);
		cluster5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster5.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster5_normal.png")));
		cluster5.setPreferredSize(new Dimension(557, 66));
		cluster5.setIconTextGap(10);
		cluster5.setBorder(null);
		cluster5.setAlignmentY(0.0f);
		cluster5.setBounds(880, 697, 400, 66);
		cluster5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cluster5.setRolloverIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster5_over.png")));
		cluster5.setPressedIcon(new ImageIcon(GuiInvoker.class
				.getResource("cluster5_over.png")));

		frmClusteredImageRetrieval.getContentPane().add(cluster1);
		frmClusteredImageRetrieval.getContentPane().add(cluster2);
		frmClusteredImageRetrieval.getContentPane().add(cluster3);
		frmClusteredImageRetrieval.getContentPane().add(cluster4);
		frmClusteredImageRetrieval.getContentPane().add(cluster5);

		cluster1.addMouseListener(cluster1_handler);
		cluster1.addMouseMotionListener(cluster1_handler);

		JLabel background = new JLabel("16");
		background.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("gui.png")));
		background.setPreferredSize(new Dimension(150, 150));
		background.setIconTextGap(10);
		background.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		background.setBorder(null);
		background.setAlignmentY(0.0f);
		background.setBounds(0, 0, 1280, 800);

		frmClusteredImageRetrieval.getContentPane().add(background);
		background.addMouseListener(handler);
		background.addMouseMotionListener(handler);

		frmClusteredImageRetrieval.setUndecorated(true);

		frmClusteredImageRetrieval.setBounds(0, 0, 1280, 800);
		frmClusteredImageRetrieval
				.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GraphicsDevice device = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getScreenDevices()[0];
		device.setFullScreenWindow(frmClusteredImageRetrieval);

		// frmClusteredImageRetrieval.setExtendedState(frmClusteredImageRetrieval
		// .getExtendedState() | Frame.MAXIMIZED_BOTH);

		addComponentsToPane(frmClusteredImageRetrieval.getContentPane());

		frmClusteredImageRetrieval.setResizable(false);
		// frmClusteredImageRetrieval.setSize(width, height);

		frmClusteredImageRetrieval.setVisible(true);
	}

	private void addComponentsToPane(Container contentPane) {
		// TODO Auto-generated method stub

	}

	private class Handlerclass implements MouseListener, MouseMotionListener {
		public void mouseClicked(MouseEvent event) {
			// statusbar.setText(String.format("Clicked at %d,%d",
			// event.getX(),event.getY()));
		}

		public void mousePressed(MouseEvent event) {
			// statusbar.setText("Pressed");
		}

		public void mouseReleased(MouseEvent event) {
			// statusbar.setText("Released");
		}

		public void mouseEntered(MouseEvent event) {
			// statusbar.setText("Entered");
		}

		public void mouseExited(MouseEvent event) {
			// statusbar.setText("Exited");
		}

		public void mouseDragged(MouseEvent event) {
			// statusbar.setText("Dragged");

		}

		public void mouseMoved(MouseEvent event) {
			// statusbar.setText("Moved");

		}

	}

	// private class Handlerclass2 implements MouseListener, MouseMotionListener
	// {
	// public void mouseClicked(MouseEvent event) {

	// }

	// public void mousePressed(MouseEvent event) {

	// }

	// public void mouseReleased(MouseEvent event) {
	// System.exit(0);
	// }

	// public void mouseEntered(MouseEvent event) {

	// }

	// public void mouseExited(MouseEvent event) {

	// }

	// public void mouseDragged(MouseEvent event) {

	// }

	// public void mouseMoved(MouseEvent event) {

	// }

	// }

	private class Handlerclass3 implements MouseListener, MouseMotionListener {
		public void mouseClicked(MouseEvent event) {

		}

		public void mousePressed(MouseEvent event) {

		}

		public void mouseReleased(MouseEvent event) {

		}

		public void mouseEntered(MouseEvent event) {

		}

		public void mouseExited(MouseEvent event) {

		}

		public void mouseDragged(MouseEvent event) {

		}

		public void mouseMoved(MouseEvent event) {

		}

	}
}

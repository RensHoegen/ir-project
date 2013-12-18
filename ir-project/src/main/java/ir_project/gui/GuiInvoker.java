package ir_project.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GuiInvoker {

	private JFrame frame;
	private JLabel statusbar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiInvoker window = new GuiInvoker();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.getContentPane().setCursor(
				Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.getContentPane().setBackground(new Color(112, 128, 144));
		frame.setBackground(SystemColor.activeCaption);
		frame.getContentPane().setFont(
				new Font("Century Gothic", Font.PLAIN, 16));
		frame.getContentPane().setLayout(null);

		statusbar = new JLabel("image_1 status");
		statusbar.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		statusbar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		statusbar.setBounds(245, 122, 312, 54);
		statusbar.setPreferredSize(new Dimension(150, 150));
		frame.getContentPane().add(statusbar);

		Handlerclass handler = new Handlerclass();

		JLabel image_1 = new JLabel("1");
		image_1.setBounds(85, 181, 150, 150);
		image_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_1.setAlignmentY(Component.TOP_ALIGNMENT);
		image_1.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("1.jpg")));
		image_1.setIconTextGap(10);
		image_1.setPreferredSize(new Dimension(150, 150));
		image_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_1);
		image_1.addMouseListener(handler);
		image_1.addMouseMotionListener(handler);

		JLabel image_2 = new JLabel("2");
		image_2.setBounds(245, 181, 150, 150);
		image_2.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("2.jpeg")));
		image_2.setPreferredSize(new Dimension(150, 150));
		image_2.setIconTextGap(10);
		image_2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_2.setAlignmentY(0.0f);
		image_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_2);

		JLabel image_3 = new JLabel("3");
		image_3.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("3.jpg")));
		image_3.setPreferredSize(new Dimension(150, 150));
		image_3.setIconTextGap(10);
		image_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_3.setAlignmentY(0.0f);
		image_3.setBounds(405, 181, 150, 150);
		image_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_3);

		JLabel image_4 = new JLabel("4");
		image_4.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("4.jpg")));
		image_4.setPreferredSize(new Dimension(150, 150));
		image_4.setIconTextGap(10);
		image_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_4.setAlignmentY(0.0f);
		image_4.setBounds(565, 181, 150, 150);
		image_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_4);

		JLabel image_5 = new JLabel("5");
		image_5.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("5.jpeg")));
		image_5.setPreferredSize(new Dimension(150, 150));
		image_5.setIconTextGap(10);
		image_5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_5.setAlignmentY(0.0f);
		image_5.setBounds(85, 342, 150, 150);
		image_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_5);

		JLabel image_6 = new JLabel("6");
		image_6.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("6.jpg")));
		image_6.setPreferredSize(new Dimension(150, 150));
		image_6.setIconTextGap(10);
		image_6.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_6.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_6.setAlignmentY(0.0f);
		image_6.setBounds(245, 342, 150, 150);
		image_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_6);

		JLabel image_7 = new JLabel("7");
		image_7.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("7.jpeg")));
		image_7.setPreferredSize(new Dimension(150, 150));
		image_7.setIconTextGap(10);
		image_7.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_7.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_7.setAlignmentY(0.0f);
		image_7.setBounds(405, 342, 150, 150);
		image_7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_7);

		JLabel image_8 = new JLabel("8");
		image_8.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("8.jpg")));
		image_8.setPreferredSize(new Dimension(150, 150));
		image_8.setIconTextGap(10);
		image_8.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_8.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_8.setAlignmentY(0.0f);
		image_8.setBounds(565, 342, 150, 150);
		image_8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_8);

		JLabel image_9 = new JLabel("9");
		image_9.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("9.jpg")));
		image_9.setPreferredSize(new Dimension(150, 150));
		image_9.setIconTextGap(10);
		image_9.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_9.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_9.setAlignmentY(0.0f);
		image_9.setBounds(85, 503, 150, 150);
		image_9.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_9);

		JLabel image_10 = new JLabel("10");
		image_10.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("10.jpeg")));
		image_10.setPreferredSize(new Dimension(150, 150));
		image_10.setIconTextGap(10);
		image_10.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_10.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_10.setAlignmentY(0.0f);
		image_10.setBounds(245, 503, 150, 150);
		image_10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_10);

		JLabel image_11 = new JLabel("11");
		image_11.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("11.jpeg")));
		image_11.setPreferredSize(new Dimension(150, 150));
		image_11.setIconTextGap(10);
		image_11.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_11.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_11.setAlignmentY(0.0f);
		image_11.setBounds(405, 503, 150, 150);
		image_11.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_11);

		JLabel image_12 = new JLabel("12");
		image_12.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("12.jpeg")));
		image_12.setPreferredSize(new Dimension(150, 150));
		image_12.setIconTextGap(10);
		image_12.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_12.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_12.setAlignmentY(0.0f);
		image_12.setBounds(565, 503, 150, 150);
		image_12.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_12);

		JLabel image_13 = new JLabel("13");
		image_13.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("13.jpeg")));
		image_13.setPreferredSize(new Dimension(150, 150));
		image_13.setIconTextGap(10);
		image_13.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_13.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_13.setAlignmentY(0.0f);
		image_13.setBounds(85, 664, 150, 150);
		image_13.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_13);

		JLabel image_14 = new JLabel("14");
		image_14.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("14.jpeg")));
		image_14.setPreferredSize(new Dimension(150, 150));
		image_14.setIconTextGap(10);
		image_14.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_14.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_14.setAlignmentY(0.0f);
		image_14.setBounds(245, 664, 150, 150);
		image_14.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_14);

		JLabel image_15 = new JLabel("15");
		image_15.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("15.jpg")));
		image_15.setPreferredSize(new Dimension(150, 150));
		image_15.setIconTextGap(10);
		image_15.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_15.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_15.setAlignmentY(0.0f);
		image_15.setBounds(405, 664, 150, 150);
		image_15.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_15);

		JLabel image_16 = new JLabel("16");
		image_16.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("16.jpg")));
		image_16.setPreferredSize(new Dimension(150, 150));
		image_16.setIconTextGap(10);
		image_16.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_16.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image_16.setAlignmentY(0.0f);
		image_16.setBounds(565, 664, 150, 150);
		image_16.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(image_16);

		JLabel Status_1 = new JLabel("Image 1");
		Status_1.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("state_active.png")));
		Status_1.setPreferredSize(new Dimension(75, 75));
		Status_1.setMinimumSize(new Dimension(0, 0));
		Status_1.setMaximumSize(new Dimension(0, 0));
		Status_1.setIconTextGap(10);
		Status_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Status_1.setBorder(null);
		Status_1.setAlignmentY(0.0f);
		Status_1.setBounds(85, 30, 80, 80);
		frame.getContentPane().add(Status_1);

		JLabel Status_2 = new JLabel("Image 1");
		Status_2.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("state_normal.png")));
		Status_2.setPreferredSize(new Dimension(75, 75));
		Status_2.setMinimumSize(new Dimension(0, 0));
		Status_2.setMaximumSize(new Dimension(0, 0));
		Status_2.setIconTextGap(10);
		Status_2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Status_2.setBorder(null);
		Status_2.setAlignmentY(0.0f);
		Status_2.setBounds(220, 30, 80, 80);
		frame.getContentPane().add(Status_2);

		JLabel Status_3 = new JLabel("Image 1");
		Status_3.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("state_normal.png")));
		Status_3.setPreferredSize(new Dimension(75, 75));
		Status_3.setMinimumSize(new Dimension(0, 0));
		Status_3.setMaximumSize(new Dimension(0, 0));
		Status_3.setIconTextGap(10);
		Status_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Status_3.setBorder(null);
		Status_3.setAlignmentY(0.0f);
		Status_3.setBounds(360, 30, 80, 80);
		frame.getContentPane().add(Status_3);

		JLabel Status_4 = new JLabel("Image 1");
		Status_4.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("state_normal.png")));
		Status_4.setPreferredSize(new Dimension(75, 75));
		Status_4.setMinimumSize(new Dimension(0, 0));
		Status_4.setMaximumSize(new Dimension(0, 0));
		Status_4.setIconTextGap(10);
		Status_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Status_4.setBorder(null);
		Status_4.setAlignmentY(0.0f);
		Status_4.setBounds(506, 30, 80, 80);
		frame.getContentPane().add(Status_4);

		JLabel Status_5 = new JLabel("Image 1");
		Status_5.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("state_normal.png")));
		Status_5.setPreferredSize(new Dimension(75, 75));
		Status_5.setMinimumSize(new Dimension(0, 0));
		Status_5.setMaximumSize(new Dimension(0, 0));
		Status_5.setIconTextGap(10);
		Status_5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Status_5.setBorder(null);
		Status_5.setAlignmentY(0.0f);
		Status_5.setBounds(635, 30, 80, 80);
		frame.getContentPane().add(Status_5);

		frame.setBounds(100, 100, 800, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class Handlerclass implements MouseListener, MouseMotionListener {
		public void mouseClicked(MouseEvent event) {
			statusbar.setText(String.format("Clicked at %d,%d", event.getX(),
					event.getY()));
		}

		public void mousePressed(MouseEvent event) {
			statusbar.setText("Pressed");
		}

		public void mouseReleased(MouseEvent event) {
			statusbar.setText("Released");
		}

		public void mouseEntered(MouseEvent event) {
			statusbar.setText("Entered");
		}

		public void mouseExited(MouseEvent event) {
			statusbar.setText("Exited");
		}

		public void mouseDragged(MouseEvent event) {
			statusbar.setText("Dragged");

		}

		public void mouseMoved(MouseEvent event) {
			statusbar.setText("Moved");

		}

	}
}

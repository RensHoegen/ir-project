package ir_project_baseline.gui;

import ir_project.clustering.ClusteringUtils;
import ir_project.clustering.SearchUtils;
import ir_project.io.ImageSummaryReference;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class GuiInvoker {

	private static final File IMG_DIR = new File(
			"C:\\Users\\Rens\\Studie\\School\\Information Retrieval\\MIRFLICKR\\mirflickr08_images1\\images");
	private JFrame frmClusteredImageRetrieval;
	private ImageSummaryReference imageReference;
	private List<Color[]> pathBar = new ArrayList<Color[]>();
	private List<Integer> pathBarImages = new ArrayList<Integer>();
	private int imageToFind;
	
	private JButton startReset;
	private boolean started=false;
	private long startTime;
	
	JButton colorPickerB1;
	JButton colorPickerB2;
	JButton colorPickerB3;
	JButton colorPickerB4;
	JButton colorPickerB5;
	
	private JButton[] imagebuttons;
	private JButton[] pathBarButtons;
	private JButton[] colorPickers;

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
	public GuiInvoker() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws FileNotFoundException, IOException,
			ClassNotFoundException {

		System.out.println("Loading...");
		imageReference = ImageSummaryReference.loadImageSummary();

		frmClusteredImageRetrieval = new JFrame();

		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

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

		final ColorChooserDemo colorPicker = new ColorChooserDemo();
		colorPicker.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		colorPicker.setPreferredSize(new Dimension(557, 66));
		colorPicker.setBorder(new MatteBorder(0, 0, 0, 1, (Color) Color.BLACK));

		colorPicker.setAlignmentY(0.0f);
		colorPicker.setBounds(750, 415, 600, 250);
		colorPicker.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(colorPicker);

		colorPickerB1 = new JButton("Pick Color 1");
		colorPickerB1.setBounds(725, 675, 105, 40);
		frmClusteredImageRetrieval.getContentPane().add(colorPickerB1);

		System.out.println(colorPickerB1.getBackground());

		colorPickerB2 = new JButton("Pick Color 2");
		colorPickerB2.setBounds(850, 675, 105, 40);
		frmClusteredImageRetrieval.getContentPane().add(colorPickerB2);

		colorPickerB3 = new JButton("Pick Color 3");
		colorPickerB3.setBounds(975, 675, 105, 40);
		frmClusteredImageRetrieval.getContentPane().add(colorPickerB3);

		colorPickerB4 = new JButton("Pick Color 4");
		colorPickerB4.setBounds(1100, 675, 105, 40);
		frmClusteredImageRetrieval.getContentPane().add(colorPickerB4);

		colorPickerB5 = new JButton("Pick Color 5");
		colorPickerB5.setBounds(1225, 675, 105, 40);
		frmClusteredImageRetrieval.getContentPane().add(colorPickerB5);

		colorPickerB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorPickerB1.setBackground(colorPicker.getColor());
			}
		});
		
		startReset = new JButton("Start");
		startReset.setBounds(900, 720, 100, 50);
		frmClusteredImageRetrieval.getContentPane().add(startReset);
		startReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
	        {
	            randomizeImageToFind();
	            if(!started){
		            startTime=System.currentTimeMillis();
		            startReset.setText("Reset");
		            started = true;
	            }else{
	            	System.out.println("Reset after " + (System.currentTimeMillis()-startTime) + "ms");
	            	
	            	colorPickerB1.setBackground(UIManager.getColor( "Button.background" ));
	            	colorPickerB2.setBackground(UIManager.getColor( "Button.background" ));
	            	colorPickerB3.setBackground(UIManager.getColor( "Button.background" ));
	            	colorPickerB4.setBackground(UIManager.getColor( "Button.background" ));
	            	colorPickerB5.setBackground(UIManager.getColor( "Button.background" ));
					updateImageButtons(colorPickers);
	            	
	            	for (int i = 0; i < imagebuttons.length; i++) {
	            		   imagebuttons[i].setIcon(new ImageIcon(GuiInvoker.class
	            		     .getResource("not_available.png")));
	            	}
	            	for (int i = 0; i < pathBarButtons.length; i++) {
	            		   pathBarButtons[i].setIcon(new ImageIcon(GuiInvoker.class
	            		     .getResource("not_available.png")));
	            	}
	            	
	            	
//	            	int position = 0;
//	            	while (pathBar.size() > position + 1) {
//						pathBar.remove(pathBar.size() - 1);
//						pathBarImages.remove(pathBarImages.size() - 1);
//					}
//					List<Integer> clusterCentroids = new ArrayList<Integer>();
//					for (Collection<Integer> cluster : clusters.asMap().values()) {
//						clusterCentroids.add(ClusteringUtils
//								.findClusterRepresentation(imageReference
//										.getImageSummaries(cluster)));
//					}
//					
//					updateImageButtons(clusters, clusterCentroids);
					
	            	startTime = System.currentTimeMillis();
	            }
	        }
		});

		JLabel arrow1 = new JLabel("next");
		arrow1.setIcon(new ImageIcon(GuiInvoker.class.getResource("arrow.png")));
		arrow1.setPreferredSize(new Dimension(32, 31));
		arrow1.setIconTextGap(10);
		arrow1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		arrow1.setBorder(null);
		arrow1.setAlignmentY(0.0f);
		arrow1.setBounds(148, 24, 32, 31);
		frmClusteredImageRetrieval.getContentPane().add(arrow1);

		JLabel arrow2 = new JLabel("next");
		arrow2.setIcon(new ImageIcon(GuiInvoker.class.getResource("arrow.png")));
		arrow2.setPreferredSize(new Dimension(32, 31));
		arrow2.setIconTextGap(10);
		arrow2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		arrow2.setBorder(null);
		arrow2.setAlignmentY(0.0f);
		arrow2.setBounds(285, 24, 32, 31);
		frmClusteredImageRetrieval.getContentPane().add(arrow2);

		JLabel arrow3 = new JLabel("next");
		arrow3.setIcon(new ImageIcon(GuiInvoker.class.getResource("arrow.png")));
		arrow3.setPreferredSize(new Dimension(32, 31));
		arrow3.setIconTextGap(10);
		arrow3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		arrow3.setBorder(null);
		arrow3.setAlignmentY(0.0f);
		arrow3.setBounds(414, 24, 32, 31);
		frmClusteredImageRetrieval.getContentPane().add(arrow3);

		JLabel arrow4 = new JLabel("next");
		arrow4.setIcon(new ImageIcon(GuiInvoker.class.getResource("arrow.png")));
		arrow4.setPreferredSize(new Dimension(32, 31));
		arrow4.setIconTextGap(10);
		arrow4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		arrow4.setBorder(null);
		arrow4.setAlignmentY(0.0f);
		arrow4.setBounds(547, 24, 32, 31);
		frmClusteredImageRetrieval.getContentPane().add(arrow4);

		JButton cluster1_image = new JButton("");
		cluster1_image.setBounds(70, 6, 66, 66);
		cluster1_image
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster1_image.setAlignmentY(Component.TOP_ALIGNMENT);
		cluster1_image.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("active_cluster.png")));
		cluster1_image.setIconTextGap(10);
		cluster1_image.setPreferredSize(new Dimension(60, 60));
		cluster1_image.setBorder(new LineBorder(new Color(0, 0, 0)));
		cluster1_image.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(cluster1_image);

		JButton cluster2_image = new JButton("");
		cluster2_image.setPreferredSize(new Dimension(60, 60));
		cluster2_image.setIconTextGap(10);
		cluster2_image.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("active_cluster.png")));
		cluster2_image
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster2_image.setBorder(new LineBorder(Color.BLACK));
		cluster2_image.setAlignmentY(0.0f);
		cluster2_image.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cluster2_image.setBounds(199, 6, 66, 66);
		frmClusteredImageRetrieval.getContentPane().add(cluster2_image);

		JButton cluster3_image = new JButton("");
		cluster3_image.setPreferredSize(new Dimension(60, 60));
		cluster3_image.setIconTextGap(10);
		cluster3_image.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("active_cluster.png")));
		cluster3_image
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster3_image.setBorder(new LineBorder(Color.BLACK));
		cluster3_image.setAlignmentY(0.0f);
		cluster3_image.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cluster3_image.setBounds(329, 6, 66, 66);
		frmClusteredImageRetrieval.getContentPane().add(cluster3_image);

		JButton cluster4_image = new JButton("");
		cluster4_image.setPreferredSize(new Dimension(60, 60));
		cluster4_image.setIconTextGap(10);
		cluster4_image.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("active_cluster.png")));
		cluster4_image
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster4_image.setBorder(new LineBorder(Color.BLACK));
		cluster4_image.setAlignmentY(0.0f);
		cluster4_image.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cluster4_image.setBounds(458, 6, 66, 66);
		frmClusteredImageRetrieval.getContentPane().add(cluster4_image);

		JButton cluster5_image = new JButton("");
		cluster5_image.setPreferredSize(new Dimension(60, 60));
		cluster5_image.setIconTextGap(10);
		cluster5_image.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("active_cluster.png")));
		cluster5_image
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cluster5_image.setBorder(new LineBorder(Color.BLACK));
		cluster5_image.setAlignmentY(0.0f);
		cluster5_image.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cluster5_image.setBounds(591, 6, 66, 66);
		frmClusteredImageRetrieval.getContentPane().add(cluster5_image);

		JButton image_1 = new JButton("");
		image_1.setBounds(24, 110, 150, 150);
		image_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_1.setAlignmentY(Component.TOP_ALIGNMENT);

		image_1.setIconTextGap(10);
		image_1.setPreferredSize(new Dimension(150, 150));
		image_1.setBorder(null);
		image_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_1);

		JButton image_2 = new JButton("");
		image_2.setBounds(199, 110, 150, 150);

		image_2.setPreferredSize(new Dimension(150, 150));
		image_2.setIconTextGap(10);
		image_2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_2.setBorder(null);
		image_2.setAlignmentY(0.0f);
		image_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_2);

		JButton image_3 = new JButton("");

		image_3.setPreferredSize(new Dimension(150, 150));
		image_3.setIconTextGap(10);
		image_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_3.setBorder(null);
		image_3.setAlignmentY(0.0f);
		image_3.setBounds(374, 110, 150, 150);
		image_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_3);

		JButton image_4 = new JButton("");
		image_4.setPreferredSize(new Dimension(150, 150));
		image_4.setIconTextGap(10);
		image_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_4.setBorder(null);
		image_4.setAlignmentY(0.0f);
		image_4.setBounds(549, 110, 150, 150);
		image_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_4);

		JButton image_5 = new JButton("");

		image_5.setPreferredSize(new Dimension(150, 150));
		image_5.setIconTextGap(10);
		image_5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_5.setBorder(null);
		image_5.setAlignmentY(0.0f);
		image_5.setBounds(24, 284, 150, 150);
		image_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_5);

		JButton image_6 = new JButton("");
		image_6.setPreferredSize(new Dimension(150, 150));
		image_6.setIconTextGap(10);
		image_6.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_6.setBorder(null);
		image_6.setAlignmentY(0.0f);
		image_6.setBounds(199, 284, 150, 150);
		image_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_6);

		JButton image_7 = new JButton("");
		image_7.setPreferredSize(new Dimension(150, 150));
		image_7.setIconTextGap(10);
		image_7.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_7.setBorder(null);
		image_7.setAlignmentY(0.0f);
		image_7.setBounds(374, 284, 150, 150);
		image_7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_7);

		JButton image_8 = new JButton("");
		image_8.setPreferredSize(new Dimension(150, 150));
		image_8.setIconTextGap(10);
		image_8.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_8.setBorder(null);
		image_8.setAlignmentY(0.0f);
		image_8.setBounds(549, 284, 150, 150);
		image_8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_8);

		JButton image_9 = new JButton("");
		image_9.setPreferredSize(new Dimension(150, 150));
		image_9.setIconTextGap(10);
		image_9.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_9.setBorder(null);
		image_9.setAlignmentY(0.0f);
		image_9.setBounds(24, 458, 150, 150);
		image_9.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_9);

		JButton image_10 = new JButton("");
		image_10.setPreferredSize(new Dimension(150, 150));
		image_10.setIconTextGap(10);
		image_10.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_10.setBorder(null);
		image_10.setAlignmentY(0.0f);
		image_10.setBounds(199, 458, 150, 150);
		image_10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_10);

		JButton image_11 = new JButton("");
		image_11.setPreferredSize(new Dimension(150, 150));
		image_11.setIconTextGap(10);
		image_11.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_11.setBorder(null);
		image_11.setAlignmentY(0.0f);
		image_11.setBounds(374, 458, 150, 150);
		image_11.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_11);

		JButton image_12 = new JButton("");
		image_12.setPreferredSize(new Dimension(150, 150));
		image_12.setIconTextGap(10);
		image_12.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_12.setBorder(null);
		image_12.setAlignmentY(0.0f);
		image_12.setBounds(549, 458, 150, 150);
		image_12.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_12);

		JButton image_13 = new JButton("");
		image_13.setPreferredSize(new Dimension(150, 150));
		image_13.setIconTextGap(10);
		image_13.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_13.setBorder(null);
		image_13.setAlignmentY(0.0f);
		image_13.setBounds(24, 632, 150, 150);
		image_13.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_13);

		JButton image_14 = new JButton("");
		image_14.setPreferredSize(new Dimension(150, 150));
		image_14.setIconTextGap(10);
		image_14.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_14.setBorder(null);
		image_14.setAlignmentY(0.0f);
		image_14.setBounds(199, 632, 150, 150);
		image_14.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_14);

		JButton image_15 = new JButton("");
		image_15.setPreferredSize(new Dimension(150, 150));
		image_15.setIconTextGap(10);
		image_15.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_15.setBorder(null);
		image_15.setAlignmentY(0.0f);
		image_15.setBounds(374, 632, 150, 150);
		image_15.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_15);

		JButton image_16 = new JButton("");
		image_16.setPreferredSize(new Dimension(150, 150));
		image_16.setIconTextGap(10);
		image_16.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		image_16.setBorder(null);
		image_16.setAlignmentY(0.0f);
		image_16.setBounds(549, 632, 150, 150);
		image_16.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmClusteredImageRetrieval.getContentPane().add(image_16);

		imagebuttons = new JButton[]{ image_1, image_2, image_3, image_4,
				image_5, image_6, image_7, image_8, image_9, image_10,
				image_11, image_12, image_13, image_14, image_15, image_16 };
		pathBarButtons =  new JButton[]{ cluster1_image, cluster2_image,
				cluster3_image, cluster4_image, cluster5_image };

		for (int i = 0; i < imagebuttons.length; i++) {
			imagebuttons[i].setIcon(new ImageIcon(GuiInvoker.class
					.getResource("not_available.png")));
		}
		for (int i = 0; i < pathBarButtons.length; i++) {
			pathBarButtons[i].setIcon(new ImageIcon(GuiInvoker.class
					.getResource("not_available.png")));
		}

		colorPickers = new JButton[]{ colorPickerB1, colorPickerB2,
				colorPickerB3, colorPickerB4, colorPickerB5 };

		colorPickerB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorPickerB1.setBackground(colorPicker.getColor());
				updateImageButtons(colorPickers);
			}
		});
		colorPickerB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorPickerB2.setBackground(colorPicker.getColor());
				updateImageButtons(colorPickers);
			}
		});
		colorPickerB3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorPickerB3.setBackground(colorPicker.getColor());
				updateImageButtons(colorPickers);
			}
		});
		colorPickerB4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorPickerB4.setBackground(colorPicker.getColor());
				updateImageButtons(colorPickers);
			}
		});
		colorPickerB5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorPickerB5.setBackground(colorPicker.getColor());
				updateImageButtons(colorPickers);
			}
		});

		search_image = new JLabel("search image");

		search_image.setPreferredSize(new Dimension(308, 309));
		search_image.setIconTextGap(10);
		search_image
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		search_image.setBorder(null);
		search_image.setAlignmentY(0.0f);
		search_image.setBounds(845, 42, 308, 309);
		frmClusteredImageRetrieval.getContentPane().add(search_image);

		//randomizeImageToFind();

		JLabel frame1 = new JLabel("frame1");
		frame1.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame1.setPreferredSize(new Dimension(170, 170));
		frame1.setIconTextGap(10);
		frame1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame1.setBorder(null);
		frame1.setAlignmentY(0.0f);
		frame1.setBounds(14, 100, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame1);

		JLabel frame2 = new JLabel("frame2");
		frame2.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame2.setPreferredSize(new Dimension(170, 170));
		frame2.setIconTextGap(10);
		frame2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame2.setBorder(null);
		frame2.setAlignmentY(0.0f);
		frame2.setBounds(189, 100, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame2);

		JLabel frame3 = new JLabel("frame3");
		frame3.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame3.setPreferredSize(new Dimension(170, 170));
		frame3.setIconTextGap(10);
		frame3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame3.setBorder(null);
		frame3.setAlignmentY(0.0f);
		frame3.setBounds(364, 100, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame3);

		JLabel frame4 = new JLabel("frame4");
		frame4.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame4.setPreferredSize(new Dimension(170, 170));
		frame4.setIconTextGap(10);
		frame4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame4.setBorder(null);
		frame4.setAlignmentY(0.0f);
		frame4.setBounds(539, 100, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame4);

		JLabel frame5 = new JLabel("frame5");
		frame5.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame5.setPreferredSize(new Dimension(170, 170));
		frame5.setIconTextGap(10);
		frame5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame5.setBorder(null);
		frame5.setAlignmentY(0.0f);
		frame5.setBounds(14, 274, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame5);

		JLabel frame6 = new JLabel("frame6");
		frame6.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame6.setPreferredSize(new Dimension(170, 170));
		frame6.setIconTextGap(10);
		frame6.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame6.setBorder(null);
		frame6.setAlignmentY(0.0f);
		frame6.setBounds(189, 274, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame6);

		JLabel frame7 = new JLabel("frame7");
		frame7.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame7.setPreferredSize(new Dimension(170, 170));
		frame7.setIconTextGap(10);
		frame7.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame7.setBorder(null);
		frame7.setAlignmentY(0.0f);
		frame7.setBounds(364, 274, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame7);

		JLabel frame8 = new JLabel("frame8");
		frame8.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame8.setPreferredSize(new Dimension(170, 170));
		frame8.setIconTextGap(10);
		frame8.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame8.setBorder(null);
		frame8.setAlignmentY(0.0f);
		frame8.setBounds(539, 274, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame8);

		JLabel frame9 = new JLabel("frame9");
		frame9.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame9.setPreferredSize(new Dimension(170, 170));
		frame9.setIconTextGap(10);
		frame9.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame9.setBorder(null);
		frame9.setAlignmentY(0.0f);
		frame9.setBounds(14, 448, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame9);

		JLabel frame10 = new JLabel("frame10");
		frame10.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame10.setPreferredSize(new Dimension(170, 170));
		frame10.setIconTextGap(10);
		frame10.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame10.setBorder(null);
		frame10.setAlignmentY(0.0f);
		frame10.setBounds(189, 448, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame10);

		JLabel frame11 = new JLabel("frame11");
		frame11.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame11.setPreferredSize(new Dimension(170, 170));
		frame11.setIconTextGap(10);
		frame11.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame11.setBorder(null);
		frame11.setAlignmentY(0.0f);
		frame11.setBounds(364, 448, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame11);

		JLabel frame12 = new JLabel("frame12");
		frame12.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame12.setPreferredSize(new Dimension(170, 170));
		frame12.setIconTextGap(10);
		frame12.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame12.setBorder(null);
		frame12.setAlignmentY(0.0f);
		frame12.setBounds(539, 448, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame12);

		JLabel frame13 = new JLabel("frame12");
		frame13.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame13.setPreferredSize(new Dimension(170, 170));
		frame13.setIconTextGap(10);
		frame13.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame13.setBorder(null);
		frame13.setAlignmentY(0.0f);
		frame13.setBounds(14, 622, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame13);

		JLabel frame14 = new JLabel("frame14");
		frame14.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame14.setPreferredSize(new Dimension(170, 170));
		frame14.setIconTextGap(10);
		frame14.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame14.setBorder(null);
		frame14.setAlignmentY(0.0f);
		frame14.setBounds(539, 622, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame14);

		JLabel frame15 = new JLabel("frame15");
		frame15.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame15.setPreferredSize(new Dimension(170, 170));
		frame15.setIconTextGap(10);
		frame15.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame15.setBorder(null);
		frame15.setAlignmentY(0.0f);
		frame15.setBounds(364, 622, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame15);

		JLabel frame16 = new JLabel("frame16");
		frame16.setIcon(new ImageIcon(GuiInvoker.class.getResource("frame.png")));
		frame16.setPreferredSize(new Dimension(170, 170));
		frame16.setIconTextGap(10);
		frame16.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame16.setBorder(null);
		frame16.setAlignmentY(0.0f);
		frame16.setBounds(189, 622, 170, 170);
		frmClusteredImageRetrieval.getContentPane().add(frame16);

		JLabel background = new JLabel("16");
		background.setIcon(new ImageIcon(GuiInvoker.class
				.getResource("gui.png")));
		background.setPreferredSize(new Dimension(1280, 800));
		background.setIconTextGap(10);
		background.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		background.setBorder(null);
		background.setAlignmentY(0.0f);
		background.setBounds(0, 0, 1280, 800);
		frmClusteredImageRetrieval.getContentPane().add(background);

		// background.addMouseListener(handler);
		// background.addMouseMotionListener(handler);

		frmClusteredImageRetrieval.setUndecorated(true);

		frmClusteredImageRetrieval.setBounds(0, 0, 1280, 800);
		frmClusteredImageRetrieval
				.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GraphicsDevice device = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getScreenDevices()[0];
		device.setFullScreenWindow(frmClusteredImageRetrieval);

		addComponentsToPane(frmClusteredImageRetrieval.getContentPane());

		frmClusteredImageRetrieval.setResizable(false);

		frmClusteredImageRetrieval.setVisible(true);
	}

	private void randomizeImageToFind() {
		List<Integer> allImages = imageReference.getListOfAllImages();
		imageToFind = allImages.get((int) (Math.random() * allImages.size()));
		search_image.setIcon(new ImageIcon(new ImageIcon(new File(IMG_DIR, "im"
				+ (imageToFind + 1) + ".jpg").getAbsolutePath()).getImage()
				.getScaledInstance(309, 309, java.awt.Image.SCALE_SMOOTH)));
	}

	private JLabel search_image;

	private void updateImageButtons(final JButton[] colorPickers) {
		class ImageButtonHandlerclass implements MouseListener {

			public void mouseClicked(MouseEvent event) {

			}

			public void mousePressed(MouseEvent event) {
				// Ignore.
			}

			public void mouseReleased(MouseEvent event) {
				// Ignore.
			}

			public void mouseEntered(MouseEvent event) {
				// Ignore.
			}

			public void mouseExited(MouseEvent event) {
				// Ignore.
			}
		}

		List<Color> colors = new ArrayList<Color>();
		Color[] allColors = new Color[colorPickers.length];
		for (int i = 0; i < colorPickers.length; i++) {
			if (!colorPickers[i].getBackground().equals(
					new Color(238, 238, 238))) {
				colors.add(colorPickers[i].getBackground());
			}
			allColors[i] = colorPickers[i].getBackground();
		}
		List<Integer> sortedImages = SearchUtils.searchByColor(imageReference,
				colors.toArray(new Color[0]));
		pathBar.add(allColors);
		pathBarImages.add(sortedImages.get(0));

		for (int i = 0; i < imagebuttons.length; i++) {
			for (MouseListener mouseListener : imagebuttons[i]
					.getMouseListeners()) {
				imagebuttons[i].removeMouseListener(mouseListener);
			}
			if (sortedImages.size() > i) {
				imagebuttons[i].setIcon(new ImageIcon(new ImageIcon(new File(
						IMG_DIR, "im" + (sortedImages.get(i) + 1) + ".jpg")
						.getAbsolutePath()).getImage().getScaledInstance(150,
						150, java.awt.Image.SCALE_SMOOTH)));
				if (sortedImages.size() > 1) {
					ImageButtonHandlerclass handler1 = new ImageButtonHandlerclass();
					imagebuttons[i].addMouseListener(handler1);
				}
			} else {
				imagebuttons[i].setIcon(new ImageIcon(GuiInvoker.class
						.getResource("not_available.png")));
			}
		}

		class PathBarButtonHandlerclass implements MouseListener {
			private int position;
			Color[] colors;

			public void mouseClicked(MouseEvent event) {
				while (pathBar.size() > position) {
					pathBar.remove(pathBar.size() - 1);
					pathBarImages.remove(pathBarImages.size() - 1);
				}
				for (int i = 0; i < colorPickers.length; i++) {
					colorPickers[i].setBackground(colors[i]);
				}

				updateImageButtons(colorPickers);
			}

			public void mousePressed(MouseEvent event) {
				// Ignore.
			}

			public void mouseReleased(MouseEvent event) {
				// Ignore.
			}

			public void mouseEntered(MouseEvent event) {
				// Ignore.
			}

			public void mouseExited(MouseEvent event) {
				// Ignore.
			}
		}

		for (int i = 0; i < pathBarButtons.length; i++) {
			for (MouseListener mouseListener : pathBarButtons[i]
					.getMouseListeners()) {
				pathBarButtons[i].removeMouseListener(mouseListener);
			}
			if (pathBarImages.size() > i) {
				pathBarButtons[i].setIcon(new ImageIcon(new ImageIcon(new File(
						IMG_DIR, "im" + (pathBarImages.get(i) + 1) + ".jpg")
						.getAbsolutePath()).getImage().getScaledInstance(64,
						64, java.awt.Image.SCALE_SMOOTH)));
				PathBarButtonHandlerclass handler1 = new PathBarButtonHandlerclass();
				handler1.position = i;
				handler1.colors = pathBar.get(i);
				pathBarButtons[i].addMouseListener(handler1);
			} else {
				pathBarButtons[i].setIcon(new ImageIcon(GuiInvoker.class
						.getResource("not_available.png")));
			}
		}
	}

	private void addComponentsToPane(Container contentPane) {
		// TODO Auto-generated method stub

	}

}

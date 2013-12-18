package ir_project.gui.components;

import ir_project.io.ImageSummaryReference;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SimpleImageListFrame extends JFrame {
	private static final long serialVersionUID = -7105805264316107128L;

	public SimpleImageListFrame(Integer... imageIds) {
		super("Image Distances List");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		for (int i = 0; i < Math.min(25, imageIds.length); i++) {
			int imageId = imageIds[i] + 1;
			ImageIcon icon = new ImageIcon(new File(
					ImageSummaryReference.THUMBNAIL_IMAGE_DIRECTORY, "im"
							+ imageId + ".jpg").getAbsolutePath());
			String text = ""
					+ imageId;
			JLabel label = new JLabel(text, icon, SwingConstants.LEFT);
			panel.add(label);
			System.out.println(text);
		}
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}

package ir_project.invoker;

import ir_project.io.ImageSummaryExtractor;
import ir_project.model.ImageSummary;

import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ListDistancesInvoker {
	private static final int NUMBER_OF_IMAGES_TO_LOAD = 10000;
	public final static File THUMBNAIL_IMAGE_DIRECTORY = new File("/home/stefan/Downloads/image_thumbnails/");
	public final static int REFERENCE_IMAGE_ID = 645;

	public static void main(String[] args) throws IOException {
		System.out.println("Loading...");
		ImageSummary[] imageSummaries = loadImageSummaries();

		System.out.println("Calculating distances...");
		ImageSummary referenceImage = imageSummaries[REFERENCE_IMAGE_ID - 1];
		Integer[] imageIds = new Integer[imageSummaries.length];
		final double[] distances = new double[imageSummaries.length];
		for (int i = 0; i < imageIds.length; i++) {
			imageIds[i] = i;
			distances[i] = referenceImage.distanceTo(imageSummaries[i]);
		}

		System.out.println("Sorting...");
		Arrays.sort(imageIds, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Double.compare(distances[o1], distances[o2]);
			}
		});

		System.out.println("Showing...");
		JFrame frame = new JFrame("Image Distances List");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		for (int i = 0; i < 25; i++) {
			int imageId = imageIds[i] + 1;
			ImageIcon icon = new ImageIcon(new File(THUMBNAIL_IMAGE_DIRECTORY, "im" + imageId + ".jpg").getAbsolutePath());
			String text = "" + imageId + " " + referenceImage.distanceTo(imageSummaries[imageId - 1]);
			JLabel label = new JLabel(text, icon, SwingConstants.LEFT);
			panel.add(label);
			System.out.println(text);
		}
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private static ImageSummary[] loadImageSummaries() throws IOException {
		ImageSummary[] imageSummaries = new ImageSummary[NUMBER_OF_IMAGES_TO_LOAD];
		for (int i = 1; i <= imageSummaries.length; i++) {
			File imageFile = new File(THUMBNAIL_IMAGE_DIRECTORY, "im" + i + ".jpg");
			imageSummaries[i - 1] = ImageSummaryExtractor.extractImageSummary(imageFile);
		}
		return imageSummaries;
	}
}

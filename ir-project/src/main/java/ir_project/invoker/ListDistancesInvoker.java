package ir_project.invoker;

import ir_project.gui.components.SimpleImageListFrame;
import ir_project.io.ImageSummaryReference;
import ir_project.model.ImageSummary;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class ListDistancesInvoker {
	private final static int REFERENCE_IMAGE_ID = 645;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("Loading...");
		ImageSummaryReference imageReference = ImageSummaryReference.loadImageSummary();

		ImageSummary referenceImage = imageReference.getImageSummary(REFERENCE_IMAGE_ID - 1);

		showMatchesForReference(imageReference, referenceImage);
	}

	public static void showMatchesForReference(ImageSummaryReference imageReference, ImageSummary referenceImage) {
		System.out.println("Calculating distances...");
		Integer[] imageIds = new Integer[imageReference.size()];
		final double[] distances = new double[imageReference.size()];
		for (int i = 0; i < imageIds.length; i++) {
			imageIds[i] = i;
			distances[i] = referenceImage.distanceTo(imageReference.getImageSummary(i));
		}

		System.out.println("Sorting...");
		Arrays.sort(imageIds, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Double.compare(distances[o1], distances[o2]);
			}
		});

		System.out.println("Showing...");
		new SimpleImageListFrame(imageIds);
	}
}

package ir_project.clustering;

import ir_project.io.ImageSummaryExtractor;
import ir_project.io.ImageSummaryReference;
import ir_project.model.ImageSummary;

import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchUtils {
	public static List<Integer> searchByColor(
			ImageSummaryReference imageReference, Color... colors) {
		ImageSummary referenceImage = ImageSummaryExtractor
				.createImageSummaryFromColor(colors);

		List<Integer> images = imageReference.getListOfAllImages();
		final Map<Integer, Double> distancePerImage = new HashMap<Integer, Double>();
		for (int image : images) {
			double distance = referenceImage.distanceTo(imageReference
					.getImageSummary(image));
			distancePerImage.put(image, distance);
		}

		Collections.sort(images, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Double.compare(distancePerImage.get(o1),
						distancePerImage.get(o2));
			}
		});
		return images;

	}
}

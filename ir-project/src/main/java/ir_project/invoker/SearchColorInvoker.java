package ir_project.invoker;

import ir_project.io.ImageSummaryExtractor;
import ir_project.io.ImageSummaryReference;
import ir_project.model.ImageSummary;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SearchColorInvoker {
	private static Color[] COLOR_REFERENCE = { Color.BLUE, Color.ORANGE };

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		System.out.println("Loading...");
		ImageSummaryReference imageReference = ImageSummaryReference
				.loadImageSummary();

		ImageSummary referenceImage = ImageSummaryExtractor
				.createImageSummaryFromColor(COLOR_REFERENCE);

		ListDistancesInvoker.showMatchesForReference(imageReference,
				referenceImage);
	}
}

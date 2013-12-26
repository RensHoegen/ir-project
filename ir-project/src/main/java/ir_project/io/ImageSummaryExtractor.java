package ir_project.io;

import ir_project.model.ImageSummary;
import ir_project.model.ImageSummary.ImageAreaSummary;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageSummaryExtractor {
	private static final int NUMBER_OF_AREAS = 1;
	private static final Color[] COLORS = createReferenceColors();

	public static ImageSummary extractImageSummary(InputStream imageStream) throws IOException {
		BufferedImage image = ImageIO.read(imageStream);
		return extractImageSummaryInternal(image);
	}

	public static ImageSummary createImageSummaryFromColor(Color... colors) {
		double[] histogram = new double[COLORS.length];
		for (Color color : colors) {
			addPixelToHistogram(histogram, color);
		}

		normalizeHistogram(histogram);
		return new ImageSummary(new ImageAreaSummary[] { new ImageAreaSummary(histogram) });
	}

	private static Color[] createReferenceColors() {
		List<Color> colors = new ArrayList<Color>();

		colors.add(Color.BLACK);
		colors.add(Color.WHITE);
		colors.add(Color.GRAY);
		for (float h = 0; h < 1.0f; h += 0.05f) {
			for (float b : new float[] { 0.50f, 0.85f }) {
				colors.add(Color.getHSBColor(h, 0.75f, b));
			}
		}
		return colors.toArray(new Color[0]);
	}

	public static ImageSummary extractImageSummary(File imageFile) throws IOException {
		BufferedImage image = ImageIO.read(imageFile);
		return extractImageSummaryInternal(image);
	}

	private static ImageSummary extractImageSummaryInternal(BufferedImage image) {
		ImageAreaSummary[] areaSummaries = new ImageAreaSummary[NUMBER_OF_AREAS * NUMBER_OF_AREAS];
		for (int x = 0; x < NUMBER_OF_AREAS; x++) {
			for (int y = 0; y < NUMBER_OF_AREAS; y++) {
				areaSummaries[x + y * NUMBER_OF_AREAS] = extractImageAreaSummary(image, x, y);
			}
		}
		return new ImageSummary(areaSummaries);
	}

	private static ImageAreaSummary extractImageAreaSummary(BufferedImage image, int areaX, int areaY) {
		int xStart = image.getWidth() * areaX / NUMBER_OF_AREAS;
		int xEnd = image.getWidth() * (areaX + 1) / NUMBER_OF_AREAS;
		int yStart = image.getHeight() * areaY / NUMBER_OF_AREAS;
		int yEnd = image.getHeight() * (areaY + 1) / NUMBER_OF_AREAS;

		double[] histogram = new double[COLORS.length];
		for (int x = xStart; x < xEnd; x++) {
			for (int y = yStart; y < yEnd; y++) {
				Color pixelColor = new Color(image.getRGB(x, y));
				addPixelToHistogram(histogram, pixelColor);
			}
		}

		normalizeHistogram(histogram);

		return new ImageAreaSummary(histogram);
	}

	private static void normalizeHistogram(double[] histogram) {
		double histogramSum = 0.0d;
		for (int i = 0; i < histogram.length; i++) {
			histogramSum += histogram[i];
		}
		for (int i = 0; i < histogram.length; i++) {
			histogram[i] /= histogramSum;
		}
	}

	private static void addPixelToHistogram(double[] histogram, Color pixelColor) {
		double[] weightPerColor = new double[COLORS.length];
		double weightSum = 0.0d;
		for (int i = 0; i < COLORS.length; i++) {
			double distance = calculateDistanceBetweenColors(COLORS[i], pixelColor);
			double weight = 1 / distance / distance;
			weightPerColor[i] = weight;
			weightSum += weight;
		}
		for (int i = 0; i < COLORS.length; i++) {
			histogram[i] += weightPerColor[i] / weightSum;
		}
	}

	private static double calculateDistanceBetweenColors(Color colorA, Color colorB) {
		int redDiff = colorA.getRed() - colorB.getRed();
		int greenDiff = colorA.getGreen() - colorB.getGreen();
		int blueDiff = colorA.getBlue() - colorB.getBlue();
		return Math.sqrt(redDiff * redDiff + greenDiff * greenDiff + blueDiff * blueDiff);
	}
}

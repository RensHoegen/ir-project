package ir_project.io;

import ir_project.model.ImageSummary;
import ir_project.model.ImageSummary.ImageAreaSummary;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageSummaryExtractor {
	private static final int NUMBER_OF_AREAS = 2;
	private static final Color[] COLORS = createColors();

	public static ImageSummary extractImageSummary(InputStream imageStream) throws IOException {
		BufferedImage image = ImageIO.read(imageStream);
		return extractImageSummaryInternal(image);
	}

	private static Color[] createColors() {
		Color[] colors = new Color[4 * 4 * 4];
		int index = 0;
		for (int r = 0; r < 4; r++) {
			for (int g = 0; g < 4; g++) {
				for (int b = 0; b < 4; b++) {
					colors[index] = new Color(r * 64 + 32, g * 64 + 32, b * 64 + 32);
					index++;
				}
			}
		}
		return colors;
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

		double histogramSum = 0.0d;
		for (int i = 0; i < histogram.length; i++) {
			histogramSum += histogram[i];
		}
		for (int i = 0; i < histogram.length; i++) {
			histogram[i] /= histogramSum;
		}

		return new ImageAreaSummary(histogram);
	}

	private static void addPixelToHistogram(double[] histogram, Color pixelColor) {
		for (int i = 0; i < COLORS.length; i++) {
			double dist = calculateDistanceBetweenColors(COLORS[i], pixelColor);
			histogram[i] += 1 / dist;
		}
	}

	private static double calculateDistanceBetweenColors(Color colorA, Color colorB) {
		int redDiff = colorA.getRed() - colorB.getRed();
		int greenDiff = colorA.getGreen() - colorB.getGreen();
		int blueDiff = colorA.getBlue() - colorB.getBlue();
		return Math.sqrt(redDiff * redDiff + greenDiff * greenDiff + blueDiff * blueDiff);
	}
}

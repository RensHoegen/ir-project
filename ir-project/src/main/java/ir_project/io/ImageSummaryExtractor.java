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
	private static final int BLUR_RADIUS = 10;
	private static final int NUMBER_OF_AREAS = 2;

	public static ImageSummary extractImageSummary(InputStream imageStream) throws IOException {
		BufferedImage image = ImageIO.read(imageStream);
		return extractImageSummaryInternal(image);
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

		double[] redHistogram = new double[256];
		double[] greenHistogram = new double[256];
		double[] blueHistogram = new double[256];
		int pixelCount = 0;
		for (int x = xStart; x < xEnd; x++) {
			for (int y = yStart; y < yEnd; y++) {
				Color pixelColor = new Color(image.getRGB(x, y));
				redHistogram[pixelColor.getRed()] += 1.0d;
				greenHistogram[pixelColor.getGreen()] += 1.0d;
				blueHistogram[pixelColor.getBlue()] += 1.0d;
				pixelCount++;
			}
		}
		for (int i = 0; i < 256; i++) {
			redHistogram[i] /= pixelCount;
			greenHistogram[i] /= pixelCount;
			blueHistogram[i] /= pixelCount;
		}
		return new ImageAreaSummary(applyBlur(redHistogram), applyBlur(greenHistogram), applyBlur(blueHistogram));
	}

	private static double[] applyBlur(double[] originalHistogram) {
		double[] histogram = new double[256];

		for (int i = 0; i < 255; i++) {
			double count = 0;
			for (int j = Math.max(0, i - BLUR_RADIUS); j < Math.min(i + BLUR_RADIUS, 255); j++) {
				double multiplier = 1 - Math.pow(i - j, 2) * 1.0d / Math.pow(BLUR_RADIUS + 1, 2);
				histogram[i] += multiplier * originalHistogram[j];
				count += multiplier;
			}
			histogram[i] /= count;
		}

		return histogram;
	}
}

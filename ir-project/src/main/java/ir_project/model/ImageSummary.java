package ir_project.model;

import java.io.Serializable;

public class ImageSummary implements Serializable {
	private static final long serialVersionUID = -2210229095092885503L;

	public static class ImageAreaSummary implements Serializable {
		private static final long serialVersionUID = 5182663713484143083L;
		private final double[] redHistogram, greenHistogram, blueHistogram;

		public ImageAreaSummary(double[] redHistogram, double[] greenHistogram, double[] blueHistogram) {
			super();
			this.redHistogram = redHistogram;
			this.greenHistogram = greenHistogram;
			this.blueHistogram = blueHistogram;
		}

		public double[] getRedHistogram() {
			return redHistogram;
		}

		public double[] getGreenHistogram() {
			return greenHistogram;
		}

		public double[] getBlueHistogram() {
			return blueHistogram;
		}

		public double distanceTo(ImageAreaSummary other) {
			double redDistance = calculateChiSquaredHistogramDistance(redHistogram, other.redHistogram);
			double greenDistance = calculateChiSquaredHistogramDistance(greenHistogram, other.greenHistogram);
			double blueDistance = calculateChiSquaredHistogramDistance(blueHistogram, other.blueHistogram);
			return redDistance * redDistance + greenDistance * greenDistance + blueDistance * blueDistance;
		}

		public static double calculateChiSquaredHistogramDistance(double[] arrayA, double[] arrayB) {
			double distanceSum = 0.0d;
			for (int i = 0; i < arrayA.length; i++) {
				distanceSum += Math.pow(arrayA[i] - arrayB[i], 2) / (arrayA[i] + arrayB[i] + 1.0e-9);
			}
			return distanceSum;
		}
	}

	private final ImageAreaSummary[] areaSummaries;

	public ImageSummary(ImageAreaSummary[] areaSummaries) {
		super();
		this.areaSummaries = areaSummaries;
	}

	public ImageAreaSummary[] getAreaSummaries() {
		return areaSummaries;
	}

	public double distanceTo(ImageSummary other) {
		double distanceSum = 0.0d;
		for (int i = 0; i < areaSummaries.length; i++) {
			double distance = areaSummaries[i].distanceTo(other.areaSummaries[i]);
			distanceSum += distance * distance;
		}
		return distanceSum;
	}
}

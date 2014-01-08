package ir_project.model;

import java.io.Serializable;
import java.util.Collection;

public class ImageSummary implements Serializable {
	private static final long serialVersionUID = -2210229095092885503L;

	public static class ImageAreaSummary implements Serializable {
		private static final long serialVersionUID = 5182663713484143083L;
		private final double[] histogram;

		public ImageAreaSummary(double[] histogram) {
			super();
			this.histogram = histogram;
		}

		public double distanceTo(ImageAreaSummary other) {
			double distanceSum = 0.0d;
			for (int i = 0; i < 8; i++) {
				distanceSum += Math.pow(histogram[i] - other.histogram[i], 2);
				// / (histogram[i] + other.histogram[i] + 1.0e-16);
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
			double distance = areaSummaries[i]
					.distanceTo(other.areaSummaries[i]);
			distanceSum += distance * distance;
		}
		return distanceSum;
	}

	public static ImageSummary calculateAverageSummary(
			Collection<ImageSummary> collection) {
		ImageSummary first = collection.iterator().next();
		double[][] averageHistograms = new double[first.areaSummaries.length][];
		for (int i = 0; i < averageHistograms.length; i++) {
			averageHistograms[i] = new double[first.areaSummaries[i].histogram.length];
		}
		for (ImageSummary summary : collection) {
			for (int i = 0; i < averageHistograms.length; i++) {
				for (int j = 0; j < averageHistograms[i].length; j++) {
					averageHistograms[i][j] += summary.areaSummaries[i].histogram[j]
							/ collection.size();
				}
			}
		}
		ImageAreaSummary[] areaSummaries = new ImageAreaSummary[averageHistograms.length];
		for (int i = 0; i < areaSummaries.length; i++) {
			areaSummaries[i] = new ImageAreaSummary(averageHistograms[i]);
		}
		return new ImageSummary(areaSummaries);
	}
}

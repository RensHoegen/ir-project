package ir_project.clustering;

import ir_project.model.ImageSummary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class ClusteringUtils {
	private static final int NUMBER_OF_CLUSTERS = 16;

	public static Multimap<Integer, Integer> createClusters(
			Map<Integer, ImageSummary> entries) {
		ImageSummary[] centroids = calculateClusterCentroids(entries);

		Map<Integer, Integer> clusterIdsForEntries = new HashMap<Integer, Integer>();
		findClosestCentroids(entries, centroids, clusterIdsForEntries);

		Multimap<Integer, Integer> idsPerCluster = ArrayListMultimap.create(
				centroids.length, entries.size() / centroids.length);
		for (Entry<Integer, ImageSummary> entry : entries.entrySet()) {
			idsPerCluster.put(clusterIdsForEntries.get(entry.getKey()),
					entry.getKey());
		}
		return idsPerCluster;
	}

	public static int findClusterRepresentation(
			Map<Integer, ImageSummary> imagesInCluster) {

		ImageSummary averageSummary = ImageSummary
				.calculateAverageSummary(imagesInCluster.values());
		double bestDistance = Double.POSITIVE_INFINITY;
		int bestImage = -1;
		for (Entry<Integer, ImageSummary> entry : imagesInCluster.entrySet()) {
			double distance = entry.getValue().distanceTo(averageSummary);
			if (distance < bestDistance) {
				bestDistance = distance;
				bestImage = entry.getKey();
			}
		}
		return bestImage;
	}

	private static ImageSummary[] calculateClusterCentroids(
			Map<Integer, ImageSummary> entries) {
		ImageSummary[] centroids = createInitialCentroids(entries);

		Map<Integer, Integer> clusterIdsForEntries = new HashMap<Integer, Integer>();
		findClosestCentroids(entries, centroids, clusterIdsForEntries);
		boolean hasUpdated = true;

		while (hasUpdated) {
			Multimap<Integer, ImageSummary> summariesPerCluster = ArrayListMultimap
					.create(centroids.length, entries.size() / centroids.length);
			for (Entry<Integer, ImageSummary> entry : entries.entrySet()) {
				summariesPerCluster.put(
						clusterIdsForEntries.get(entry.getKey()),
						entry.getValue());
			}

			for (int i = 0; i < centroids.length; i++) {
				centroids[i] = ImageSummary
						.calculateAverageSummary(summariesPerCluster.get(i));
			}

			hasUpdated = findClosestCentroids(entries, centroids,
					clusterIdsForEntries);
		}

		return centroids;
	}

	private static ImageSummary[] createInitialCentroids(
			Map<Integer, ImageSummary> entries) {
		ImageSummary[] centroids = new ImageSummary[Math.min(entries.size(),
				NUMBER_OF_CLUSTERS)];
		List<Integer> entryKeys = new ArrayList<Integer>(entries.keySet());
		for (int i = 0; i < centroids.length; i++) {
			int randomIndex = (int) (Math.random() * entryKeys.size());
			centroids[i] = entries.get(entryKeys.get(randomIndex));
			entryKeys.set(randomIndex, entryKeys.get(entryKeys.size() - 1));
			entryKeys.remove(entryKeys.size() - 1);
		}
		return centroids;
	}

	private static boolean findClosestCentroids(
			Map<Integer, ImageSummary> entries, ImageSummary[] centroids,
			Map<Integer, Integer> clusterIdsForEntries) {
		boolean hasUpdated = false;
		for (Entry<Integer, ImageSummary> entry : entries.entrySet()) {
			Integer closestCentroid = -1;
			double distanceToClosestCentroid = Double.POSITIVE_INFINITY;
			for (int i = 0; i < centroids.length; i++) {
				double distance = centroids[i].distanceTo(entry.getValue());
				if (distance < distanceToClosestCentroid) {
					closestCentroid = i;
					distanceToClosestCentroid = distance;
				}
			}
			if (!closestCentroid
					.equals(clusterIdsForEntries.get(entry.getKey()))) {
				clusterIdsForEntries.put(entry.getKey(), closestCentroid);
				hasUpdated = true;
			}
		}
		return hasUpdated;
	}
}

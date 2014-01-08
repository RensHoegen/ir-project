package ir_project.invoker;

import ir_project.clustering.ClusteringUtils;
import ir_project.gui.components.SimpleImageListFrame;
import ir_project.io.ImageSummaryReference;
import ir_project.model.ImageSummary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Multimap;

public class ShowRecursiveCentroidsInvoker {
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		System.out.println("Loading...");
		ImageSummaryReference imageReference = ImageSummaryReference
				.loadImageSummary();
		Map<Integer, ImageSummary> imageReferenceMap = new HashMap<Integer, ImageSummary>();
		for (int i = 0; i < imageReference.size(); i++) {
			imageReferenceMap.put(i, imageReference.getImageSummary(i));
		}

		while (imageReferenceMap.size() > 1) {
			System.out.println("Clustering...");
			Multimap<Integer, Integer> clusters = ClusteringUtils
					.createClusters(imageReferenceMap);
			List<Integer> clusterCentroids = new ArrayList<Integer>();
			for (Collection<Integer> cluster : clusters.asMap().values()) {
				clusterCentroids.add(ClusteringUtils
						.findClusterRepresentation(imageReference
								.getImageSummaries(cluster)));
			}

			imageReferenceMap = imageReference.getImageSummaries(clusters
					.get(0));

			System.out.println("Showing...");
			new SimpleImageListFrame(clusterCentroids.toArray(new Integer[0]));
		}
	}
}

package ir_project.invoker;

import ir_project.clustering.ClusteringUtils;
import ir_project.gui.components.SimpleImageListFrame;
import ir_project.io.ImageSummaryReference;
import ir_project.model.ImageSummary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Multimap;

public class ShowClustersInvoker {
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		System.out.println("Loading...");
		ImageSummaryReference imageReference = ImageSummaryReference
				.loadImageSummary();
		Map<Integer, ImageSummary> imageReferenceMap = new HashMap<Integer, ImageSummary>();
		for (int i = 0; i < imageReference.size(); i++) {
			imageReferenceMap.put(i, imageReference.getImageSummary(i));
		}

		System.out.println("Clustering...");
		Multimap<Integer, Integer> clusters = ClusteringUtils
				.createClusters(imageReferenceMap);

		System.out.println("Showing...");
		for (Collection<Integer> cluster : clusters.asMap().values()) {
			new SimpleImageListFrame(cluster.toArray(new Integer[0]));
		}
	}
}

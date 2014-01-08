package ir_project.io;

import ir_project.model.ImageSummary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ImageSummaryReference implements Serializable {
	private static final long serialVersionUID = -4948591983304439349L;

	private static final int NUMBER_OF_IMAGES_TO_LOAD = 10000;
	public final static File THUMBNAIL_IMAGE_DIRECTORY = new File(
			"/home/stefan/Downloads/image_thumbnails");
	private final static File IMAGE_REFERENCE_FILE = new File(
			THUMBNAIL_IMAGE_DIRECTORY, "reference.obj");

	private final ImageSummary[] imageSummaries;

	private ImageSummaryReference(ImageSummary[] imageSummaries) {
		super();
		this.imageSummaries = imageSummaries;
	}

	public ImageSummary getImageSummary(int imageIndex) {
		return imageSummaries[imageIndex];
	}

	public Map<Integer, ImageSummary> getImageSummaries(
			Collection<Integer> imageIndexes) {
		Map<Integer, ImageSummary> imageSummaries = new HashMap<Integer, ImageSummary>();
		for (int imageIndex : imageIndexes) {
			imageSummaries.put(imageIndex, getImageSummary(imageIndex));
		}
		return imageSummaries;
	}

	public int size() {
		return imageSummaries.length;
	}

	public static ImageSummaryReference loadImageSummary()
			throws FileNotFoundException, IOException, ClassNotFoundException {
		if (IMAGE_REFERENCE_FILE.exists()) {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					IMAGE_REFERENCE_FILE));
			return (ImageSummaryReference) in.readObject();
		} else {
			ImageSummary[] imageSummaries = new ImageSummary[NUMBER_OF_IMAGES_TO_LOAD];
			for (int i = 1; i <= imageSummaries.length; i++) {
				File imageFile = new File(THUMBNAIL_IMAGE_DIRECTORY, "im" + i
						+ ".jpg");
				imageSummaries[i - 1] = ImageSummaryExtractor
						.extractImageSummary(imageFile);
			}
			ImageSummaryReference reference = new ImageSummaryReference(
					imageSummaries);
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(IMAGE_REFERENCE_FILE));
			out.writeObject(reference);
			out.flush();
			out.close();
			return reference;
		}
	}
}

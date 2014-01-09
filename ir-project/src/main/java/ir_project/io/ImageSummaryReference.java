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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageSummaryReference implements Serializable {
	private static final long serialVersionUID = -4948591983304439349L;

	private static final int NUMBER_OF_IMAGES_TO_LOAD = 10000;
	public final static File THUMBNAIL_IMAGE_DIRECTORY = new File("/Users/Robert/MIRFLICKR_THUMBS/thumbnails/1/");
	private final static File IMAGE_REFERENCE_FILE = new File(THUMBNAIL_IMAGE_DIRECTORY, "reference.obj");

	private final ImageSummary[] imageSummaries;

	private ImageSummaryReference(ImageSummary[] imageSummaries) {
		super();
		this.imageSummaries = imageSummaries;
	}

	public ImageSummary getImageSummary(int imageIndex) {
		return imageSummaries[imageIndex];
	}

	public List<Integer> getListOfAllImages() {
		List<Integer> allImages = new ArrayList<Integer>();
		// for (int i = 0; i < imageSummaries.length; i++) {
		// allImages.add(i);
		// }
		allImages.addAll(Arrays.asList(1273, 9843, 6514, 4479, 4934, 9817, 4870, 4049, 9918, 7253, 3171, 8968, 4869, 7463, 5769, 7180, 3498, 8510, 6412, 7817,
				3108, 7117, 4675, 1084, 7867, 5562, 3809, 6744, 9962, 3371, 6747, 861, 5329, 4558, 8803, 8789, 6504, 6151, 7906, 7707, 8746, 6357, 9408, 5039,
				2204, 2309, 2314, 9238, 2761, 2784, 4721, 3919, 2250, 7951, 2781, 86, 5300, 6969, 2508, 5887, 9799, 7007, 9310, 3275, 4281, 4599, 7105, 712,
				9694, 4515, 8830, 5874, 7857, 6029, 1601, 7271, 5694, 4114, 6830, 5452, 6687, 9093, 908, 1093, 352, 833, 2976, 3725, 7203, 8955, 2359, 4544,
				1069, 3720, 1938, 2698, 5738, 6794, 4130, 5374, 2959, 4797, 1654, 5398, 9499, 9658, 6717, 4001, 1576, 3454, 5191, 244, 8986, 6219, 674, 88,
				2783, 5849, 9814, 4647, 9451, 9664, 9823, 6293, 842, 6301, 9825, 8712, 3610, 1550, 1769, 7496, 6899, 4444, 3728, 8483, 1377, 1201, 735, 4954,
				2456, 6084, 5979, 1048, 6664, 8828, 8402, 3111, 1715, 1673, 5779, 3566, 1475, 5568, 5513, 3395, 2862, 1856, 3834, 428, 2404, 6128, 802, 7764,
				1867, 3895, 6306, 3386, 2147, 6415, 6715, 5941, 7538, 2991, 1501, 6409, 3614, 7613, 3734, 9496, 9386, 6531, 5367, 1016, 6392, 6125, 2230, 9252,
				1738, 8020, 3651, 6946, 3854, 6846, 3292, 6809, 9492, 186, 685, 9709, 8388, 9530, 2966, 6742, 4122, 7266, 6394, 284, 6389, 8825, 9611, 1211,
				2431, 742, 6706, 1538, 7643, 2177, 3289, 304, 4402, 7960, 6832, 4105, 318, 7053, 3509, 3211, 2016, 4247, 9863, 6819, 1146, 4229, 5876, 4202,
				2105, 6123, 1709, 1011, 9906, 4700, 9947, 3969, 1825, 6355, 2283, 6964, 4922, 3416, 5823, 4507, 8917, 5086, 9884, 6229, 9470, 2785, 7524, 7893,
				2604, 28, 3258, 7228, 9666, 4262, 7246, 6138, 1765, 2070, 282, 7963, 440, 7518, 2609, 4928, 1899, 6876, 5248, 3889, 400, 3224, 2123, 4219,
				6281, 6386, 1704, 6081, 5541, 850, 6108, 2162, 1971, 9357, 4405, 7165, 280, 2658, 1226, 8587, 79, 5015, 4060, 9101, 5067, 7284, 8086, 1714,
				631, 5372, 6400, 57, 452, 6900, 2197, 8320, 3603, 7099, 4197, 6433, 1541, 3361, 5735, 2031, 9621, 4414, 7741, 5617, 883, 4506, 6695, 9109,
				4390, 4266, 1437, 3839, 9559, 2066, 4376, 6987, 1532, 2073, 4134, 7823, 1006, 6405, 8695, 1445, 7328, 4323, 8688, 1841, 6655, 7186, 929, 5441,
				1598, 6658, 3180, 9405, 8189, 8490, 8965, 1471, 5, 3899, 8050, 7222, 3898, 4039, 7305, 5800, 8249, 6302, 3793, 6417, 8762, 843, 7355, 2412,
				1683, 3050, 2018, 1436, 1378, 2399, 6261, 1359, 7327, 1276, 6947, 6950, 9711, 1027, 5254, 2378, 9279, 1384, 3510, 2211, 1392, 928, 3541, 6525,
				970, 8970, 9418, 6311, 9842, 1991, 3389, 5736, 1593, 6537, 5511, 8810, 8528, 7541, 1643, 9030, 5507, 5014, 3235, 1694, 2169, 7619, 8202, 6765,
				2963, 2049, 910, 2901, 3106, 4164, 6601, 7695, 4518, 187, 51, 4957, 2214, 3012, 8085, 2225, 6056, 407, 7498, 8866, 4143, 4694, 9696, 4338,
				4174, 7425, 8240, 594, 2681, 8094, 909, 1832, 3499, 8752, 6999, 7953, 1702, 3496, 5148, 6144, 8617, 836, 2064, 8384, 719, 9326, 8148, 5147,
				2554, 2503, 8521, 3935, 820, 7009, 6746, 3189, 4246, 8262, 9824, 164, 2752, 147, 8299, 4773, 19, 3192, 8620, 781, 7782, 1292, 1059, 7765, 2202,
				8542, 1732, 4890, 7299, 3271, 4653, 6860, 7043, 5172, 5325, 5790, 2652, 62, 4442, 3988, 8610, 4630, 2701, 8142, 5722, 40, 7934, 5777, 1455,
				4230, 2098, 7224, 7462, 664, 6589, 7570, 3511, 1912, 8622, 2194, 3037, 6766, 6324, 2906, 7292, 7920, 3218, 4894, 2809, 8437, 8595, 6904, 8278,
				5327, 163, 3272, 176, 8123, 894, 5768, 4075, 1207, 7799, 4200, 7262, 7302, 624, 3674, 6098, 7376, 1289, 3439, 5382, 7479, 4300, 4158, 987,
				2551, 6259, 940, 7971, 9013, 6982, 489, 4438, 9610, 5212, 9449, 8780, 7626, 6318, 210, 5105, 895, 3798, 3117, 4483, 2765, 8840, 718, 1768,
				3109, 8093, 5920, 3018, 1131, 312, 9156, 302, 4741, 6356, 8700, 1132, 5528, 4722, 2436, 5915, 6839, 5265, 2155, 1907, 605, 1092, 3646, 3101,
				1305, 3381, 6251, 4682, 7227, 1605, 7348, 2185, 9859, 7642, 1493, 5043, 5578, 8549, 2945, 7789, 4729, 2473, 3966, 768, 8885, 7430, 6824, 1492,
				9416, 3022, 9371, 9522, 3625, 2790, 4809, 8283, 7943, 1609, 1990, 4833, 8724, 485, 561, 6789, 859, 1726, 6184, 2270, 7834, 7669, 653, 5633,
				9167, 324, 2852, 2664, 8589, 3668, 3397, 7259, 2434, 6749, 4456, 773, 7931, 690, 7640, 6119, 325, 3234, 7028, 5097, 2589, 4617, 4946, 9608,
				6127, 9705, 5271, 9331, 7232, 5795, 2400, 7112, 6353, 4093, 7042, 1864, 4274, 5786, 2571, 8631, 6014, 3003, 3597, 2135, 3985, 2791, 9888, 3964,
				5326, 9819, 2067, 5558, 7455, 8769, 2867, 5940, 8602, 6524, 6517, 9313, 3420, 8043, 3359, 7850, 3181, 7595, 9455, 7429, 4059, 7610, 497, 7763,
				4420, 2308, 7537, 3833, 2293, 2262, 4848, 1410, 6067, 5438, 1486, 5330, 4632, 3378, 5111, 5641, 6481, 8055, 8224, 4432, 1185, 2556, 3401, 1641,
				7323, 337, 5782, 2795, 3320, 8676, 5804, 7440, 9285, 7853, 7198, 2045, 2243, 6022, 7510, 9190, 7379, 2167, 2261, 774, 4504, 2137, 7875, 4564,
				5404, 9195, 963, 9079, 4948, 5010, 5413, 2646, 8302, 5369, 9785, 6952, 8049, 2839, 743, 5011, 2487, 4978, 6678, 9773, 8010, 5859, 829, 841,
				8272, 7197, 3880, 9580, 1412, 7139, 550, 5550, 9556, 8839, 1699, 9628, 8915, 1262, 9132, 5184, 2083, 1381, 3573, 5017, 3392, 848, 7417, 8815,
				8311, 6343, 5972, 7458, 7835, 4844, 524, 8537, 408, 7283, 1175, 2249, 6402, 7067, 5314, 5596, 5215, 5537, 7734, 5868, 4696, 8983, 6536, 1164,
				6221, 911, 4334, 623, 3825, 4455, 716, 9975, 3956, 3127, 6258, 5471, 5363, 8579, 5388, 7403, 4138, 4170, 9358, 6584, 2699, 7809, 7200, 2091,
				4344, 6474, 5904, 9051, 398, 8827, 1265, 5204, 7901, 9883, 4220, 4929, 8731, 9143, 5009, 2513, 1881, 7354, 4090, 6782, 5336, 99, 2583, 2813,
				2011, 5002, 9949, 140, 2445, 4814, 104, 3175, 5249, 1560, 2819, 1543, 8254, 1078, 1975, 6916, 9157, 7712, 4162, 5837, 6033, 2282, 9845, 2895,
				1676, 9792, 9389, 3388, 5830, 3112, 4851, 9963, 1551, 5174, 4883, 4924, 1372, 2362, 7660, 7286, 2685, 1972, 3739, 571, 4491, 6833, 1625, 2844,
				5970, 5598, 523, 6674, 6698, 6923, 7818, 9822, 5001, 9136, 7696, 2132, 2720, 8656, 8100, 5386, 3883, 2920, 9510, 43, 5663, 3626, 1712, 9118,
				3760, 6276, 9298, 3402, 6810, 3631, 8927, 888, 7716, 2425, 7504, 6344, 6380, 9872, 7539, 3209, 8978, 2292, 5457));
		return allImages;
	}

	public Map<Integer, ImageSummary> getImageSummaries(Collection<Integer> imageIndexes) {
		Map<Integer, ImageSummary> imageSummaries = new HashMap<Integer, ImageSummary>();
		for (int imageIndex : imageIndexes) {
			imageSummaries.put(imageIndex, getImageSummary(imageIndex));
		}
		return imageSummaries;
	}

	public int size() {
		return imageSummaries.length;
	}

	public static ImageSummaryReference loadImageSummary() throws FileNotFoundException, IOException, ClassNotFoundException {
		if (IMAGE_REFERENCE_FILE.exists()) {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(IMAGE_REFERENCE_FILE));
			return (ImageSummaryReference) in.readObject();
		} else {
			ImageSummary[] imageSummaries = new ImageSummary[NUMBER_OF_IMAGES_TO_LOAD];
			for (int i = 1; i <= imageSummaries.length; i++) {
				File imageFile = new File(THUMBNAIL_IMAGE_DIRECTORY, "im" + i + ".jpg");
				imageSummaries[i - 1] = ImageSummaryExtractor.extractImageSummary(imageFile);
			}
			ImageSummaryReference reference = new ImageSummaryReference(imageSummaries);
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(IMAGE_REFERENCE_FILE));
			out.writeObject(reference);
			out.flush();
			out.close();
			return reference;
		}
	}
}

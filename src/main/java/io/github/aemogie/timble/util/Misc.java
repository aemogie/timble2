package io.github.aemogie.timble.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Misc {
	public static String getFile(Path filepath) {
		String src = "";
		try {
			src = new String(Files.readAllBytes(filepath));
		} catch (IOException e) {
			Logger.logFatalError("Could not read file \"" + filepath.toAbsolutePath() + "\"!");
		}
		return src;
	}
	
	public static float[] floatListToArray(List<Float> list) {
		int i;
		float[] elementArray = new float[list.size()];
		i = 0;
		for (float val : list) {
			elementArray[i++] = val;
		}
		return elementArray;
	}
	
	public static int[] intListToArray(List<Integer> list) {
		int i;
		int[] elementArray = new int[list.size()];
		i = 0;
		for (int val : list) {
			elementArray[i++] = val;
		}
		return elementArray;
	}
}

package io.github.aemogie.timble.util;

import io.github.aemogie.timble.shaders.Shader;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class AssetPool {
	private static final Map<String, Shader> SHADERS = new HashMap<>();
	
	public static Shader getShader(Path resourcePath) {
		File file = resourcePath.toFile();
		if (!SHADERS.containsKey(file.getAbsolutePath())) {
			Shader shader = new Shader(resourcePath);
			shader.compile();
			AssetPool.SHADERS.put(file.getAbsolutePath(), shader);
		}
		return AssetPool.SHADERS.get(file.getAbsolutePath());
	}
}

package io.github.aemogie.timble.shaders;

import io.github.aemogie.timble.util.Logger;
import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GL40;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import static io.github.aemogie.timble.util.StringUtils.removeEmptyEntrees;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

public class Shader {
	private final Path filepath;
	HashMap<Integer, String> shaders;
	private int programID;
	
	public Shader(Path filepath) {
		this.filepath = filepath;
		shaders = new HashMap<>();
		try {
			String source = new String(Files.readAllBytes(filepath)).trim();
			String[] splitSource = removeEmptyEntrees(source.split("(#type)( )+(\\w)+"));
			for (String shader : splitSource) {
				String trimmedSrc = source.trim();
				int beginIndex = trimmedSrc.indexOf("#type ");
				if (beginIndex == -1) continue;
				int endIndex = trimmedSrc.substring(beginIndex).indexOf("\n") + beginIndex;
				String typeStr = trimmedSrc.substring(beginIndex, endIndex).replace("#type", "").trim();
				try {
					int type = GL20.class.getDeclaredField(typeStr).getInt(null);
					shaders.put(type, shader.trim());
				} catch (IllegalAccessException | NoSuchFieldException e1) { //GL20
					try {
						int type = GL32.class.getDeclaredField(typeStr).getInt(null);
						shaders.put(type, shader.trim());
					} catch (IllegalAccessException | NoSuchFieldException e2) { //GL32
						try {
							int type = GL40.class.getDeclaredField(typeStr).getInt(null);
							shaders.put(type, shader.trim());
						} catch (IllegalAccessException | NoSuchFieldException e3) {
							Logger.logFatalError("Invalid shader type: \"" + typeStr + "\" in shader file: \"" + filepath.toAbsolutePath() + "\"");
							e3.printStackTrace();
						}
					}
				} //GL40
				source = source.substring(endIndex);
			}
		} catch (IOException error) {
			error.printStackTrace();
			assert false : "Error: Could not open file for shader: '" + filepath.toAbsolutePath() + "'!";
		}
	}
	
	public void compile() {
		programID = glCreateProgram();
		shaders.forEach((type, source) -> glAttachShader(programID, getShaderIDFromSource(source, type)));
		glLinkProgram(programID);
		//Check for errors
		int success = glGetProgrami(programID, GL_LINK_STATUS);
		if (success == GL_FALSE) {
			int length = glGetProgrami(programID, GL_INFO_LOG_LENGTH);
			System.out.println("ERROR: '" + filepath.toAbsolutePath() + "'\n\tShader linking failed!");
			System.out.println(glGetProgramInfoLog(programID, length));
		}
	}
	
	private int getShaderIDFromSource(String shaderSource, int type) {
		int shaderID = glCreateShader(type);
		glShaderSource(shaderID, shaderSource);
		glCompileShader(shaderID);
		if (glGetShaderi(shaderID, GL_COMPILE_STATUS) == GL_FALSE)
			Logger.logFatalError("Compilation of " + type + " failed! - \"" + filepath.toAbsolutePath() + "\"\n" + glGetShaderInfoLog(shaderID, glGetShaderi(shaderID, GL_INFO_LOG_LENGTH)));
		return shaderID;
	}
	
	public void attach() {
		GL20.glUseProgram(programID);
	}
	
	public void detach() {
		GL20.glUseProgram(0);
	}
	
	public void uploadMat4f(String varName, Matrix4f mat4) {
		int varLocation = glGetUniformLocation(programID, varName);
		FloatBuffer matBuffer = BufferUtils.createFloatBuffer(16);
		mat4.get(matBuffer);
		glUniformMatrix4fv(varLocation, false, matBuffer);
	}
	
	public enum ShaderDataType {
		FLOAT(1, Float.BYTES, GL_FLOAT),
		VEC2F(2, Float.BYTES, GL_FLOAT),
		VEC3F(3, Float.BYTES, GL_FLOAT),
		VEC4F(4, Float.BYTES, GL_FLOAT),
		INT(1, Integer.BYTES, GL_INT),
		;
		public final int COUNT;
		public final int SIZE;
		public final int GL_DATA_TYPE;
		
		ShaderDataType(int count, int byteSize, int glDataType) {
			COUNT = count;
			SIZE = count * byteSize;
			GL_DATA_TYPE = glDataType;
		}
	}
}
package io.github.aemogie.timble.renderer.components.primitives;


import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;

public enum GLPrimitive {
	TRIANGLE(GL_TRIANGLES, 1, 3),
	LINE(GL_LINES, 1, 2),
	QUAD(GL_TRIANGLES, 2, 3);
	public final int GL_PRIMITIVE;
	public final int COUNT;
	public final int VERTICES;
	
	GLPrimitive(final int GL_PRIMITIVE,final int COUNT, final int VERTICES) {
		this.GL_PRIMITIVE = GL_PRIMITIVE;
		this.COUNT = COUNT;
		this.VERTICES = VERTICES;
	}
}

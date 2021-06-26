package io.github.aemogie.timble.renderer.components.misc;

import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class ElementBuffer extends Buffer {
	public ElementBuffer(int size) {
		super(GL_ELEMENT_ARRAY_BUFFER, GL_STATIC_DRAW, size);
	}
}

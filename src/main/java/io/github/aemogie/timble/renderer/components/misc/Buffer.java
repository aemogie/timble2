package io.github.aemogie.timble.renderer.components.misc;

import java.util.List;

import static io.github.aemogie.timble.util.Misc.intListToArray;
import static org.lwjgl.opengl.GL15.*;

public class Buffer {
	protected final int GL_BUFFER_TYPE;
	protected final int GL_DRAW_TYPE;
	protected final int SIZE;
	protected int id;
	
	public Buffer(final int GL_BUFFER_TYPE, final int GL_DRAW_TYPE, final int SIZE) {
		this.GL_BUFFER_TYPE = GL_BUFFER_TYPE;
		this.GL_DRAW_TYPE = GL_DRAW_TYPE;
		this.SIZE = SIZE;
	}
	
	public void create() {
		this.id = glGenBuffers();
		bind();
		glBufferData(GL_BUFFER_TYPE, SIZE, GL_DRAW_TYPE);
	}
	
	public void create(List<Integer> bufferData) {
		this.id = glGenBuffers();
		bind();
		bufferData(bufferData);
	}
	
	private void bufferData(List<Integer> bufferData) {
		glBufferData(GL_BUFFER_TYPE, intListToArray(bufferData), GL_DRAW_TYPE);
	}
	
	protected void bind() {
		glBindBuffer(GL_BUFFER_TYPE, this.id);
	}
}

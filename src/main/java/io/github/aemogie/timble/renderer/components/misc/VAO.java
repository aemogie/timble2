package io.github.aemogie.timble.renderer.components.misc;

import io.github.aemogie.timble.renderer.components.misc.Layout.Attribute;

import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;
import static org.lwjgl.opengl.GL43.glObjectLabel;

public class VAO {
	private final int VAO_ID;
	private final Layout LAYOUT;
	
	public VAO(final Layout LAYOUT) {
		this.LAYOUT = LAYOUT;
		this.VAO_ID = glGenVertexArrays();
		bind();
	}
	
	protected void bind() {glBindVertexArray(VAO_ID);}
	protected void unbind() {glBindVertexArray(0);}
	
	public void genPointers() {
		int i = 0;
		for (Attribute attribute : LAYOUT.attribs) {
			glVertexAttribPointer(i, attribute.DATA_TYPE().COUNT, attribute.DATA_TYPE().GL_DATA_TYPE, false, LAYOUT.strideSize, attribute.OFFSET());
			i++;
		}
	}
	
	public void enablePointers() {
		bind();
		for (int i = 0; i < LAYOUT.attribs.size(); i++) glEnableVertexAttribArray(i);
	}
	public void disablePointers() {
		for (int i = 0; i < LAYOUT.attribs.size(); i++) glEnableVertexAttribArray(0);
		unbind();
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [" + LAYOUT.toString() + "]";
	}
}

package io.github.aemogie.timble.renderer.components.misc;

import io.github.aemogie.timble.renderer.components.primitives.AbstractPrimitive;

import java.util.List;
import java.util.stream.Collectors;

import static io.github.aemogie.timble.util.Misc.floatListToArray;
import static org.lwjgl.opengl.GL15.*;

public class VertexBuffer<T extends AbstractPrimitive<?>> extends Buffer {
	
	public VertexBuffer(final int SIZE) {
		super(GL_ARRAY_BUFFER, GL_DYNAMIC_DRAW, SIZE);
	}
	
	private List<Float> get(final List<T> primitives) {
		return primitives.stream().flatMap(t -> t.getData().stream()).collect(Collectors.toList());
	}
	
	public void rebuffer(List<T> primitives) {
		glBindBuffer(GL_BUFFER_TYPE, id);
		glBufferData(GL_BUFFER_TYPE, floatListToArray(get(primitives)), GL_DRAW_TYPE);
		primitives.forEach(AbstractPrimitive::setClean);
	}
}
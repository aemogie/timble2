package io.github.aemogie.timble.renderer.components.primitives;

import io.github.aemogie.timble.renderer.components.vertextypes.AbstractVertex;
import io.github.aemogie.timble.renderer.components.misc.Layout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public abstract class AbstractPrimitive<T extends AbstractVertex> {
	public GLPrimitive glPrimitive;
	public BiConsumer<Integer, List<Integer>> elementSupplier;
	public int noOfVertices;
	public List<T> vertices;
	protected Layout layout;
	
	public AbstractPrimitive(GLPrimitive glPrimitive, BiConsumer<Integer, List<Integer>> elementSupplier, int noOfVertices) {
		this.glPrimitive = glPrimitive;
		this.elementSupplier = (primitiveIndex, indexBuffer) -> elementSupplier.accept(noOfVertices * primitiveIndex, indexBuffer);
		this.noOfVertices = noOfVertices;
		vertices = new ArrayList<>(noOfVertices);
	}
	
	public void setVertex(int index, T vertex) {
		vertices.set(index, vertex);
		setDirty();
	}
	
	public void create(Layout layout) {
		this.layout = layout;
		rebuffer();
	}
	
	public abstract void rebuffer();
	
	public Collection<Float> getData() {
		return vertices.stream().flatMap(t -> t.getData().stream()).collect(Collectors.toList());
	}
	
	public boolean isDirty() {
		return vertices.stream().anyMatch(AbstractVertex::isDirty);
	}
	
	public void setClean() {
		vertices.forEach(AbstractVertex::setClean);
	}
	
	public void setDirty() {
		vertices.forEach(AbstractVertex::setDirty);
	}
	
	public void unbind() {
	}
}

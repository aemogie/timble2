package io.github.aemogie.timble.renderer.components.vertextypes;

import io.github.aemogie.timble.renderer.components.misc.Layout;
import io.github.aemogie.timble.renderer.components.misc.Layout.Attribute;
import io.github.aemogie.timble.shaders.Shader.ShaderDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static io.github.aemogie.timble.util.Logger.logFatalError;

public abstract class AbstractVertex  {
	private final List<Float> data;
	public List<VertexAttribute> attribs;
	private boolean isDirty;
	
	protected AbstractVertex() {
		data = new ArrayList<>();
		attribs = new ArrayList<>();
		isDirty = true;
	}
	
	protected void create(Layout layout, Collection<VertexAttribute> attribs) {
		addAll(layout, attribs);
		getData();
	}
	
	private void addAll(Layout layout, Collection<VertexAttribute> attribs) {
		this.attribs.addAll(attribs);
		compareLayoutAndAttribList(layout, this.attribs);
		setDirty();
	}
	
	private void compareLayoutAndAttribList(Layout layout, List<VertexAttribute> attribs) {
		for (int i = 0; i < attribs.size(); i++) {
			Attribute expected = layout.attribs.get(i);
			VertexAttribute current = attribs.get(i);
			if (current.getData().length != expected.DATA_TYPE().COUNT) {
				logFatalError("Invalid count of data provided for argument \"" + expected.NAME() + "\". Expected " + expected.DATA_TYPE().COUNT + ", but found " + current.getData().length);
			}
			if (current.getShaderDataType() != expected.DATA_TYPE()) {
				logFatalError("Invalid type of data provided for argument \"" + expected.NAME() + "\". Expected " + expected.DATA_TYPE() + ", but found " + current.getShaderDataType());
			}
		}
	}
	
	protected<T extends VertexAttribute> T setValue(T prev, T next) {
		int index = attribs.indexOf(prev);
		if (index == -1) logFatalError("Error trying to set attribute \"" + prev.getClass().getSimpleName() + "\": Attribute doesn't exist!");
		attribs.set(index, next);
		setDirty();
		return next;
	}
	
	public List<Float> getData() {
		if (isDirty) {
			data.clear();
			attribs.forEach(attrib -> data.addAll(Arrays.asList(attrib.getData())));
		}
		return data;
	}
	
	public void setClean() {isDirty = false;}
	public void setDirty() {isDirty = true;}
	public boolean isDirty() {return isDirty;}
	
	public interface VertexAttribute {
		Float[] getData();
		ShaderDataType getShaderDataType();
	}
}
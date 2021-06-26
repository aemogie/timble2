package io.github.aemogie.timble.gameobjects;

import io.github.aemogie.timble.gameobjects.components.Component;
import io.github.aemogie.timble.renderer.components.primitives.AbstractPrimitive;
import io.github.aemogie.timble.renderer.components.vertextypes.PositionedVertex;
import io.github.aemogie.timble.renderer.components.misc.Layout;
import io.github.aemogie.timble.scenes.AbstractScene;
import io.github.aemogie.timble.scenes.Scene;

import java.util.Collection;
import java.util.List;

public abstract class AbstractGameObject<T extends AbstractPrimitive<PositionedVertex>> extends AbstractPrimitive<PositionedVertex> {
	private final T RENDER_OBJECT;
	protected List<Component> components;
	
	public AbstractGameObject(T RENDER_OBJECT) {
		super(RENDER_OBJECT.glPrimitive, RENDER_OBJECT.elementSupplier, RENDER_OBJECT.noOfVertices);
		this.RENDER_OBJECT = RENDER_OBJECT;
	}
	
	protected abstract<S extends AbstractScene<?,?>> void loop(S scene);
	
	public<S extends AbstractScene<?,?>> void update(S scene) {
		components.forEach(component -> component.update(scene));
		loop(scene);
	}
	
	public <V extends Component> boolean addComponent(V component) {
		return components.add(component);
	}
	
	@Override
	public void setVertex(int index, PositionedVertex vertex) {
		RENDER_OBJECT.setVertex(index, vertex);
	}
	
	@Override
	public void create(Layout layout) {
		RENDER_OBJECT.create(layout);
	}
	
	@Override
	public Collection<Float> getData() {
		return RENDER_OBJECT.getData();
	}
	
	@Override
	public boolean isDirty() {
		return RENDER_OBJECT.isDirty();
	}
	
	@Override
	public void setClean() {
		RENDER_OBJECT.setClean();
	}
	
	@Override
	public void setDirty() {
		RENDER_OBJECT.setDirty();
	}
	
	@Override
	public void unbind() {
		RENDER_OBJECT.unbind();
	}
	
	@Override
	public void rebuffer() {
		RENDER_OBJECT.rebuffer();
	}
	
}

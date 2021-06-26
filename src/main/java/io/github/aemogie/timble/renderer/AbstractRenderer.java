package io.github.aemogie.timble.renderer;

import io.github.aemogie.timble.renderer.components.misc.ElementBuffer;
import io.github.aemogie.timble.renderer.components.misc.Layout;
import io.github.aemogie.timble.renderer.components.misc.VAO;
import io.github.aemogie.timble.renderer.components.misc.VertexBuffer;
import io.github.aemogie.timble.renderer.components.primitives.AbstractPrimitive;
import io.github.aemogie.timble.renderer.components.primitives.GLPrimitive;
import io.github.aemogie.timble.scenes.AbstractScene;
import io.github.aemogie.timble.shaders.Shader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;

public abstract class AbstractRenderer<T extends AbstractPrimitive<?>> {
	public T unit;
	protected int maxBatchSize;
	protected List<T> primitives;
	private VAO vao;
	private VertexBuffer<T> vbo;
	private List<Integer> elements;
	private boolean hasSpace = true;
	private int noOfVerticesPerPrimitive;
	private Layout layout;
	private GLPrimitive glPrimitive;
	
	public void create(Function<Layout, T> unitFunc, int maxBatchSize) {
		layout = new Layout();
		addLayoutAttribs(layout);
		this.maxBatchSize = maxBatchSize;
		primitives = new ArrayList<>(this.maxBatchSize);
		unit = unitFunc.apply(layout);
		glPrimitive = unit.glPrimitive;
		noOfVerticesPerPrimitive = unit.noOfVertices;
		elements = new ArrayList<>(this.maxBatchSize * glPrimitive.COUNT * glPrimitive.VERTICES);
		IntStream.range(0, this.maxBatchSize).forEach(i -> unit.elementSupplier.accept(i, elements));
	}
	
	public void start() {
		vao = new VAO(layout);
		vbo = new VertexBuffer<>(maxBatchSize * noOfVerticesPerPrimitive * layout.stride * Float.BYTES);
		vbo.create();
		new ElementBuffer(elements.size()).create(elements);
		vao.genPointers();
		vao.enablePointers();
	}
	
	protected abstract void addLayoutAttribs(final Layout LAYOUT);
	
	protected abstract<V extends AbstractScene<?, ?>> void uploadUniforms(final V scene, final Shader shader);
	
	public <V extends AbstractPrimitive<?>> boolean add(V primitive) {
		hasSpace = primitives.size() < maxBatchSize;
		if (!hasSpace) return false;
		primitive.create(layout);
		//noinspection unchecked
		return primitives.add((T) primitive);
	}
	
	@SuppressWarnings("UnusedReturnValue")
	public boolean addAll(Collection<T> primitives) {
		hasSpace = this.primitives.size() < maxBatchSize;
		if (!hasSpace) return false;
		primitives.forEach(primitive -> primitive.create(layout));
		return this.primitives.addAll(primitives);
	}
	
	public boolean remove(T primitive) {
		boolean success = primitives.remove(primitive);
		if (success) hasSpace = true;
		return success;
	}
	
	public<V extends AbstractScene<?,?>> void render(V scene, Shader shader) {
		shader.attach();
		uploadUniforms(scene, shader);
		if (primitives.stream().anyMatch(primitive -> primitive.isDirty())) vbo.rebuffer(primitives);
		glDrawElements(glPrimitive.GL_PRIMITIVE, primitives.size() * glPrimitive.VERTICES * glPrimitive.COUNT, GL_UNSIGNED_INT, 0);
		shader.detach();
	}
	
	public boolean hasSpace() {
		return hasSpace;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {\n\t" + primitives.toString() + "\n\t" + vao.toString() + "\n}";
	}
}
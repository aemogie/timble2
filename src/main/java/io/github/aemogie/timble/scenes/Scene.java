package io.github.aemogie.timble.scenes;

import io.github.aemogie.timble.gameobjects.QuadGameObject;
import io.github.aemogie.timble.renderer.QuadRenderer;
import io.github.aemogie.timble.renderer.attributes.Colour;
import io.github.aemogie.timble.renderer.components.primitives.Quad;
import io.github.aemogie.timble.timble.Window;
import io.github.aemogie.timble.util.datastructs.Vector2f;

public class Scene extends AbstractScene<Quad, QuadRenderer> {
	public Scene(Window WINDOW) {
		super(WINDOW);
		QuadGOProvider goProvider = this::getQuad;
		add(goProvider.get(0,0, 1000, 100));
		add(goProvider.get(0,200, 1000, 100));
	}
	
	protected QuadGameObject getQuad(float x, float y, float width, float height) {
		return new QuadGameObject(new Quad(new Vector2f(x, y), new Vector2f(width, height), false, new Colour(0, 128, 128)));
	}
	
	@Override
	protected void addRenderer() {
		QuadRenderer quadRenderer = new QuadRenderer(1000);
		quadRenderer.start();
		for (int i = 0; i < 10; i++) renderers.add(quadRenderer);
	}
	
	@Override
	protected void loadResources() {
	
	}
	
	@Override
	public void update(double deltaTime) {}
	
	@FunctionalInterface
	private interface QuadGOProvider {
		QuadGameObject get(float x, float y, float width, float height);
	}
}

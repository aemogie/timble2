package io.github.aemogie.timble.gameobjects;

import io.github.aemogie.timble.renderer.components.primitives.Quad;
import io.github.aemogie.timble.scenes.AbstractScene;

public class QuadGameObject extends AbstractGameObject<Quad> {
	public QuadGameObject(Quad RENDER_OBJECT) {
		super(RENDER_OBJECT);
	}
	
	@Override
	protected <S extends AbstractScene<?, ?>> void loop(S scene) {
	
	}
}

package io.github.aemogie.timble.gameobjects.components;

import io.github.aemogie.timble.gameobjects.AbstractGameObject;
import io.github.aemogie.timble.scenes.AbstractScene;

public abstract class Component {
	public transient AbstractGameObject<?> gameObject;
	
	protected <T extends AbstractGameObject<?>> Component(T go) {
		gameObject = go;
	}
	
	public void start() {}
	
	public abstract <S extends AbstractScene<?, ?>> void update(S scene);
}
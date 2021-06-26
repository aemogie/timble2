package io.github.aemogie.timble.renderer;

import io.github.aemogie.timble.renderer.components.primitives.AbstractPrimitive;
import io.github.aemogie.timble.scenes.AbstractScene;
import io.github.aemogie.timble.shaders.Shader;

public abstract class ScreenRenderer<T extends AbstractPrimitive<?>> extends AbstractRenderer<T> {
	@Override
	protected<V extends AbstractScene<?, ?>> void uploadUniforms(final V scene, Shader shader) {
		shader.uploadMat4f("uProjection", scene.getCamera().getProjectionMatrix());
		shader.uploadMat4f("uView", scene.getCamera().getViewMatrix());
	}
}

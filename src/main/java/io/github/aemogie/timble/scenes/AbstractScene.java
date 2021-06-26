package io.github.aemogie.timble.scenes;

import io.github.aemogie.timble.gameobjects.AbstractGameObject;
import io.github.aemogie.timble.renderer.AbstractRenderer;
import io.github.aemogie.timble.renderer.components.primitives.AbstractPrimitive;
import io.github.aemogie.timble.renderer.components.primitives.Quad;
import io.github.aemogie.timble.renderer.components.vertextypes.PositionedVertex;
import io.github.aemogie.timble.shaders.Shader;
import io.github.aemogie.timble.timble.Camera;
import io.github.aemogie.timble.timble.Window;
import io.github.aemogie.timble.util.datastructs.Vector3f;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static io.github.aemogie.timble.timble.Camera.CameraMode.ORTHOGRAPHIC;
import static io.github.aemogie.timble.timble.Camera.CameraMode.PERSPECTIVE;

/**
 * @author <a href="mailto:theaemogie@gmail.com"> Aemogie. </a>
 */
public abstract class AbstractScene<T extends AbstractPrimitive<PositionedVertex>, R extends AbstractRenderer<T>> {
	
	protected final Window WINDOW;
	protected Shader shader;
	protected List<AbstractGameObject<T>> gameObjects = new ArrayList<>();
	protected transient boolean isRunning = false;
	protected List<R> renderers = new ArrayList<>();
	protected Camera camera;
	
	public AbstractScene(final Window WINDOW) {
		this.WINDOW = WINDOW;
		camera = new Camera();
		camera.init(ORTHOGRAPHIC, new Vector3f(0,0, 1000));
	}
	
	public void init() {
		loadResources();
		for (AbstractRenderer<?> renderer : renderers) {
			gameObjects.stream().filter(ro -> renderer.unit.getClass().isAssignableFrom(ro.getClass())).forEach(renderer::add);
		}
	}
	
	public <V extends AbstractGameObject<T>> void add(V go) {
		gameObjects.add(go);
		addGameObjectToRenderer(go);
	}
	
	private <V extends AbstractGameObject<T>> void addGameObjectToRenderer(V go) {
		Optional<R> optionalRenderer = renderers.stream().filter(AbstractRenderer::hasSpace).findFirst();
		if (optionalRenderer.isPresent()) {
			optionalRenderer.get().add(go);
		} else {
			addRenderer();
			addGameObjectToRenderer(go);
		}
	}
	
	protected abstract void addRenderer();
	
	public void start() {
		isRunning = true;
	}
	
	protected abstract void loadResources();
	
	public void update(double deltaTime) {
		gameObjects.forEach(go -> go.update(this));
	}
	
	public void preFrame() {
	}
	
	public void render(Shader shader) {
		this.shader = shader;
		renderers.forEach(renderer -> renderer.render(this, shader));
	}
	
	public void postFrame() {
	}
	
	public void end(Window window) {
		isRunning = false;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	public Camera getCamera() {
		return camera;
	}
}
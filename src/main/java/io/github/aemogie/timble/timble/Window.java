package io.github.aemogie.timble.timble;

import io.github.aemogie.timble.renderer.attributes.Colour;
import io.github.aemogie.timble.scenes.AbstractScene;
import io.github.aemogie.timble.shaders.Shader;
import io.github.aemogie.timble.util.AssetPool;
import io.github.aemogie.timble.util.datastructs.Vector3f;
import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import java.util.Objects;
import java.util.function.Function;

import static io.github.aemogie.timble.renderer.attributes.Colour.Presets.GREY;
import static io.github.aemogie.timble.timble.Camera.CameraMode.ORTHOGRAPHIC;
import static io.github.aemogie.timble.util.StringUtils.resourcePath;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
	
	private final GLFWVidMode vidMode = Objects.requireNonNull(GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor()));
	private final boolean fullscreen;
	private final Colour clearColour;
	private final String title;
	private final boolean vsync;
	private long glfwAddress;
	@SuppressWarnings("FieldMayBeFinal")
	private int width, height;
	private AbstractScene<?, ?> currentScene;
	
	//region Constructor.
	private Window(String title, Colour clearColour, boolean fullscreen, boolean vsync) {
		this.title = title;
		GLFWVidMode videoMode = Objects.requireNonNull(glfwGetVideoMode(glfwGetPrimaryMonitor()));
		this.width = fullscreen ? videoMode.width() : (int) (videoMode.width() / 1.5);
		this.height = fullscreen ? videoMode.height() : (int) (videoMode.height() / 1.5);
		this.clearColour = clearColour;
		this.vsync = vsync;
		this.fullscreen = fullscreen;
	}
	//endregion
	
	//region Create windows.
	public static Window create() {
		return create("Timble Game Engine (By Aemogie.)");
	}
	
	public static Window create(String title) {
		return create(title, GREY);
	}
	
	public static Window create(String title, Colour clearColour) {
		return create(title, clearColour, false);
	}
	
	public static Window create(String title, Colour clearColour, boolean fullScreen) {
		return create(title, clearColour, fullScreen, true);
	}
	
	public static Window create(String title, Colour clearColour, boolean fullScreen, boolean vsync) {
		GLFWErrorCallback.createPrint(System.err).set();
		if (!glfwInit()) throw new IllegalStateException("Unable to initialize GLFW!");
		return new Window(title, clearColour, fullScreen, vsync);
	}
	//endregion
	
	//region Main stuff: initialize, loop, destroy.
	public<T extends AbstractScene<?,?>> void run(Function<Window, T> sceneProvider) {
		windowInit(sceneProvider);
		windowLoop();
		windowDestroy();
	}
	
	public<T extends AbstractScene<?, ?>> void windowInit(Function<Window, T> sceneProvider) {
		//Properties
		glfwDefaultWindowHints(); //Default window hints
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); //Invisible till setup is complete
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); //Resizable to true in-case default doesn't work
//		glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);
		
		// Create the window
		glfwAddress = glfwCreateWindow(this.width, this.height, this.title, fullscreen ? glfwGetPrimaryMonitor() : NULL, NULL); //The long is the memory address of the window.
		
		if (glfwAddress == NULL) {
			throw new IllegalStateException("Failed to create GLFW Window!");
		}
		
		//region Callback setup
		// TODO: 4/11/2021 Port to Dev Kit.
		//endregion
		
		// Make the OpenGL context current
		glfwMakeContextCurrent(glfwAddress);
		//Enable vsync
		glfwSwapInterval(vsync ? 1 : 0);
		
		// Make the window visible
		glfwShowWindow(glfwAddress);
		GL.createCapabilities();
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		// Set resize callback after we make the current context.
		//TODO: glfwSetWindowSizeCallback(glfwAddress, (window, width, height) -> WindowResizeListener.resizeCallback(this, width, height));

		changeScene(sceneProvider);
		glViewport(0, 0, width, height);
	}
	
	private <T extends AbstractScene<?, ?>> void changeScene(Function<Window, T> sceneProvider) {
		if (currentScene != null) currentScene.end(this);
		currentScene = sceneProvider.apply(this);
		currentScene.start();
	}
	
	private void windowLoop() {
		Shader defaultShader = AssetPool.getShader(resourcePath("shaders/defaultShader.glsl"));
		glClearColor(clearColour.nR, clearColour.nG, clearColour.nB, clearColour.nA);
		currentScene.init();
		currentScene.start();
		while (!GLFW.glfwWindowShouldClose(glfwAddress)) {
			GLFW.glfwPollEvents();
			glClear(GL_COLOR_BUFFER_BIT);
			currentScene.update(0);
			currentScene.render(defaultShader);
			GLFW.glfwSwapBuffers(glfwAddress);
		}
	}
	
	private void windowDestroy() {
		Callbacks.glfwFreeCallbacks(glfwAddress);
		GLFW.glfwDestroyWindow(glfwAddress);
		GLFW.glfwTerminate();
		Objects.requireNonNull(GLFW.glfwSetErrorCallback(null)).free();
	}
	//endregion
	
	public int getTargetAspectRatio() {
		return width / height;
	}
	
	public Colour getClearColour() {
		return this.clearColour;
	}

}
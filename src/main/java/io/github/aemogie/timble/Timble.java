package io.github.aemogie.timble;

import io.github.aemogie.timble.scenes.Scene;
import io.github.aemogie.timble.timble.Window;

public class Timble {
	public static void main(String[] args) {
		Window.create("HaLlO!").run(Scene::new);
	}
}
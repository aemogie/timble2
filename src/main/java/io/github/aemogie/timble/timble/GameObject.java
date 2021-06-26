package io.github.aemogie.timble.timble;

import io.github.aemogie.timble.gameobjects.components.Component;

import java.util.ArrayList;
import java.util.List;

public class GameObject {
	private int UUID;
	private String name;
	private final List<Component> components = new ArrayList<>();
}

package io.github.aemogie.timble.renderer.components.vertextypes;

import io.github.aemogie.timble.renderer.attributes.Colour;
import io.github.aemogie.timble.renderer.components.misc.Layout;
import io.github.aemogie.timble.util.datastructs.Vector2f;
import io.github.aemogie.timble.util.datastructs.Vector3f;

import java.util.Arrays;

public class PositionedVertex extends AbstractVertex {
	Vector3f position;
	Colour colour;
	
	public PositionedVertex(Layout layout, Vector3f position, Colour colour) {
		this.position = position;
		this.colour = colour;
		create(layout, Arrays.asList(this.position, this.colour));
	}
	public PositionedVertex(Layout layout, Vector2f position, Colour colour) {
		this.position = new Vector3f(position);
		this.colour = colour;
		create(layout, Arrays.asList(this.position, this.colour));
	}
	
	public Vector3f getPosition() {
		return position;
	}
	
	public void setPosition(Vector3f position) {
		this.position = setValue(this.position, position);
	}
	
	public Colour getColour() {
		return colour;
	}
	
	public void setColour(Colour colour) {
		this.colour = setValue(this.colour, colour);
	}
}

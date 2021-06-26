package io.github.aemogie.timble.renderer.components.primitives;

import io.github.aemogie.timble.renderer.components.vertextypes.PositionedVertex;
import io.github.aemogie.timble.renderer.attributes.Colour;
import io.github.aemogie.timble.util.Logger;
import io.github.aemogie.timble.util.datastructs.Vector2f;

import java.util.List;

import static io.github.aemogie.timble.renderer.components.primitives.GLPrimitive.QUAD;

public class Quad extends AbstractPrimitive<PositionedVertex> {
	
	private Vector2f pos;
	private Vector2f scale;
	private boolean centered;
	private Colour[] colours;
	private boolean colour_nXnY_to_pXpY;
	
	public Quad(Vector2f pos, Vector2f scale, boolean centered, Colour colour0, Colour colour1, boolean colour_nXnY_to_pXpY) {
		this(pos, scale, centered, getColours(colour0, colour1, colour_nXnY_to_pXpY));
	}
	
	public Quad(Vector2f pos, Vector2f scale, boolean centered, Colour... colours) {
		super(QUAD, Quad::elementSupplier, 4);
		this.pos = pos;
		this.scale = scale;
		this.centered = centered;
		this.colours = colours;
	}
	
	public Quad(Vector2f pos, Vector2f scale, boolean centered, Colour colour0, Colour colour1) {
		this(pos, scale, centered, colour0, colour1, true);
	}
	
	public Quad(Vector2f pos, Vector2f scale, boolean centered, Colour colour) {
		this(pos, scale, centered, colour, colour, colour, colour);
	}
	
	private static Colour[] getColours(Colour colour0, Colour colour1, boolean color_nXnY_to_pXpY) {
		return new Colour[]{
				color_nXnY_to_pXpY ? colour0 : getMidColour(colour0, colour1),
				color_nXnY_to_pXpY ? getMidColour(colour0, colour1) : colour0,
				color_nXnY_to_pXpY ? getMidColour(colour0, colour1) : colour1,
				color_nXnY_to_pXpY ? colour1 : getMidColour(colour0, colour1)
		};
	}
	
	private static Colour getMidColour(Colour colour0, Colour colour1) {
		return new Colour(
				(colour0.r + colour1.r) / 2,
				(colour0.g + colour1.g) / 2,
				(colour0.b + colour1.b) / 2,
				(colour0.a + colour1.a) / 2
		);
	}
	
	private Vector2f[] getPos(boolean center) {
		if (center)
			return new Vector2f[]{
					new Vector2f(pos.x - scale.x / 2, pos.y - scale.y / 2),
					new Vector2f(pos.x + scale.x / 2, pos.y - scale.y / 2),
					new Vector2f(pos.x - scale.x / 2, pos.y + scale.y / 2),
					new Vector2f(pos.x + scale.x / 2, pos.y + scale.y / 2)
			};
		return new Vector2f[]{
				new Vector2f(pos.x, pos.y),
				new Vector2f(pos.x + scale.x, pos.y),
				new Vector2f(pos.x, pos.y + scale.y),
				new Vector2f(pos.x + scale.x, pos.y + scale.y)
		};
	}
	
	public void setPosAndScale(Vector2f pos, Vector2f scale) {
		this.pos = pos;
		this.scale = scale;
		rebuffer();
	}
	
	public void setPos(Vector2f pos) {
		this.pos = pos;
		rebuffer();
	}
	
	public void setScale(Vector2f scale) {
		this.scale = scale;
		rebuffer();
	}
	
	public void setScale(Vector2f scale, boolean centered) {
		this.scale = scale;
		this.centered = centered;
		rebuffer();
	}
	
	//region getColour();
	public Colour[] getColours() {
		return colours;
	}
	//endregion
	
	//region setColour();
	public void setColour(Colour colour) {
		setColour(colour, colour, colour, colour);
	}
	
	public void setColour(Colour colour0, Colour colour1) {
		setColour(getColours(colour0, colour1, colour_nXnY_to_pXpY));
	}
	
	public void setColour(Colour... colours) {
		System.arraycopy(colours, 0, this.colours, 0, this.colours.length);
		rebuffer();
	}
	
	public void setColour(Colour colour0, Colour colour1, boolean switchAxis) {
		if (switchAxis) colour_nXnY_to_pXpY = !colour_nXnY_to_pXpY;
		setColour(colour0, colour1);
	}
	//endregion
	
	@Override
	public void rebuffer() {
		vertices.clear();
		Vector2f[] positions = getPos(centered);
		for (int i = 0; i < noOfVertices; i++) {
			try {
				vertices.add(new PositionedVertex(layout, positions[i], colours[i]));
			} catch (ArrayIndexOutOfBoundsException exception) {
				if (colours.length != noOfVertices)
					Logger.logFatalError("Invalid count of colours provided! Expected " + noOfVertices + ", but found " + colours.length + ".");
				if (positions.length != noOfVertices)
					Logger.logFatalError("Invalid count of positions provided! Expected " + noOfVertices + ", but found " + positions.length + ".");
				if (vertices.size() != noOfVertices)
					Logger.logFatalError("Invalid count of vertices provided! Expected " + noOfVertices + ", but found " + vertices.size() + ".");
			}
		}
	}
	
	@SuppressWarnings("PointlessArithmeticExpression")
	private static void elementSupplier(Integer offset, List<Integer> indexBuffer) {
		indexBuffer.add(offset + 0);
		indexBuffer.add(offset + 1);
		indexBuffer.add(offset + 2);
		indexBuffer.add(offset + 2);
		indexBuffer.add(offset + 1);
		indexBuffer.add(offset + 3);
	}
}

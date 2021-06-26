package io.github.aemogie.timble.renderer;

import io.github.aemogie.timble.renderer.attributes.Colour;
import io.github.aemogie.timble.renderer.components.misc.Layout;
import io.github.aemogie.timble.renderer.components.primitives.Quad;
import io.github.aemogie.timble.util.datastructs.Vector2f;

import static io.github.aemogie.timble.shaders.Shader.ShaderDataType.VEC3F;
import static io.github.aemogie.timble.shaders.Shader.ShaderDataType.VEC4F;

public class QuadRenderer extends ScreenRenderer<Quad> {
	public QuadRenderer(int size) {
		create(this::getUnit, size);
	}
	
	private Quad getUnit(Layout layout) {
		Quad unit = new Quad(new Vector2f(-1, -1), new Vector2f(1, 1), false, new Colour(0, 0, 0, 0));
		unit.create(layout);
		return unit;
	}
	
	@Override
	protected void addLayoutAttribs(Layout layout) {
		layout.addAttribute("aPos", VEC3F);
		layout.addAttribute("aColor", VEC4F);
	}
}
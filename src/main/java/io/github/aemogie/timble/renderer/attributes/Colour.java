package io.github.aemogie.timble.renderer.attributes;

import io.github.aemogie.timble.renderer.components.vertextypes.AbstractVertex.VertexAttribute;
import io.github.aemogie.timble.shaders.Shader.ShaderDataType;
import io.github.aemogie.timble.util.TimbleMath;

import static io.github.aemogie.timble.shaders.Shader.ShaderDataType.VEC4F;

/**
 * @author <a href="mailto:theaemogie@gmail.com"> Aemogie. </a>
 */
public class Colour implements VertexAttribute {
	
	public float r;
	public float nR;
	public float g;
	public float nG;
	public float b;
	public float nB;
	public float a;
	public float nA;
	
	public Colour(float r, float g, float b, float a) {
		this.r = r;
		this.nR = toMap(r);
		this.g = g;
		this.nG = toMap(g);
		this.b = b;
		this.nB = toMap(b);
		this.a = a;
		this.nA = toMap(a);
	}
	
	public Colour(float r, float g, float b, float a, boolean normalized) {
		this.nR = r;
		this.r = fromMap(r);
		this.nG = g;
		this.g = fromMap(g);
		this.nB = b;
		this.b = fromMap(b);
		this.nA = a;
		this.a = fromMap(a);
	}
	
	public Colour(float r, float g, float b) {
		this(r, g, b, 255);
	}
	
	public Colour(float a, boolean normalized) {
		this(normalized ? 1 : 255, normalized ? 1 : 255, normalized ? 1 : 255, a, normalized);
	}
	
	private static float toMap(float value) {
		return TimbleMath.map(value, 0, 255, 0, 1);
	}
	
	private static float fromMap(float value) {
		return TimbleMath.map(value, 0, 1, 0, 255);
	}
	
	@Override
	public String toString() {
		return "Red: " + r + " Green: " + g + " Blue: " + b + " Alpha: " + a;
	}
	
	@Override
	public Float[] getData() {return new Float[]{nR, nG, nB, nA};}
	
	@Override
	public ShaderDataType getShaderDataType() {return VEC4F;}
	
	public static class Presets {
		public static final Colour GREY = new Colour(42, 42, 42, 255);
	}
	
	public Colour add(float v) {
		r += v;
		g += v;
		b += v;
		a += v;
		return this;
	}
}

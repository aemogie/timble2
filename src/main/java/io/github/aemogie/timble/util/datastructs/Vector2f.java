package io.github.aemogie.timble.util.datastructs;

import io.github.aemogie.timble.renderer.components.vertextypes.AbstractVertex.VertexAttribute;
import io.github.aemogie.timble.shaders.Shader.ShaderDataType;
import org.joml.*;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import static io.github.aemogie.timble.shaders.Shader.ShaderDataType.VEC3F;

public class Vector2f extends org.joml.Vector2f implements VertexAttribute {
	//region Casting stuff
	public Vector2f() {}
	public Vector2f(float x, float y) {super(x, y);}
	public Vector2f(Vector2fc v) {super(v);}
	public Vector2f(Vector2ic v) {super(v);}
	public Vector2f(float[] xy) {super(xy);}
	public Vector2f(float d) {super(d);}
	public Vector2f(ByteBuffer buffer) {super(buffer);}	
	public Vector2f(int index, ByteBuffer buffer) {super(index, buffer);}	
	public Vector2f(FloatBuffer buffer) {super(buffer);}	
	public Vector2f(int index, FloatBuffer buffer) {super(index, buffer);}
	public Vector2f set(float d) {return (Vector2f) super.set(d);}	
	public Vector2f set(float x, float y) {return (Vector2f) super.set(x, y);}	
	public Vector2f set(double d) {return (Vector2f) super.set(d);}	
	public Vector2f set(double x, double y) {return (Vector2f) super.set(x, y);}	
	public Vector2f set(Vector2fc v) {return (Vector2f) super.set(v);}	
	public Vector2f set(Vector2ic v) {return (Vector2f) super.set(v);}	
	public Vector2f set(Vector2dc v) {return (Vector2f) super.set(v);}	
	public Vector2f set(float[] xy) {return (Vector2f) super.set(xy);}	
	public Vector2f set(ByteBuffer buffer) {return (Vector2f) super.set(buffer);}	
	public Vector2f set(int index, ByteBuffer buffer) {return (Vector2f) super.set(index, buffer);}	
	public Vector2f set(FloatBuffer buffer) {return (Vector2f) super.set(buffer);}	
	public Vector2f set(int index, FloatBuffer buffer) {return (Vector2f) super.set(index, buffer);}	
	public Vector2f setFromAddress(long address) {return (Vector2f) super.setFromAddress(address);}
	public Vector2f get(Vector2f dest) {return (Vector2f) super.get(dest);}
	public Vector2f setComponent(int component, float value) throws IllegalArgumentException {return (Vector2f) super.setComponent(component, value);}
	public Vector2f perpendicular() {return (Vector2f) super.perpendicular();}	
	public Vector2f sub(Vector2fc v) {return (Vector2f) super.sub(v);}	
	public Vector2f sub(Vector2fc v, Vector2f dest) {return (Vector2f) super.sub(v, dest);}	
	public Vector2f sub(float x, float y) {return (Vector2f) (Vector2f) super.sub(x, y);}	
	public Vector2f sub(float x, float y, Vector2f dest) {return (Vector2f) (Vector2f) super.sub(x, y, dest);}
	public Vector2f normalize() {return (Vector2f) super.normalize();}	
	public Vector2f normalize(Vector2f dest) {return (Vector2f) super.normalize(dest);}	
	public Vector2f normalize(float length) {return (Vector2f) super.normalize(length);}	
	public Vector2f normalize(float length, Vector2f dest) {return (Vector2f) super.normalize(length, dest);}	
	public Vector2f add(Vector2fc v) {return (Vector2f) super.add(v);}	
	public Vector2f add(Vector2fc v, Vector2f dest) {return (Vector2f) super.add(v, dest);}	
	public Vector2f add(float x, float y) {return (Vector2f) super.add(x, y);}
	public Vector2f add(float x, float y, Vector2f dest) {return (Vector2f) super.add(x, y, dest);}	
	public Vector2f zero() {return (Vector2f) super.zero();}
	public Vector2f negate() {return (Vector2f) super.negate();}	
	public Vector2f negate(Vector2f dest) {return (Vector2f) super.negate(dest);}	
	public Vector2f mul(float scalar) {return (Vector2f) super.mul(scalar);}	
	public Vector2f mul(float scalar, Vector2f dest) {return (Vector2f) super.mul(scalar, dest);}	
	public Vector2f mul(float x, float y) {return (Vector2f) super.mul(x, y);}	
	public Vector2f mul(float x, float y, Vector2f dest) {return (Vector2f) super.mul(x, y, dest);}	
	public Vector2f mul(Vector2fc v) {return (Vector2f) super.mul(v);}
	public Vector2f mul(Vector2fc v, Vector2f dest) {return (Vector2f) super.mul(v, dest);}	
	public Vector2f div(Vector2fc v) {return (Vector2f) super.div(v);}	
	public Vector2f div(Vector2fc v, Vector2f dest) { return (Vector2f) super.div(v, dest);}	
	public Vector2f div(float scalar) {return (Vector2f) super.div(scalar);}	
	public Vector2f div(float scalar, Vector2f dest) {return (Vector2f) super.div(scalar, dest);}	
	public Vector2f div(float x, float y) {return (Vector2f) super.div(x, y);}
	public Vector2f div(float x, float y, Vector2f dest) {return (Vector2f) super.div(x, y, dest);}	
	public Vector2f mul(Matrix2fc mat) {return (Vector2f) super.mul(mat);}	
	public Vector2f mul(Matrix2fc mat, Vector2f dest) {return (Vector2f) super.mul(mat, dest);}	
	public Vector2f mul(Matrix2dc mat) {return (Vector2f) super.mul(mat);}	
	public Vector2f mul(Matrix2dc mat, Vector2f dest) {return (Vector2f) super.mul(mat, dest);}	
	public Vector2f mulTranspose(Matrix2fc mat) {return (Vector2f) super.mulTranspose(mat);}
	public Vector2f mulTranspose(Matrix2fc mat, Vector2f dest) {return (Vector2f) (Vector2f) super.mulTranspose(mat, dest);}
	public Vector2f mulPosition(Matrix3x2fc mat) {return (Vector2f) super.mulPosition(mat);}	
	public Vector2f mulPosition(Matrix3x2fc mat, Vector2f dest) {return (Vector2f) super.mulPosition(mat, dest);}	
	public Vector2f mulDirection(Matrix3x2fc mat) {return (Vector2f) super.mulDirection(mat);}
	public Vector2f mulDirection(Matrix3x2fc mat, Vector2f dest) {return (Vector2f) super.mulDirection(mat, dest);}	
	public Vector2f lerp(Vector2fc other, float t) {return (Vector2f) super.lerp(other, t);}	
	public Vector2f lerp(Vector2fc other, float t, Vector2f dest) {return (Vector2f) super.lerp(other, t, dest);}	
	public Vector2f fma(Vector2fc a, Vector2fc b) {return (Vector2f) super.fma(a, b);}	
	public Vector2f fma(float a, Vector2fc b) {return (Vector2f) super.fma(a, b);}	
	public Vector2f fma(Vector2fc a, Vector2fc b, Vector2f dest) {return (Vector2f) super.fma(a, b, dest);}	
	public Vector2f fma(float a, Vector2fc b, Vector2f dest) {return (Vector2f) super.fma(a, b, dest);}	
	public Vector2f min(Vector2fc v) {return (Vector2f) super.min(v);}	
	public Vector2f min(Vector2fc v, Vector2f dest) {return (Vector2f) super.min(v, dest);}	
	public Vector2f max(Vector2fc v) {return (Vector2f) super.max(v);}	
	public Vector2f max(Vector2fc v, Vector2f dest) {return (Vector2f) super.max(v, dest);}
	public Vector2f floor() {return (Vector2f) super.floor();}	
	public Vector2f floor(Vector2f dest) {return (Vector2f) (Vector2f) super.floor(dest);}	
	public Vector2f ceil() {return (Vector2f) super.ceil();}	
	public Vector2f ceil(Vector2f dest) {return (Vector2f) super.ceil(dest);}	
	public Vector2f round() {return (Vector2f) super.round();}	
	public Vector2f round(Vector2f dest) {return (Vector2f) super.round(dest);}	
	public Vector2f absolute() {return (Vector2f) super.absolute();}	
	public Vector2f absolute(Vector2f dest) {return (Vector2f) super.absolute(dest);}
	//endregion
	
	@Override
	public Float[] getData() {
		return new Float[]{x, y, 0f};
	}
	
	@Override
	public ShaderDataType getShaderDataType() {
		return VEC3F;
	}
}

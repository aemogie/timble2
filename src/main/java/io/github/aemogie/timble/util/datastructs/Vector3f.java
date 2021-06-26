package io.github.aemogie.timble.util.datastructs;

import io.github.aemogie.timble.renderer.components.vertextypes.AbstractVertex.VertexAttribute;
import io.github.aemogie.timble.shaders.Shader.ShaderDataType;
import org.joml.*;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import static io.github.aemogie.timble.shaders.Shader.ShaderDataType.VEC3F;

public class Vector3f extends org.joml.Vector3f implements VertexAttribute {
	
	//region Casting stuff
	public Vector3f() {}
	public Vector3f(float d) {super(d);}
	public Vector3f(float x, float y, float z) {super(x, y, z);}
	public Vector3f(Vector3fc v) {super(v);}
	public Vector3f(Vector3ic v) {super(v);}
	public Vector3f(Vector2fc v, float z) {super(v, z);}
	public Vector3f(Vector2ic v, float z) {super(v, z);}
	public Vector3f(Vector3f v) {super(v);}
	public Vector3f(float[] xyz) {super(xyz);}
	public Vector3f(ByteBuffer buffer) {super(buffer);}
	public Vector3f(int index, ByteBuffer buffer) {super(index, buffer);}
	public Vector3f(FloatBuffer buffer) {super(buffer);}
	public Vector3f(int index, FloatBuffer buffer) {super(index, buffer);}
	public Vector3f set(Vector3fc v) {return (Vector3f) super.set(v);}
	public Vector3f set(Vector3dc v) {return (Vector3f) super.set(v);}
	public Vector3f set(Vector3ic v) {return (Vector3f) super.set(v);}
	public Vector3f set(Vector2fc v, float z) {return (Vector3f) super.set(v, z);}
	public Vector3f set(Vector2dc v, float z) {return (Vector3f) super.set(v, z);}
	public Vector3f set(Vector2ic v, float z) {return (Vector3f) super.set(v, z);}
	public Vector3f set(float d) {return (Vector3f) super.set(d);}
	public Vector3f set(float x, float y, float z) {return (Vector3f) super.set(x, y, z);}
	public Vector3f set(double d) {return (Vector3f) super.set(d);}
	public Vector3f set(double x, double y, double z) {return (Vector3f) super.set(x, y, z);}
	public Vector3f set(float[] xyz) {return (Vector3f) super.set(xyz);}
	public Vector3f set(ByteBuffer buffer) {return (Vector3f) super.set(buffer);}
	public Vector3f set(int index, ByteBuffer buffer) {return (Vector3f) super.set(index, buffer);}
	public Vector3f set(FloatBuffer buffer) {return (Vector3f) super.set(buffer);}
	public Vector3f set(int index, FloatBuffer buffer) {return (Vector3f) super.set(index, buffer);}
	public Vector3f setFromAddress(long address) {return (Vector3f) super.setFromAddress(address);}
	public Vector3f setComponent(int component, float value) throws IllegalArgumentException {return (Vector3f) super.setComponent(component, value);}
	public Vector3f sub(Vector3fc v) {return (Vector3f) super.sub(v);}
	public Vector3f sub(Vector3fc v, Vector3f dest) {return (Vector3f) super.sub(v, dest);}
	public Vector3f sub(float x, float y, float z) {return (Vector3f) super.sub(x, y, z);}
	public Vector3f sub(float x, float y, float z, Vector3f dest) {return (Vector3f) super.sub(x, y, z, dest);}
	public Vector3f add(Vector3fc v) {return (Vector3f) super.add(v);}
	public Vector3f add(Vector3fc v, Vector3f dest) {return (Vector3f) super.add(v, dest);}
	public Vector3f add(float x, float y, float z) {return (Vector3f) super.add(x, y, z);}
	public Vector3f add(float x, float y, float z, Vector3f dest) {return (Vector3f) super.add(x, y, z, dest);}
	public Vector3f fma(Vector3fc a, Vector3fc b) {return (Vector3f) super.fma(a, b);}
	public Vector3f fma(float a, Vector3fc b) {return (Vector3f) super.fma(a, b);}
	public Vector3f fma(Vector3fc a, Vector3fc b, Vector3f dest) {return (Vector3f) super.fma(a, b, dest);}
	public Vector3f fma(float a, Vector3fc b, Vector3f dest) {return (Vector3f) super.fma(a, b, dest);}
	public Vector3f mulAdd(Vector3fc a, Vector3fc b) {return (Vector3f) super.mulAdd(a, b);}
	public Vector3f mulAdd(float a, Vector3fc b) {return (Vector3f) super.mulAdd(a, b);}
	public Vector3f mulAdd(Vector3fc a, Vector3fc b, Vector3f dest) {return (Vector3f) super.mulAdd(a, b, dest);}
	public Vector3f mulAdd(float a, Vector3fc b, Vector3f dest) {return (Vector3f) super.mulAdd(a, b, dest);}
	public Vector3f mul(Vector3fc v) {return (Vector3f) super.mul(v);}
	public Vector3f mul(Vector3fc v, Vector3f dest) {return (Vector3f) super.mul(v, dest);}
	public Vector3f div(Vector3fc v) {return (Vector3f) super.div(v);}
	public Vector3f div(Vector3fc v, Vector3f dest) {return (Vector3f) super.div(v, dest);}
	public Vector3f mulProject(Matrix4fc mat, Vector3f dest) {return (Vector3f) super.mulProject(mat, dest);}
	public Vector3f mulProject(Matrix4fc mat, float w, Vector3f dest) {return (Vector3f) super.mulProject(mat, w, dest);}
	public Vector3f mulProject(Matrix4fc mat) {return (Vector3f) super.mulProject(mat);}
	public Vector3f mul(Matrix3fc mat) {return (Vector3f) super.mul(mat);}
	public Vector3f mul(Matrix3fc mat, Vector3f dest) {return (Vector3f) super.mul(mat, dest);}
	public Vector3f mul(Matrix3dc mat) {return (Vector3f) super.mul(mat);}
	public Vector3f mul(Matrix3dc mat, Vector3f dest) {return (Vector3f) super.mul(mat, dest);}
	public Vector3f mul(Matrix3x2fc mat) {return (Vector3f) super.mul(mat);}
	public Vector3f mul(Matrix3x2fc mat, Vector3f dest) {return (Vector3f) super.mul(mat, dest);}
	public Vector3f mulTranspose(Matrix3fc mat) {return (Vector3f) super.mulTranspose(mat);}
	public Vector3f mulTranspose(Matrix3fc mat, Vector3f dest) {return (Vector3f) super.mulTranspose(mat, dest);}
	public Vector3f mulPosition(Matrix4fc mat) {return (Vector3f) super.mulPosition(mat);}
	public Vector3f mulPosition(Matrix4x3fc mat) {return (Vector3f) super.mulPosition(mat);}
	public Vector3f mulPosition(Matrix4fc mat, Vector3f dest) {return (Vector3f) super.mulPosition(mat, dest);}
	public Vector3f mulPosition(Matrix4x3fc mat, Vector3f dest) {return (Vector3f) super.mulPosition(mat, dest);}
	public Vector3f mulTransposePosition(Matrix4fc mat) {return (Vector3f) super.mulTransposePosition(mat);}
	public Vector3f mulTransposePosition(Matrix4fc mat, Vector3f dest) {return (Vector3f) super.mulTransposePosition(mat, dest);}
	public Vector3f mulDirection(Matrix4dc mat) {return (Vector3f) super.mulDirection(mat);}
	public Vector3f mulDirection(Matrix4fc mat) {return (Vector3f) super.mulDirection(mat);}
	public Vector3f mulDirection(Matrix4x3fc mat) {return (Vector3f) super.mulDirection(mat);}
	public Vector3f mulDirection(Matrix4dc mat, Vector3f dest) {return (Vector3f) super.mulDirection(mat, dest);}
	public Vector3f mulDirection(Matrix4fc mat, Vector3f dest) {return (Vector3f) super.mulDirection(mat, dest);}
	public Vector3f mulDirection(Matrix4x3fc mat, Vector3f dest) {return (Vector3f) super.mulDirection(mat, dest);}
	public Vector3f mulTransposeDirection(Matrix4fc mat) {return (Vector3f) super.mulTransposeDirection(mat);}
	public Vector3f mulTransposeDirection(Matrix4fc mat, Vector3f dest) {return (Vector3f) super.mulTransposeDirection(mat, dest);}
	public Vector3f mul(float scalar) {return (Vector3f) super.mul(scalar);}
	public Vector3f mul(float scalar, Vector3f dest) {return (Vector3f) super.mul(scalar, dest);}
	public Vector3f mul(float x, float y, float z) {return (Vector3f) super.mul(x, y, z);}
	public Vector3f mul(float x, float y, float z, Vector3f dest) {return (Vector3f) super.mul(x, y, z, dest);}
	public Vector3f div(float scalar) {return (Vector3f) super.div(scalar);}
	public Vector3f div(float scalar, Vector3f dest) {return (Vector3f) super.div(scalar, dest);}
	public Vector3f div(float x, float y, float z) {return (Vector3f) super.div(x, y, z);}
	public Vector3f div(float x, float y, float z, Vector3f dest) {return (Vector3f) (Vector3f) (Vector3f) (Vector3f) (Vector3f) super.div(x, y, z, dest);}
	public Vector3f rotate(Quaternionfc quat) {return (Vector3f) super.rotate(quat);}
	public Vector3f rotate(Quaternionfc quat, Vector3f dest) {return (Vector3f) super.rotate(quat, dest);}
	public Vector3f rotateAxis(float angle, float x, float y, float z) {return (Vector3f) (Vector3f) super.rotateAxis(angle, x, y, z);}
	public Vector3f rotateAxis(float angle, float aX, float aY, float aZ, Vector3f dest) {return (Vector3f) (Vector3f) super.rotateAxis(angle, aX, aY, aZ, dest);}
	public Vector3f rotateX(float angle) {return (Vector3f) super.rotateX(angle);}
	public Vector3f rotateX(float angle, Vector3f dest) {return (Vector3f) (Vector3f) super.rotateX(angle, dest);}
	public Vector3f rotateY(float angle) {return (Vector3f) super.rotateY(angle);}
	public Vector3f rotateY(float angle, Vector3f dest) {return (Vector3f) super.rotateY(angle, dest);}
	public Vector3f rotateZ(float angle) {return (Vector3f) super.rotateZ(angle);}
	public Vector3f rotateZ(float angle, Vector3f dest) {return (Vector3f) super.rotateZ(angle, dest);}
	public Vector3f normalize() {return (Vector3f) super.normalize();}
	public Vector3f normalize(Vector3f dest) {return (Vector3f) super.normalize(dest);}
	public Vector3f normalize(float length) {return (Vector3f) super.normalize(length);}
	public Vector3f normalize(float length, Vector3f dest) {return (Vector3f) super.normalize(length, dest);}
	public Vector3f cross(Vector3fc v) {return (Vector3f) super.cross(v);}
	public Vector3f cross(float x, float y, float z) {return (Vector3f) super.cross(x, y, z);}
	public Vector3f cross(Vector3fc v, Vector3f dest) {return (Vector3f) (Vector3f) (Vector3f) super.cross(v, dest);}
	public Vector3f cross(float x, float y, float z, Vector3f dest) {return (Vector3f) (Vector3f) super.cross(x, y, z, dest);}
	public Vector3f min(Vector3fc v) {return (Vector3f) super.min(v);}
	public Vector3f min(Vector3fc v, Vector3f dest) {return (Vector3f) super.min(v, dest);}
	public Vector3f max(Vector3fc v) {return (Vector3f) super.max(v);}
	public Vector3f max(Vector3fc v, Vector3f dest) {return (Vector3f) super.max(v, dest);}
	public Vector3f zero() {return (Vector3f) super.zero();}
	public Vector3f negate() {return (Vector3f) (Vector3f) super.negate();}
	public Vector3f negate(Vector3f dest) {return (Vector3f) (Vector3f) super.negate(dest);}
	public Vector3f absolute() {return (Vector3f) super.absolute();}
	public Vector3f absolute(Vector3f dest) {return (Vector3f) super.absolute(dest);}
	public Vector3f reflect(Vector3fc normal) {return (Vector3f) super.reflect(normal);}
	public Vector3f reflect(float x, float y, float z) {return (Vector3f) super.reflect(x, y, z);}
	public Vector3f reflect(Vector3fc normal, Vector3f dest) {return (Vector3f) super.reflect(normal, dest);}
	public Vector3f reflect(float x, float y, float z, Vector3f dest) {return (Vector3f) super.reflect(x, y, z, dest);}
	public Vector3f half(Vector3fc other) {return (Vector3f) super.half(other);}
	public Vector3f half(float x, float y, float z) {return (Vector3f) super.half(x, y, z);}
	public Vector3f half(Vector3fc other, Vector3f dest) {return (Vector3f) super.half(other, dest);}
	public Vector3f half(float x, float y, float z, Vector3f dest) {return (Vector3f) super.half(x, y, z, dest);}
	public Vector3f smoothStep(Vector3fc v, float t, Vector3f dest) {return (Vector3f) super.smoothStep(v, t, dest);}
	public Vector3f hermite(Vector3fc t0, Vector3fc v1, Vector3fc t1, float t, Vector3f dest) {return (Vector3f) super.hermite(t0, v1, t1, t, dest);}
	public Vector3f lerp(Vector3fc other, float t) {return (Vector3f) super.lerp(other, t);}
	public Vector3f lerp(Vector3fc other, float t, Vector3f dest) {return (Vector3f) super.lerp(other, t, dest);}
	public Vector3f get(Vector3f dest) {return (Vector3f) super.get(dest);}
	public Vector3f orthogonalize(Vector3fc v, Vector3f dest) {return (Vector3f) super.orthogonalize(v, dest);}
	public Vector3f orthogonalize(Vector3fc v) {return (Vector3f) super.orthogonalize(v);}
	public Vector3f orthogonalizeUnit(Vector3fc v, Vector3f dest) {return (Vector3f) super.orthogonalizeUnit(v, dest);}
	public Vector3f orthogonalizeUnit(Vector3fc v) {return (Vector3f) super.orthogonalizeUnit(v);}
	public Vector3f floor() {return (Vector3f) super.floor();}
	public Vector3f floor(Vector3f dest) {return (Vector3f) super.floor(dest);}
	public Vector3f ceil() {return (Vector3f) super.ceil();}
	public Vector3f ceil(Vector3f dest) {return (Vector3f) super.ceil(dest);}
	public Vector3f round() {return (Vector3f) (Vector3f) super.round();}
	public Vector3f round(Vector3f dest) {return (Vector3f) super.round(dest);}
	//endregion
	
	public Vector3f(Vector2fc v) {
		super(v, 0);
	}
	
	@Override
	public Float[] getData() {return new Float[]{x, y, z};}
	
	@Override
	public ShaderDataType getShaderDataType() {return VEC3F;}
}

package io.github.aemogie.timble.timble;

import io.github.aemogie.timble.util.datastructs.Vector2f;
import io.github.aemogie.timble.util.datastructs.Vector3f;
import org.joml.Matrix4f;

public class Camera {
	public Vector3f position;
	private CameraMode cameraMode;
	private transient Matrix4f projectionMatrix, viewMatrix;
	private transient org.joml.Vector2f projectionSize;
	
	public void init(CameraMode cameraMode, Vector3f position) {
		this.cameraMode = cameraMode;
		this.position = position;
		this.projectionMatrix = new Matrix4f();
		this.viewMatrix = new Matrix4f();
		this.projectionSize = new Vector2f(32.0f * 40.0f, 32.0f * 21.0f);
		adjustProjection();
	}
	
	public void adjustProjection() {
		projectionMatrix.identity();
		switch (cameraMode) {
			case ORTHOGRAPHIC -> projectionMatrix.ortho(0.0f, projectionSize.x, 0.0f, projectionSize.y, 0.0f, 100f);
			case PERSPECTIVE -> projectionMatrix.setPerspective(90, 16f / 9, 0.5f, Float.POSITIVE_INFINITY);
		}
	}
	
	public Matrix4f getViewMatrix() {
		Vector2f newPosition = new Vector2f(position.x, position.y);//.add(new Vector2f(32 * (1/zoom)));
		Vector3f cameraFront = new Vector3f(0, 1, -1);
		Vector3f cameraUp = new Vector3f(0, 1, 0);
		Vector3f center = new Vector3f(newPosition, -1);
		center.add(cameraFront);
		this.viewMatrix.identity();
		this.viewMatrix = this.viewMatrix.lookAt(
				new Vector3f(center.x, center.y, 20),//.mul(1,1,zoom),
				center,
				cameraUp
		);
		return this.viewMatrix;
	}
	
	public Matrix4f getProjectionMatrix() {
		return projectionMatrix;
	}
	
	public enum CameraMode {
		ORTHOGRAPHIC, PERSPECTIVE;
	}
}

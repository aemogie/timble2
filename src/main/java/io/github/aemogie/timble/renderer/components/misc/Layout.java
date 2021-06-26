package io.github.aemogie.timble.renderer.components.misc;

import io.github.aemogie.timble.shaders.Shader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Layout {
	public int stride;
	public int strideSize;
	public List<Attribute> attribs = new ArrayList<>();
	private int offset;
	
	public void addAttribute(final CharSequence NAME, final Shader.ShaderDataType DATA_TYPE) {
		Attribute attrib = new Attribute(NAME, DATA_TYPE, offset);
		stride += attrib.DATA_TYPE.COUNT;
		strideSize += attrib.DATA_TYPE.SIZE;
		attribs.add(attrib);
		offset += attrib.DATA_TYPE.SIZE;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "[" + attribs.stream().map(Attribute::toString).collect(Collectors.joining(", ")) + "]";
	}
	
	@SuppressWarnings("ClassCanBeRecord")
	public static final class Attribute {
		private final CharSequence NAME;
		private final Shader.ShaderDataType DATA_TYPE;
		private final int OFFSET;
		
		private Attribute(CharSequence NAME, Shader.ShaderDataType DATA_TYPE, int OFFSET) {
			this.NAME = NAME;
			this.DATA_TYPE = DATA_TYPE;
			this.OFFSET = OFFSET;
		}
		
		public CharSequence NAME() {
			return NAME;
		}
		
		public Shader.ShaderDataType DATA_TYPE() {
			return DATA_TYPE;
		}
		
		public int OFFSET() {
			return OFFSET;
		}
		
		public boolean equals(Object obj) {
			if (obj == this) return true;
			if (obj == null || obj.getClass() != this.getClass()) return false;
			var that = (Attribute) obj;
			return Objects.equals(this.NAME, that.NAME) && Objects.equals(this.DATA_TYPE, that.DATA_TYPE) && this.OFFSET == that.OFFSET;
		}
		
		public int hashCode() {
			return Objects.hash(NAME, DATA_TYPE, OFFSET);
		}
		
		@Override
		public String toString() {
			return "(" + NAME + " : " + DATA_TYPE + " : " + OFFSET + ")";
		}
	}
}

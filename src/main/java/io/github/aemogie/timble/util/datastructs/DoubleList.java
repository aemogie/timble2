package io.github.aemogie.timble.util.datastructs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class DoubleList<T, V> implements Iterable<T> {
	public final int MAX_SIZE;
	private final List<T> DATA;
	private boolean hasSpace = true;
	
	public DoubleList(final int MAX_SIZE) {
		this.MAX_SIZE = MAX_SIZE;
		DATA = new ArrayList<>(this.MAX_SIZE);
	}
	
	public boolean add(T primitive) {
		if (!hasSpace) return false;
		hasSpace = DATA.size() < MAX_SIZE;
		return DATA.add(primitive);
	}
	
	public boolean remove(T primitive) {
		boolean success = DATA.remove(primitive);
		if (success) hasSpace = true;
		return success;
	}
	
	public List<V> get() {
		return DATA.stream().flatMap(this::flatMapFunc).collect(Collectors.toList());
	}
	
	protected abstract Stream<V> flatMapFunc(T t);
	
	@Override
	public Iterator<T> iterator() {
		return DATA.iterator();
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [" + get().stream().map(v -> v + "").collect(Collectors.joining(", ")) + "]";
	}
}

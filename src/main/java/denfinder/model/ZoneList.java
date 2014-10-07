package denfinder.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * List of all zone objects
 * @author latch
 *
 */
public class ZoneList implements List<Zone> {
	//zones in this list
	private List<Zone> zones;

	//create new list
	public ZoneList() {
		this.zones = new ArrayList<Zone>();
	}
	

	@Override
	public boolean add(Zone e) {
		return zones.add(e);
	}

	@Override
	public void add(int index, Zone element) {
		zones.add(index, element);
		
	}

	@Override
	public boolean addAll(Collection<? extends Zone> c) {
		return zones.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Zone> c) {
		return zones.addAll(index, c);
	}

	@Override
	public void clear() {
		zones.clear();
		
	}

	@Override
	public boolean contains(Object o) {
		return zones.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return zones.containsAll(c);
	}

	@Override
	public Zone get(int index) {
		return zones.get(index);
	}

	@Override
	public int indexOf(Object o) {
		return zones.indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		return zones.isEmpty();
	}

	@Override
	public Iterator<Zone> iterator() {
		return zones.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		return zones.lastIndexOf(o);
	}

	@Override
	public ListIterator<Zone> listIterator() {
		return zones.listIterator();
	}

	@Override
	public ListIterator<Zone> listIterator(int index) {
		return zones.listIterator(index);
	}

	@Override
	public boolean remove(Object o) {
		return zones.remove(o);
	}

	@Override
	public Zone remove(int index) {
		return zones.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return zones.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return zones.retainAll(c);
	}

	@Override
	public Zone set(int index, Zone element) {
		return zones.set(index, element);
	}

	@Override
	public int size() {
		return zones.size();
	}

	@Override
	public List<Zone> subList(int fromIndex, int toIndex) {
		return zones.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return zones.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return zones.toArray(a);
	}
	
}

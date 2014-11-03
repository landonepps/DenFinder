/**
 * 
 */
package denfinder.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author PINTOR
 *
 */
public class SchoolList implements List<School> {

	private List<School> schoolList;
	
	public SchoolList() {
		this.schoolList = new ArrayList<School>();
	}
	
	@Override
	public boolean add(School e) {
		return schoolList.add(e);
	}
	
	
	@Override
	public void add(int index, School element) {
		schoolList.add(index, element);
		
	}
	
	@Override
	public boolean addAll(Collection<? extends School> c) {
		return schoolList.addAll(c);
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends School> c) {
		return schoolList.addAll(index, c);
	}
	
	@Override
	public boolean contains(Object o) {
		return schoolList.contains(o);
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		return schoolList.containsAll(c);
	}
	
	@Override
	public void clear() {
		schoolList.clear();
		
	}
	
	@Override
	public School get(int index) {
		return schoolList.get(index);
	}
	
	@Override
	public int indexOf(Object o) {
		return schoolList.indexOf(o);
	}
	
	@Override
	public boolean isEmpty() {
		return schoolList.isEmpty();
	}
	
	@Override
	public Iterator<School> iterator() {
		return schoolList.iterator();
	}
	
	@Override
	public int lastIndexOf(Object o) {
		return schoolList.lastIndexOf(o);
	}

	@Override
	public ListIterator<School> listIterator() {
		return schoolList.listIterator();
	}

	@Override
	public ListIterator<School> listIterator(int index) {
		return schoolList.listIterator(index);
	}
	
	@Override
	public School remove(int index) {
	    return schoolList.remove(index);
	}
	
	@Override
	public boolean remove(Object o) {
		return schoolList.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return schoolList.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return schoolList.retainAll(c);
	}
	
	@Override
	public School set(int index, School element) {
		return schoolList.set(index, element);
	}
	
	@Override
	public int size() {
		return schoolList.size();
	}

	@Override
	public List<School> subList(int fromIndex, int toIndex) {
		return schoolList.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return schoolList.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return schoolList.toArray(a);
	}

}

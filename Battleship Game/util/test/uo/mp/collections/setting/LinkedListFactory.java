package uo.mp.collections.setting;


import uo.mp.collections.List;
import uo.mp.collections.LinkedList;

public class LinkedListFactory<T> implements ListFactory<T> {

	@Override
	public List<T> newList() {
		return new LinkedList<T>();
	}

}

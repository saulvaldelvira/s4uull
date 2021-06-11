package uo.mp.collections.setting;

import uo.mp.collections.List;
import uo.mp.collections.ArrayList;

public class ArrayListFactory<T> implements ListFactory<T> {

	@Override
	public List<T> newList() {
		return new ArrayList<T>();
	}

}

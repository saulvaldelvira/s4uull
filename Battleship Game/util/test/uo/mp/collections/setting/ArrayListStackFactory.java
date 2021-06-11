package uo.mp.collections.setting;

import uo.mp.collections.stack.AbstractStack;
import uo.mp.collections.stack.ArrayListStack;

public class ArrayListStackFactory<T> implements StackFactory<T> {

	@Override
	public AbstractStack<T> newStack() {
		return new ArrayListStack<T>();
	}

}

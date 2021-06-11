package uo.mp.collections.setting;

import uo.mp.collections.stack.AbstractStack;
import uo.mp.collections.stack.LinkedListStack;

public class LinkedListStackFactory<T> implements StackFactory<T> {

	@Override
	public AbstractStack<T> newStack() {
		return new LinkedListStack<T>();
	}

}

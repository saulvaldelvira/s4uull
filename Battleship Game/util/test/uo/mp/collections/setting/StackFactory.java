package uo.mp.collections.setting;

import uo.mp.collections.stack.AbstractStack;

public interface StackFactory<T> {

	AbstractStack<T> newStack();
}

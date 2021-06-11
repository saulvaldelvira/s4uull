/**
 * 
 */
package uo.mp.collections.stack;

import uo.mp.collections.ArrayList;

/** 
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @param <T>
 * @verison 28/03/2021
 */
public class ArrayListStack<T> extends AbstractStack<T>{

	public ArrayListStack() {
		list = new ArrayList<T>();
	}
}

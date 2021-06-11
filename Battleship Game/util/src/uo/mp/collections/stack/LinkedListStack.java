/**
 * 
 */
package uo.mp.collections.stack;

import uo.mp.collections.LinkedList;

/** 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @verison 28/03/2021
 */
public class LinkedListStack<T> extends AbstractStack<T>{

	public LinkedListStack() {
		list = new LinkedList<T>();
	}
}

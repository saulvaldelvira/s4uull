package uo.mp.collections.queue;

import uo.mp.collections.LinkedList;

/** 
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @verison 28/03/2021
 */
public class LinkedListQueue<T> extends AbstractQueue<T> {
	
	public LinkedListQueue() {
		list = new LinkedList<T>();
	}
	
}

package uo.mp.collections.queue;

import uo.mp.collections.ArrayList;

/** 
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @verison 28/03/2021
 */
public class ArrayListQueue<T> extends AbstractQueue<T> {

	public ArrayListQueue() {
		list = new ArrayList<T>();
	}
	
}

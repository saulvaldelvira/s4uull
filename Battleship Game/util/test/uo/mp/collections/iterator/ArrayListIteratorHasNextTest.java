/**
 * 
 */
package uo.mp.collections.iterator;



import org.junit.Before;

import uo.mp.collections.ArrayList;
/** 
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @version 28/03/2021
 */
public class ArrayListIteratorHasNextTest<T> extends ListIteratorHasNextTest<T> {

	@Before
	public void setUp() {
		list= new ArrayList<String>();
	}

}

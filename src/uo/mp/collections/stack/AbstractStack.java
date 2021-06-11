/**
 * 
 */
package uo.mp.collections.stack;

import uo.mp.checks.StateChecks;
import uo.mp.collections.List;

/** 
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @verison 28/03/2021
 */
public class AbstractStack<T> implements Stack<T>{

	protected List<T> list;
	
	/**
	 * A�ade un elemento dado en la parte superior de la pila 
	 * @param element, de tipo Object 
	 */
	public void push(T element) {
		list.add(element);
	}
	
	/**
	 * Elimina y devuelve el elemento en la parte superior de la pila
	 * @return el objeto, de tipo Object  
	 */
	public Object pop() {
		return list.remove(list.size()-1);
	}
	
	/**
	 * 	Devuelve el elemento en la parte superior de la pila
	 * @return el objeto, de tipo Object  
	 */
	public Object peek() {
		StateChecks.isTrue(!isEmpty());
		return list.get(list.size()-1);
	}
	
	/**
	 * Indica si la pila etsa vacia o no 
	 * @return true o false, de tipo boolean 
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Devuelve el tama�o de la pila 
	 * @return el tama�o, de tipo int 
	 */
	public int size() {
		return list.size();
	}
}

package uo.mp.collections.queue;

import uo.mp.checks.StateChecks;
import uo.mp.collections.List;

/** 
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @verison 28/03/2021
 */
public class AbstractQueue<T> implements Queue<T> {
	
	protected List<T> list;

	/**
	 * A�ade un elemento dado al final de la cola 
	 * @param element, de tipo Object 
	 */
	@Override
	public void enqueue(T element) {
		list.add(element);		
	}

	/**
	 * Elimina el primer elemento de la cola
	 * @return el elemento eliminado, de tipo Object 
	 */
	@Override
	public Object dequeue() {
		return list.remove(0);
	}

	/**
	 * Devuelve el primer elemento en la cola
	 * @return el elemento, de tipo Object 
	 */
	@Override
	public Object peek() {
		StateChecks.isTrue(!isEmpty());
		return list.get(0);
	}
	
	/**
	 * Devuelve true si la lista est� vac�a
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Devuelve el tama�o de la cola
	 * @return el tama�o, de tipo int
	 */
	@Override
	public int size() {
		return list.size();
	}

	
	
	
}

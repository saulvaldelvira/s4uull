/**
 * 
 */
package uo.mp.collections.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.setting.Settings;



/**
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @version 29/03/2021
 */
public class DequeueTest {

	AbstractQueue<String> queue;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		queue=Settings.queueFactory.newQueue();
	}
	
	/*
	 * Casos 
	 * 1-Lista vac�a->Lanza IndexOutOfBoundsException
	 * 2-Lista con un elemento->Lo elimina y la lista queda vac�a
	 * 3-Lista con varios elementos->Lo elimina y reduce en uno el tama�o 
	 */
	
	/**
	 * GIVEN una cola vac�a
	 * WHEN se llama al m�todo dequeue
	 * THEN lanza una IndexOutOfBoundsException
	 */
	@Test
	(expected= IndexOutOfBoundsException.class)
	public void emptyTest() {
		queue.dequeue();
	}
	
	/**
	 * GIVEN una cola con un solo elemento 
	 * WHEN se llama al m�todo dequeue
	 * THEN lo elimina y la lista queda vac�a
	 */
	@Test
	public void oneElementTest() {
		queue.enqueue("Hola");
		queue.dequeue();
		assertEquals(0, queue.size());
	}

	/**
	 * GIVEN una cola con un varios elementos
	 * WHEN se llama al m�todo dequeue
	 * THEN elimina el primer elemento y reduce en uno el tama�o 
	 */
	@Test
	public void multipleElementTest() {
		queue.enqueue("abra");
		queue.enqueue("kadabra");
		queue.dequeue();
		assertEquals(1, queue.size());
		assertEquals("kadabra", queue.peek());
	}
	
}

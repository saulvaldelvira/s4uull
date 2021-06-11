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
public class EnqueueTest<T> {

	AbstractQueue<String> queue;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		queue=Settings.queueFactory.newQueue();
	}
	
	/*
	 * Casos 
	 * 1-Lista vacia->A�ade el elemento 
	 * 2-Lista con elementos->A�ade el elemento 
	 */
	
	/**
	 * GIVEN una cola vacia
	 * WHEN se mete uno nuevo 
	 * THEN el tama�o aumenta en 1
	 */
	@Test
	public void emptyListTest() {
		queue.enqueue("hola");
		assertEquals(1, queue.size());
		assertEquals("hola", queue.peek());
	}
	
	/**
	 * GIVEN una cola con elementos
	 * WHEN se mete uno nuevo 
	 * THEN mete el elementos en la ultima posicion de la cola
	 */
	@Test
	public void elementsInListTest() {
		queue.enqueue("hola");
		queue.enqueue("que");
		queue.enqueue("tal");
		
		assertEquals(3, queue.size());
		assertEquals("hola", queue.peek());
		queue.dequeue();
		assertEquals("que", queue.peek());
		queue.dequeue();
		assertEquals("tal", queue.peek());
	}

}

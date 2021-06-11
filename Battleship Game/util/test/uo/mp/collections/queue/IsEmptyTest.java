package uo.mp.collections.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.setting.Settings;
/**
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @version 29/03/2021
 */
public class IsEmptyTest {

AbstractQueue<String> queue;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		queue=Settings.queueFactory.newQueue();
	}
	
	/*
	 * casos 
	 * 1-Cola vac�a. Devuelve true
	 * 2-Cola con elementos. Devuelve false
	 */
	
	/**
	 * GIVEN una cola vacia 
	 * WHEN se llama al metodo isEmpty
	 * THEN devuelve true
	 */
	@Test
	public void emptyTest() {
		assertTrue(queue.isEmpty());
	}
	
	/**
	 * GIVEN una cola con elementos 
	 * WHEN se llama al metodo isEmpty
	 * THEN devuelve false
	 */
	@Test
	public void queueWithElementsTest() {
		queue.enqueue("H");
		assertFalse(queue.isEmpty());
	}

}

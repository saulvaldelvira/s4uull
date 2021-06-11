package uo.mp.collections.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.setting.Settings;


/**
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @version 29/03/2021
 */
public class SizeTest {

AbstractQueue<String> queue;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		queue=Settings.queueFactory.newQueue();
	}
	
	/*
	 * casos
	 * 1-Cola vac�a->Devuelve 0
	 * 2-Cola con elementos->Devuelve el numero de elementos
	 */
	
	/**
	 * GIVEN una cola vac�a
	 * WHEN se llama al m�todo size()
	 * THEN devuelve 0
	 */
	@Test
	public void emptyTest() {
		assertEquals(0, queue.size());
	}

	/**
	 * GIVEN una cola con elementos
	 * WHEN se llama al m�todo size()
	 * THEN devuelve el n�mero de elementos
	 */
	@Test
	public void elementsTest() {
		queue.enqueue("hey");
		queue.enqueue("jeje");
		assertEquals(2, queue.size());
	}
	
}

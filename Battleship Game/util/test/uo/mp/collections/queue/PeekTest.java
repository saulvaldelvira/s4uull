package uo.mp.collections.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.setting.Settings;


/**
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @version 29/03/2021
 */
public class PeekTest {

AbstractQueue<String> queue;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		queue=Settings.queueFactory.newQueue();
	}
	
	/*
	 * casos
	 * 1-Cola vac�a->Lanza una IllegalStateException
	 * 2-Cola con un elemento->Devuelve ese elemento
	 * 3-Cola con varios elementos->Devuelve el primero de la cola
	 */
	
	/**
	 * GIVEN una cola vac�a 
	 * WHEN se llama al m�todo peak()
	 * THEN lanza una IllegalStateException
	 */
	@Test
	(expected=IllegalStateException.class)
	public void emptyTest() {
		queue.peek();
	}
	
	/**
	 * GIVEN una cola con un solo elemento 
	 * WHEN se llama al m�todo peak()
	 * THEN devuelve ese elemento 
	 */
	@Test
	public void oneElementTest() {
		queue.enqueue("Sa�l");
		assertEquals("Sa�l", queue.peek());
	}
	
	/**
	 * GIVEN una cola con varios elementos
	 * WHEN se llama al m�todo peak()
	 * THEN devuelve el primer elemento de la cola
	 */
	@Test
	public void variousElementsTest() {
		queue.enqueue("Sa�l");
		queue.enqueue("Helado");
		queue.enqueue("azufre$");
		
		assertEquals("Sa�l", queue.peek());
	}

}

package uo.mp.collections.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.setting.Settings;
/**
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @version 29/03/2021
 */
public class PushTest {

AbstractStack<String> stack;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		stack=Settings.stackFactory.newStack();
	}
	
	/*
	 * Casos 
	 * 1-Pila vacia->A�ade el elemento 
	 * 2-Pila con elementos->A�ade el elemento al principio de la pila
	 */
	
	/**
	 * GIVEN una pila vacia
	 * WHEN se mete uno nuevo 
	 * THEN el tama�o aumenta en 1
	 */
	@Test
	public void emptyStackTest() {
		stack.push("hola");
		assertEquals(1, stack.size());
		assertEquals("hola", stack.peek());
	}

	/**
	 * GIVEN una pila con elemntos
	 * WHEN se mete uno nuevo 
	 * THEN el tama�o aumenta en 1 y se a�ade el elemento al principio de la pila
	 */
	@Test
	public void notEmptyStackTest() {
		stack.push("hola");
		stack.push("Que");
		stack.push("tal");
		
		assertEquals(3, stack.size());
		assertEquals("tal", stack.peek());
	}
	
}

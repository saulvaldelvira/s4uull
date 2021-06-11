package uo.mp.collections.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.setting.Settings;
/**
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @version 29/03/2021
 */
public class PopTest {

AbstractStack<String> stack;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		stack=Settings.stackFactory.newStack();
	}
	
	/*
	 * Casos 
	 * 1-Pila vac�a->Lanza IndexOutOfBoundsException
	 * 2-Pila con un elemento->Lo elimina y la lista queda vac�a
	 * 3-Pila con varios elementos->Lo elimina y reduce en uno el tama�o 
	 */
	
	/**
	 * GIVEN una pila vac�a
	 * WHEN se llama al m�todo dequeue
	 * THEN lanza una IndexOutOfBoundsException
	 */
	@Test
	(expected= IndexOutOfBoundsException.class)
	public void emptyTest() {
		stack.pop();
	}

	/**
	 * GIVEN una pila con un elemento
	 * WHEN se llama al m�todo dequeue
	 * THEN elimina ese elemento y reduce el tama�o en uno 
	 */
	@Test
	public void singleElementTest() {
		stack.push("Eliminar");
		
		assertEquals("Eliminar", stack.pop());
		assertEquals(0, stack.size());
	}
	
	/**
	 * GIVEN una pila con varios elementos
	 * WHEN se llama al m�todo dequeue
	 * THEN elimina el ultimo elemento a�adido y reduce en uno el tama�o
	 */
	@Test
	public void multipleElementsTest() {
		stack.push("Eliminar");
		stack.push("m�s");
		stack.push("tarde");
		
		assertEquals("tarde", stack.pop());
		assertEquals(2, stack.size());
	}
	
}

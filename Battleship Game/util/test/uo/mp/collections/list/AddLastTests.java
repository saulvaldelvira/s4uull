package uo.mp.collections.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class AddLastTests {
	
	private List<Object> list;
	private Object o1;
	private Object o2;
	private Object elementToAdd;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		o1=new Object();
		o2=new Object();
		elementToAdd= new Object();
	}

	/*
	 * Escenarios
	 * positivos
	 * 1- Add en una lista vac�a a�ade el elemento en la primera posici�n y devuelve true
	 * 2- Add en una lista con varios elementos, a�ade el elemento en la �ltima posici�n y devuelve true
	 * 3- Se puede a�adir un elemento repetido
	 * negativos 
	 * 4- Intentar a�adir un null, se lanza IllegalArgumentException
	 */
	
//	1- Add en una lista vac�a a�ade el elemento en la primera posici�n y devuelve true
	/**
	 * GIVEN una lista vac�a
	 * WHEN se llama al metodo add(Object element)
	 * THEN a�ade el elemento a la primera posicion y devuelve true 
	 */
	@Test
	public void emptyTest() {
		assertTrue(list.add(  elementToAdd));
		assertEquals(elementToAdd, list.get(0));
	}

//	2- Add en una lista con varios elementos, a�ade el elemento en la �ltima posici�n y devuelve true
	/**
	 * GIVEN una lista con varios elementos
	 * WHEN se llama al metodo add(Object element)
	 * THEN a�ade el elemento a la ultima posicion y devuelve true 
	 */
	@Test
	public void listWithElementsTest() {
		list.add(  o1);
		list.add(  o2);
		assertTrue(list.add(  elementToAdd));
		assertEquals(elementToAdd, list.get(2));
	}
	
//	3- Se puede a�adir un elemento repetido
	/**
	 * GIVEN una lista con varios elementos
	 * WHEN se llama al metodo add(Object element) con un elemento ya existente en la lista
	 * THEN a�ade el elemento a la ultima posicion y devuelve true 
	 */
	@Test
	public void addRepeatedElementTest() {
		list.add(  o1);
		list.add(  o2);
		assertTrue(list.add(  o1));
		assertEquals(o1, list.get(2));
	}
	
	/**
	 * GIVEN una lista con varios elementos
	 * WHEN se llama al metodo add(null) 
	 * THEN lanza un IllegalArgumentException
	 */
	@Test
	(expected= IllegalArgumentException.class)
	public void addNullElementTest() {
		list.add(null);
	}
}

package uo.mp.collections.iterator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import uo.mp.collections.List;

/** 
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @version 28/03/2021
 */
public class ListIteratorHasNextTest<T> {
	
	protected List<String> list;
	protected Iterator<String> iterator;

	
	/*
	 *casos
	 *1-Lista vacia, llamo a hasNext->devuelve false
	 *2-lista con un elemento llamo a hasNext->devuelve false
	 *3-Lista con varios elementos llamo a hasNext->devuelve true
	 */
	
	
//	1-Lista vacia, llamo a hasNext->devuelve false
	/**
	 * GIVEN un iterador de una lista vac�a
	 * WHEN se llama al m�todo hasNext()
	 * THEN devuelve false
	 */
	@Test
	public void EmptyList() {
		iterator = list.iterator();
		assertFalse(iterator.hasNext());
	}

//	2-lista con un elemento llamo a hasNext->devuelve false
	/**
	 * GIVEN un iterador de una lista con un solo elemento
	 * WHEN se llama al m�todo hasNext()
	 * THEN devuelve true
	 */
	@Test
	public void oneElement() {
		list.add("hahaha");
		iterator = list.iterator();
		assertTrue(iterator.hasNext());
	}
	
//	3-Lista con varios elementos llamo a hasNext->devuelve true
	/**
	 * GIVEN un iterador de una lista con varios elementos 
	 * WHEN se llama al m�todo hasNext()
	 * THEN devuelve true 
	 */
	@Test
	public void variousElements() {
		list.add("hahaha");
		list.add("hola");
		iterator = list.iterator();
		assertTrue(iterator.hasNext());
	}
}
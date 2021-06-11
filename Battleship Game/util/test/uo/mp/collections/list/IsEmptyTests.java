package uo.mp.collections.list;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class IsEmptyTests {
	
	private List<String> list;

	/**
	 * Casos:
	 * 1 Una lista recien creada esta vac�a
	 * 2 Una lista queda vac�a despu�s de la operaci�n clear
	 * 3 Una lista con un elemento no est� vac�a
	 * 4 Una lista con m�s de un elemento no esta vac�a
	 */
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}

	/**
	 * GIVEN una lista
	 * WHEN Una lista recien creada esta vac�a
	 * THEN devuelve true
	 */
	@Test
	public void newList() {
		assertTrue(list.isEmpty());
	}
	
	/**
	 * GIVEN una lista
	 * WHEN Una lista queda vac�a despu�s de la operaci�n clear
	 * THEN devuelve true
	 */
	@Test
	public void afterClear() {
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	/**
	 * GIVEN una lista
	 * WHEN Una lista con un elemento no est� vac�a
	 * THEN devuelve false
	 */
	@Test
	public void hasElement() {
		String x1 = new String("Patata");
		list.add(x1);
		assertFalse(list.isEmpty());
	}
	
	/**
	 * GIVEN una lista
	 * WHEN Una lista con m�s de un elemento no esta vac�a
	 * THEN devuelve false
	 */
	@Test
	public void hasElements() {
		String x1 = new String("Patata");
		String x2 = new String("Aceituna");
		list.add(x1);
		list.add(x2);
		assertFalse(list.isEmpty());
	}
	
	

}

package uo.mp.collections;

import uo.mp.checks.ArgumentChecks;

public abstract class AbstractList<T> implements List<T>{

	protected int numberOfElements;

	public AbstractList() {
		super();
	}
	
	/**
	 * Devuelve el tama�o de la lista, es decir, el n�mero de elementos
	 * que almacena
	 * 
	 * @return el n�mero de elementos, de tipo int
	 */
	@Override
	public int size() {
		return numberOfElements;
	}

	/**
	 * Devuelve true si est� vac�a, es decir, si no almacena ning�n objeto 
	 * 
	 * @return truo o false, de tipo boolean 
	 */
	@Override
	public boolean isEmpty() {
		return(numberOfElements==0);
	}

	/**
	 * Devuelve true si la lista contiene al menos un objeto tal que 
	 * *ese objeto*.equals(o) sea true
	 * @param o, de tipo Object
	 * @return true o false, boolean 
	 */
	@Override
	public boolean contains(T o) {
		ArgumentChecks.isTrue(o!=null, "El objeto a buscar no puede ser null");
		return indexOf(o)!=- 1;
	}

	/**
	 * Devuelve la posicion de un objeto dado como par�metro en la lista, o -1 
	 * si no se encuentra en esta
	 * 
	 * @param o, el objeto a buscar. De tipo Object
	 */
	@Override
	public int indexOf(T o) {
		for(int i=0; i<this.size();i++) {
			if(this.get(i).equals(o)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Devuelve true si el objeto pasado como par�metro es una lista de igual tama�o
	 * y con los mismos elementos en las mismas posiciones que esta lista 
	 * 
	 * @param obj, el objeto a comparar. De tipo Object
	 * @return true o false. Boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof List))
			return false;
		@SuppressWarnings("unchecked")
		List<T> other = (List<T>) obj;
		if (numberOfElements != other.size())
			return false;
		for(int i=0; i<size(); i++) {
			if(! this.get(i).equals(other.get(i)))
				return false;
		}
		return true;
	}

}
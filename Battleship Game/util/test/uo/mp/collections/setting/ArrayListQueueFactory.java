package uo.mp.collections.setting;


import uo.mp.collections.queue.AbstractQueue;
import uo.mp.collections.queue.ArrayListQueue;

public class ArrayListQueueFactory<T> implements QueueFactory<T> {

	@Override
	public AbstractQueue<T> newQueue() {
		return new ArrayListQueue<T>();
	}

}

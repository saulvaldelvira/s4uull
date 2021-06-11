package uo.mp.collections.setting;

import uo.mp.collections.queue.AbstractQueue;
import uo.mp.collections.queue.LinkedListQueue;

public class LinkedListQueueFactory<T> implements QueueFactory<T> {

	@Override
	public AbstractQueue<T> newQueue() {
		return new LinkedListQueue<T>();
	}

}

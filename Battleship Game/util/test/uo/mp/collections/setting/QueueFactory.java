/**
 * 
 */
package uo.mp.collections.setting;

import uo.mp.collections.queue.AbstractQueue;

/**
 * @author Sa�l
 * @param <T>
 *
 */
public interface QueueFactory<T> {

	AbstractQueue<T> newQueue();
	
}

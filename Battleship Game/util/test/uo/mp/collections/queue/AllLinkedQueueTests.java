package uo.mp.collections.queue;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import uo.mp.collections.setting.LinkedListQueueFactory;
import uo.mp.collections.setting.Settings;




@RunWith(Suite.class)
@SuiteClasses({ DequeueTest.class, EnqueueTest.class, IsEmptyTest.class, PeekTest.class, SizeTest.class })
public class AllLinkedQueueTests {

	@BeforeClass
	public static <T> void setUp() {
		Settings.queueFactory = new LinkedListQueueFactory<T>();
	}
	
}

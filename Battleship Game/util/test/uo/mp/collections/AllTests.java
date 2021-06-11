package uo.mp.collections;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import uo.mp.collections.list.AllArrayListTests;
import uo.mp.collections.list.AllLinkedListTests;

@RunWith(Suite.class)
@SuiteClasses({ 
	AllArrayListTests.class, 
	AllLinkedListTests.class,
	uo.mp.collections.iterator.AllTests.class, 
	uo.mp.collections.queue.AllQueueTests.class,
	uo.mp.collections.stack.AllStackTests.class
})
public class AllTests {

}

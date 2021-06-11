package uo.mp.collections.stack;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import uo.mp.collections.setting.ArrayListStackFactory;
import uo.mp.collections.setting.Settings;

@RunWith(Suite.class)
@SuiteClasses({ IsEmptyTest.class, PeekTest.class, PopTest.class, PushTest.class, SizeTest.class })
public class AllArrayStackTests {

	@BeforeClass
	public static <T> void setUp() {
		Settings.stackFactory = new ArrayListStackFactory<T>();
	}
	
}

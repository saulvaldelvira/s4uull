/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.board.board;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Saúl
 *
 */
@RunWith(Suite.class)
@SuiteClasses({GetFullStatus.class, GetMinimalStatusTest.class,
		GetNotFiredPositionsTest.class, IsFleeSunkTest.class })
public class AllTests {

}

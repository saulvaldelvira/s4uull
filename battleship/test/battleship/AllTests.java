/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Saúl
 *
 */
@RunWith(Suite.class)
@SuiteClasses({uo.mp.battleship.board.AllTests.class, 
			  uo.mp.battleship.game.AllTests.class,})
public class AllTests {

}

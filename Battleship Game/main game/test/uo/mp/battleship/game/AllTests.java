/*
 * 
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Sa�l
 *
 */
@RunWith(Suite.class)
@SuiteClasses({uo.mp.battleship.game.turnselector.AllTests.class, 
					uo.mp.battleship.game.game.AllTests.class})
public class AllTests {

}

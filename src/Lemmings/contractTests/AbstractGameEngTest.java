package Lemmings.contractTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Lemmings.factory.FactoryImpl;
import Lemmings.services.IGameEng;
import Lemmings.services.IJoueur;
import Lemmings.services.ILevel;

public abstract class AbstractGameEngTest {

	protected IGameEng gameEng;
	
	@Before
	public abstract void beforeTesting();
	
	@After
	public void afterTesting() {
		gameEng = null;
	}
	
	/**
	 * Init --------------------------------------------------------------------
	 */
	@Test
	public void gameEng_Init_1() {
		testGameEngInitWith(1, 10);						 					
	}
	
	@Test
	public void gameEng_Init_2() {
		testGameEngInitWith(999, 10);						 					
	}
	
	@Test
	public void gameEng_Init_3() {
		testGameEngInitWith(13, 1);						 					
	}
	
	@Test
	public void gameEng_Init_4() {
		testGameEngInitWith(13, 999);						 					
	}
	
	@Test
	public void gameEng_Init_5() {
		testGameEngInitWith(6, 6);						 					
	}
	
	@Test
	public void gameEng_Init_6() {
		testGameEngInitWith(25, 4);						 					
	}
	
	private void testGameEngInitWith(int sizeColony, int spawnSpeed) {			
		
		ILevel level = new FactoryImpl().makeLevel(100, 80);
		IJoueur joueur = new FactoryImpl().makeJoueur("Player1", 5);
		
		gameEng.init(sizeColony, spawnSpeed, level, joueur);
		
		Assert.assertTrue("Test GameEng Init : ",
				gameEng.getTour() == 0
			 && gameEng.getScore() == 0
			 && gameEng.isGameOver() == false
			 && gameEng.getSizeColony() == sizeColony
			 && gameEng.getSpawnSpeed() == spawnSpeed
			 && gameEng.getNbLemmingCreated() == 0
			 && gameEng.getNbLemmingSaved() == 0
			 && gameEng.getLevel() == level
			 && gameEng.getJoueur() == joueur
			 && gameEng.getActivLemmings().isEmpty()
		);
	}
}

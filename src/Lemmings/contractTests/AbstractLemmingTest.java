package Lemmings.contractTests;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import Lemmings.implementations.LemmingImpl;
import Lemmings.services.IGameEng;
import Lemmings.services.IJoueur;
import Lemmings.services.ILemming;
import Lemmings.services.ILevel;
import Lemmings.tools.Comportement;

public abstract class AbstractLemmingTest {

	final int WIDTH = 13;
	final int HEIGHT = 11;
	
	final int X_ENTRANCE = 2;
	final int Y_ENTRANCE = 2;
	final int X_EXIT = 10;
	final int Y_EXIT = 9;
	
	final int SIZE_COLONY = 5;
	final int SPAWN_SPEED = 2;
	
	protected IGameEng gameEng;
	ILevel level;
	IJoueur joueur;
	ILemming lemming;
	
	public abstract void beforeTesting();
	
	@After
	public void afterTesting() {
		lemming = null;
	}
	
	
	/**
	 * Init --------------------------------------------------------------------
	 */
	@Test
	public void lemming_Init_1() {
		ArrayList<Comportement> c = new ArrayList<Comportement>();
		c.add(Comportement.WALKER);
		testLemmingInitWith(c);						 					
	}
	
	@Test
	public void lemming_Init_2() {
		ArrayList<Comportement> c = new ArrayList<Comportement>();
		//TODO..........
		c.add(Comportement.WALKER);
		testLemmingInitWith(c);						 					
	}
	
	private void testLemmingInitWith(ArrayList<Comportement> c) {			
		
		lemming = new LemmingImpl(c, gameEng);
		
		Assert.assertTrue("Test GameEng Init : ",
			    lemming.isDroitier() == true
			 && lemming.getComportement().contains(c)
			 && lemming.getX() == level.getXEntrance()
			 && lemming.getY() == level.getYEntrance()
			 && lemming.getFalling() == 0
			 && lemming.getGameEng() == gameEng
			 && lemming.isDead() == false
			 && lemming.isSaved() == false
			 && lemming.getDalles() == 0
			 && lemming.getBuilderDelay() == 0
			 && lemming.getBomberDelay() == 5
			 && lemming.getBasherDelay() == 20
		);
	}
	
	/**
	 * Step --------------------------------------------------------------------
	 */
	@Test
	public void lemming_Step_1() {
		ArrayList<Comportement> c = new ArrayList<Comportement>();
		c.add(Comportement.WALKER);
		testLemmingInitWith(c);						 					
	}
	
	@Test
	public void lemming_Init_2() {
		ArrayList<Comportement> c = new ArrayList<Comportement>();
		//TODO..........
		c.add(Comportement.WALKER);
		testLemmingInitWith(c);						 					
	}
	
	private void testLemmingInitWith(ArrayList<Comportement> c) {			
		
		lemming = new LemmingImpl(c, gameEng);
		
		Assert.assertTrue("Test GameEng Init : ",
			    lemming.isDroitier() == true
			 && lemming.getComportement().contains(c)
			 && lemming.getX() == level.getXEntrance()
			 && lemming.getY() == level.getYEntrance()
			 && lemming.getFalling() == 0
			 && lemming.getGameEng() == gameEng
			 && lemming.isDead() == false
			 && lemming.isSaved() == false
			 && lemming.getDalles() == 0
			 && lemming.getBuilderDelay() == 0
			 && lemming.getBomberDelay() == 5
			 && lemming.getBasherDelay() == 20
		);
	}
}

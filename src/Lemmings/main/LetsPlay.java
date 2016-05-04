package Lemmings.main;

import Lemmings.contract.GameEngContract;
import Lemmings.contract.JoueurContract;
import Lemmings.contract.LevelContract;
import Lemmings.implementations.GameEngImpl;
import Lemmings.implementations.JoueurImpl;
import Lemmings.implementations.LevelImpl;
import Lemmings.services.IGameEng;
import Lemmings.services.IJoueur;
import Lemmings.services.ILevel;
import Lemmings.tools.Nature;

public class LetsPlay {

	static final int WIDTH = 13;
	static final int HEIGHT = 11;
	
	static final int X_ENTRANCE = 2;
	static final int Y_ENTRANCE = 2;
	static final int X_EXIT = 10;
	static final int Y_EXIT = 9;
	
	static final int SIZE_COLONY = 5;
	static final int SPAWN_SPEED = 2;
	
	public static void main(String[] args) {
		
		ILevel level = new LevelImpl(WIDTH, HEIGHT);
		level = new LevelContract(level);
		if (level.isEditing()) {
			level.setNature(1, 4, Nature.METAL);
			level.setNature(2, 4, Nature.METAL);
			level.setNature(3, 4, Nature.METAL);
			level.setNature(4, 4, Nature.METAL);
			level.setNature(5, 4, Nature.METAL);
			level.setNature(6, 4, Nature.METAL);
			level.setNature(7, 4, Nature.METAL);
			level.setNature(8, 4, Nature.METAL);
			level.setNature(9, 4, Nature.METAL);
			level.setNature(10, 4, Nature.METAL);
			level.setNature(11, 4, Nature.DIRT);
			level.setNature(2, 7, Nature.METAL);
			level.setNature(3, 7, Nature.METAL);
			level.setNature(4, 7, Nature.METAL);
			level.setNature(5, 7, Nature.METAL);
			level.setNature(6, 7, Nature.METAL);
			level.setNature(7, 7, Nature.METAL);
			level.setNature(8, 7, Nature.METAL);
			level.setNature(9, 7, Nature.METAL);
			level.setNature(10, 7, Nature.METAL);
			level.setNature(11, 7, Nature.METAL);
		}
		
		level.goPlay(X_ENTRANCE, Y_ENTRANCE, X_EXIT, Y_EXIT);
		IJoueur j  = new JoueurImpl("adel", 8);
		j = new JoueurContract(j);
		IGameEng g = new GameEngImpl(SIZE_COLONY, SPAWN_SPEED, level, j);
		g = new GameEngContract(g);
		//System.out.println("step suivante");
	}
}
	



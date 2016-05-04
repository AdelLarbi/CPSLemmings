package Lemmings.nonContractTests;

import org.junit.Before;

import Lemmings.contractTests.AbstractGameEngTest;
import Lemmings.implementations.GameEngImpl;
import Lemmings.implementations.JoueurImpl;
import Lemmings.implementations.LevelImpl;

public class TestGamEng extends AbstractGameEngTest {
	@Override
	@Before 
	public void beforeTesting() {
		gameEng = new GameEngImpl(2, 4, new LevelImpl(), new JoueurImpl("Player", 4));
	}
}

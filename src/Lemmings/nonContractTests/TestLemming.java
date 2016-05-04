package Lemmings.nonContractTests;

import org.junit.Before;

import Lemmings.contractTests.AbstractLemmingTest;
import Lemmings.implementations.LemmingImpl;

public class TestLemming extends AbstractLemmingTest {
	
	@Override
	@Before 
	public void beforeTesting() {
		lemming = new LemmingImpl(c, gameEng);
	}
}

package Lemmings.nonContractTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestLevel.class,
	TestGamEng.class,
	TestLemming.class
})

public class TestsWithoutContract {}

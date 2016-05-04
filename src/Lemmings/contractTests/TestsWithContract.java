package Lemmings.contractTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
	TestContractLevelInitCondition.class,
	TestContractLevel.class,
	TestContractGameEng.class
})

public class TestsWithContract {
	
}
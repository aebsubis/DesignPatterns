package strategy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StrategyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test() {
		Context context = new Context();
		assertEquals("No strategy.", context.action());

		context.setStrategy(new StrategyOne());
		assertEquals("StrategyOne.", context.action());
		
		context.setStrategy(new StrategyTwo());
		assertEquals("StrategyTwo.", context.action());
	}

}

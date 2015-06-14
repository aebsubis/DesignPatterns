package composite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CompositeTest {

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
	public final void simpleTest() {
		Leaf leaf = new Leaf("leaf");
		assertEquals("leaf", leaf.getStatus());
	}
	
	@Test
	public final void composteTest() {
		Leaf leaf = new Leaf("leaf");		
		Composite composite = new Composite();
		composite.add(leaf);
		
		assertEquals("leaf", composite.getStatus());
	}
	
	@Test
	public final void multipleLeafsTest() {
		Leaf leaf1 = new Leaf("leaf1");
		Leaf leaf2 = new Leaf("leaf2");
		Leaf leaf3 = new Leaf("leaf3");
		
		Composite composite = new Composite();
		composite.add(leaf1);
		composite.add(leaf2);
		composite.add(leaf3);
		
		assertEquals("leaf1 leaf2 leaf3", composite.getStatus());
	}
	
	@Test
	public final void multipleCompositesTest() {
		Leaf leaf1 = new Leaf("leaf1");
		Leaf leaf2 = new Leaf("leaf2");
		Leaf leaf3 = new Leaf("leaf3");

		Composite composite1 = new Composite();
		composite1.add(leaf1);

		Composite composite2 = new Composite();
		composite2.add(leaf2);

		Composite composite3 = new Composite();
		composite3.add(leaf3);

		Composite composite4 = new Composite();
		composite4.add(composite1);
		composite4.add(composite2);
		composite4.add(composite3);
		
		assertEquals("leaf1 leaf2 leaf3", composite4.getStatus());
	}
	
	public final void mixedTest() {	
		Leaf leaf1 = new Leaf("Find");
		
		Leaf leaf2 = new Leaf("what");
		Leaf leaf3 = new Leaf("you");
		Leaf leaf4 = new Leaf("love");
		Composite composite1 = new Composite();
		composite1.add(leaf2);
		composite1.add(leaf3);
		composite1.add(leaf4);
		
		Composite composite2 = new Composite();
		composite2.add(leaf1);
		composite2.add(composite1);
		
		Leaf leaf5 = new Leaf("and");
		
		Leaf leaf6 = new Leaf("let");
		Leaf leaf7 = new Leaf("it");
		Leaf leaf8 = new Leaf("kill");
		Leaf leaf9 = new Leaf("you");

		Composite composite3 = new Composite();
		composite3.add(leaf6);
		composite3.add(leaf7);
		composite3.add(leaf8);
		composite3.add(leaf9);
		
		Composite composite4 = new Composite();
		composite4.add(composite2);
		composite4.add(leaf5);
		composite4.add(composite3);
		
		assertEquals("Find what you love and let it kill you", composite4.getStatus());
	}
}

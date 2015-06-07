/**
 * 
 */
package singleton;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author daniel
 *
 */
public class SingletonTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("SingletonTest::setUpBeforeClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("SingletonTest::tearDownAfterClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("SingletonTest::setUp");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("SingletonTest::tearDown");
	}

	/**
	 * Test method for {@link singleton.Singleton#getInstance()}.
	 */
	@Test
	public final void testGetInstance() {
		System.out.println("SingletonTest::testGetInstance");
		Singleton singletonInstance = Singleton.getInstance();
		assertNotEquals(singletonInstance, null);
	}

	/**
	 * Test method for {@link singleton.Singleton#execute()}.
	 */
	@Test
	public final void testExecute() {
		System.out.println("SingletonTest::testExecute");
		Singleton singletonInstance = Singleton.getInstance();
		assertEquals(1, singletonInstance.execute());
		assertEquals(2, singletonInstance.execute());
		assertEquals(3, singletonInstance.execute());
		
		Singleton singletonInstance2 = Singleton.getInstance();
		assertEquals(4, singletonInstance2.execute());
		assertEquals(5, singletonInstance2.execute());
		assertEquals(6, singletonInstance2.execute());		
	}

}

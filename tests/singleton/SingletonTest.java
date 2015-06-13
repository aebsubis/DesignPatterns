package singleton;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SingletonTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("SingletonTest::setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("SingletonTest::tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("SingletonTest::setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("SingletonTest::tearDown");
	}

	@Test
	public final void testGetInstance() {
		System.out.println("SingletonTest::testGetInstance");
		Singleton singletonInstance = Singleton.getInstance();
		assertNotEquals(singletonInstance, null);
	}

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

package observer;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ObserverTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("ObserverTest::setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("ObserverTest::tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("ObserverTest::setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("ObserverTest::tearDown");
	}

	@Test
	public final void TestNoSubscription() {
		ConcreteSubject cs = new ConcreteSubject();
		ConcreteObserver co1 = new ConcreteObserver();
		
		assertEquals(co1.getObservedState(), null);
		
		cs.setState("TestNoSubscription");
		
		assertEquals(co1.getObservedState(), null);
	}
	
	@Test
	public final void TestSingleSubscription() {
		ConcreteSubject cs = new ConcreteSubject();
		ConcreteObserver co1 = new ConcreteObserver();
		
		assertEquals(co1.getObservedState(), null);
		
		cs.register(co1);
		cs.setState("TestNoSubscription");
		
		assertEquals(co1.getObservedState(), "TestNoSubscription");
	}
	
	@Test
	public final void TestMultipleSubscriptions() {
		
		ConcreteSubject cs = new ConcreteSubject();
		ConcreteObserver co1 = new ConcreteObserver();
		ConcreteObserver co2 = new ConcreteObserver();
		ConcreteObserver co3 = new ConcreteObserver();

		assertEquals(co1.getObservedState(), null);		
		assertEquals(co2.getObservedState(), null);		
		assertEquals(co3.getObservedState(), null);
		cs.register(co1);
		cs.register(co2);
		cs.register(co3);
		cs.setState("TestMultipleSubscriptions");
		
		assertEquals(co1.getObservedState(), "TestMultipleSubscriptions");		
		assertEquals(co2.getObservedState(), "TestMultipleSubscriptions");		
		assertEquals(co3.getObservedState(), "TestMultipleSubscriptions");
	}
	
	@Test
	public final void TestSingleUnsubscription() {
		ConcreteSubject cs = new ConcreteSubject();
		ConcreteObserver co1 = new ConcreteObserver();

		assertEquals(co1.getObservedState(), null);		
		
		cs.register(co1);
		cs.setState("TestSingleUnsubscription");
		
		assertEquals(co1.getObservedState(), "TestSingleUnsubscription");
		
		cs.unregister(co1);
		cs.setState("TestSingleUnsubscription2");
		
		assertEquals(co1.getObservedState(), "TestSingleUnsubscription");
	}
	
	@Test
	public final void TestMultipleUnsubscriptions() {
		ConcreteSubject cs = new ConcreteSubject();
		ConcreteObserver co1 = new ConcreteObserver();
		ConcreteObserver co2 = new ConcreteObserver();

		assertEquals(co1.getObservedState(), null);	
		assertEquals(co2.getObservedState(), null);		

		cs.register(co1);
		cs.register(co2);
		cs.setState("TestMultipleUnsubscriptions");

		assertEquals(co1.getObservedState(), "TestMultipleUnsubscriptions");
		assertEquals(co2.getObservedState(), "TestMultipleUnsubscriptions");

		cs.unregister(co1);
		cs.unregister(co2);
		cs.setState("TestMultipleUnsubscriptions2");

		assertEquals(co1.getObservedState(), "TestMultipleUnsubscriptions");
		assertEquals(co2.getObservedState(), "TestMultipleUnsubscriptions");
	}
	
	@Test
	public final void TestPartialUnsubscription() {
		ConcreteSubject cs = new ConcreteSubject();
		ConcreteObserver co1 = new ConcreteObserver();
		ConcreteObserver co2 = new ConcreteObserver();

		assertEquals(co1.getObservedState(), null);	
		assertEquals(co2.getObservedState(), null);	
		
		cs.register(co1);
		cs.register(co2);
		cs.setState("TestPartialUnsubscription");
		
		assertEquals(co1.getObservedState(), "TestPartialUnsubscription");		
		assertEquals(co2.getObservedState(), "TestPartialUnsubscription");	
		
		cs.unregister(co1);
		cs.setState("TestPartialUnsubscription2");
		
		assertEquals(co1.getObservedState(), "TestPartialUnsubscription");		
		assertEquals(co2.getObservedState(), "TestPartialUnsubscription2");	
	}
	
	@Test
	public final void TestSingleResubscription() {
		ConcreteSubject cs = new ConcreteSubject();
		ConcreteObserver co1 = new ConcreteObserver();

		assertEquals(co1.getObservedState(), null);		
		
		cs.register(co1);
		cs.setState("TestSingleUnsubscription");
		
		assertEquals(co1.getObservedState(), "TestSingleUnsubscription");
		
		cs.unregister(co1);
		cs.setState("TestSingleUnsubscription2");
		
		assertEquals(co1.getObservedState(), "TestSingleUnsubscription");
		
		cs.register(co1);
		cs.setState("TestSingleUnsubscription3");

		assertEquals(co1.getObservedState(), "TestSingleUnsubscription3");
	}
	
	@Test
	public final void TestMultipleResubscription() {
		ConcreteSubject cs = new ConcreteSubject();
		ConcreteObserver co1 = new ConcreteObserver();
		ConcreteObserver co2 = new ConcreteObserver();

		assertEquals(co1.getObservedState(), null);	
		assertEquals(co2.getObservedState(), null);		

		cs.register(co1);
		cs.register(co2);
		cs.setState("TestMultipleResubscription");

		assertEquals(co1.getObservedState(), "TestMultipleResubscription");
		assertEquals(co2.getObservedState(), "TestMultipleResubscription");

		cs.unregister(co1);
		cs.unregister(co2);
		cs.setState("TestMultipleResubscription2");

		assertEquals(co1.getObservedState(), "TestMultipleResubscription");
		assertEquals(co2.getObservedState(), "TestMultipleResubscription");

		cs.register(co1);
		cs.register(co2);
		cs.setState("TestMultipleResubscription3");

		assertEquals(co1.getObservedState(), "TestMultipleResubscription3");
		assertEquals(co2.getObservedState(), "TestMultipleResubscription3");
	}
	
	@Test
	public final void TestPartialResubscription() {
		ConcreteSubject cs = new ConcreteSubject();
		ConcreteObserver co1 = new ConcreteObserver();
		ConcreteObserver co2 = new ConcreteObserver();

		assertEquals(co1.getObservedState(), null);	
		assertEquals(co2.getObservedState(), null);		

		cs.register(co1);
		cs.register(co2);
		cs.setState("TestPartialResubscription");

		assertEquals(co1.getObservedState(), "TestPartialResubscription");
		assertEquals(co2.getObservedState(), "TestPartialResubscription");

		cs.unregister(co1);
		cs.unregister(co2);
		cs.setState("TestPartialResubscription2");

		assertEquals(co1.getObservedState(), "TestPartialResubscription");
		assertEquals(co2.getObservedState(), "TestPartialResubscription");

		cs.register(co1);
		cs.setState("TestPartialResubscription3");

		assertEquals(co1.getObservedState(), "TestPartialResubscription3");
		assertEquals(co2.getObservedState(), "TestPartialResubscription");
	}
	
	@Test
	public final void TestMixedSubscriptionUnsubscription() {
		ConcreteSubject cs = new ConcreteSubject();
		ConcreteObserver co1 = new ConcreteObserver();
		ConcreteObserver co2 = new ConcreteObserver();

		assertEquals(co1.getObservedState(), null);	
		assertEquals(co2.getObservedState(), null);		

		cs.register(co1);
		cs.setState("TestMixedSubscriptionUnsubscription");

		assertEquals(co1.getObservedState(), "TestMixedSubscriptionUnsubscription");
		assertEquals(co2.getObservedState(), null);

		cs.unregister(co1);
		cs.register(co2);
		cs.setState("TestMixedSubscriptionUnsubscription2");

		assertEquals(co1.getObservedState(), "TestMixedSubscriptionUnsubscription");
		assertEquals(co2.getObservedState(), "TestMixedSubscriptionUnsubscription2");
	}
	
	@Test
	public final void TestLargeSubscription() {
		ConcreteSubject cs = new ConcreteSubject();
		ArrayList<IObserver> observers = new ArrayList<IObserver>();
		int largeSubscriptionsCount = 10000;
		for (int i = 0; i < largeSubscriptionsCount; i++) {
			ConcreteObserver co = new ConcreteObserver();
			assertEquals(co.getObservedState(), null);	
			cs.register(co);
			observers.add(co);
		}
		
		cs.setState("TestLargeSubscription");
		
		
		ConcreteObserver co1 = new ConcreteObserver();
		ConcreteObserver co2 = new ConcreteObserver();

		assertEquals(co1.getObservedState(), null);	
		assertEquals(co2.getObservedState(), null);		

		cs.register(co1);
		cs.setState("TestMixedSubscriptionUnsubscription");

		assertEquals(co1.getObservedState(), "TestMixedSubscriptionUnsubscription");
		assertEquals(co2.getObservedState(), null);

		cs.unregister(co1);
		cs.register(co2);
		cs.setState("TestMixedSubscriptionUnsubscription2");

		assertEquals(co1.getObservedState(), "TestMixedSubscriptionUnsubscription");
		assertEquals(co2.getObservedState(), "TestMixedSubscriptionUnsubscription2");
	}
}

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
	public final void TestNoSubscription() {
		ConcreteSubject cs = new ConcreteSubject();
		ConcreteObserver co1 = new ConcreteObserver();
		
		assertEquals(null, co1.getObservedState());
		
		cs.setState("TestNoSubscription");
		
		assertEquals(null, co1.getObservedState());
	}
	
	@Test
	public final void TestSingleSubscription() {
		ConcreteSubject cs = new ConcreteSubject();
		ConcreteObserver co1 = new ConcreteObserver();
		
		assertEquals(null, co1.getObservedState());
		
		cs.register(co1);
		cs.setState("TestNoSubscription");
		
		assertEquals("TestNoSubscription", co1.getObservedState());
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
		
		assertEquals("TestMultipleSubscriptions", co1.getObservedState());		
		assertEquals("TestMultipleSubscriptions", co2.getObservedState());		
		assertEquals("TestMultipleSubscriptions", co3.getObservedState());
	}
	
	@Test
	public final void TestSingleUnsubscription() {
		ConcreteSubject cs = new ConcreteSubject();
		ConcreteObserver co1 = new ConcreteObserver();

		assertEquals(co1.getObservedState(), null);		
		
		cs.register(co1);
		cs.setState("TestSingleUnsubscription");
		
		assertEquals("TestSingleUnsubscription", co1.getObservedState());
		
		cs.unregister(co1);
		cs.setState("TestSingleUnsubscription2");
		
		assertEquals("TestSingleUnsubscription", co1.getObservedState());
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

		assertEquals("TestMultipleUnsubscriptions", co1.getObservedState());
		assertEquals("TestMultipleUnsubscriptions", co2.getObservedState());

		cs.unregister(co1);
		cs.unregister(co2);
		cs.setState("TestMultipleUnsubscriptions2");

		assertEquals("TestMultipleUnsubscriptions", co1.getObservedState());
		assertEquals("TestMultipleUnsubscriptions", co2.getObservedState());
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
		
		assertEquals("TestPartialUnsubscription", co1.getObservedState());		
		assertEquals("TestPartialUnsubscription", co2.getObservedState());	
		
		cs.unregister(co1);
		cs.setState("TestPartialUnsubscription2");
		
		assertEquals("TestPartialUnsubscription", co1.getObservedState());		
		assertEquals("TestPartialUnsubscription2", co2.getObservedState());	
	}
	
	@Test
	public final void TestSingleResubscription() {
		ConcreteSubject cs = new ConcreteSubject();
		ConcreteObserver co1 = new ConcreteObserver();

		assertEquals(co1.getObservedState(), null);		
		
		cs.register(co1);
		cs.setState("TestSingleUnsubscription");
		
		assertEquals("TestSingleUnsubscription", co1.getObservedState());
		
		cs.unregister(co1);
		cs.setState("TestSingleUnsubscription2");
		
		assertEquals("TestSingleUnsubscription", co1.getObservedState());
		
		cs.register(co1);
		cs.setState("TestSingleUnsubscription3");

		assertEquals("TestSingleUnsubscription3", co1.getObservedState());
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

		assertEquals("TestMultipleResubscription", co1.getObservedState());
		assertEquals("TestMultipleResubscription", co2.getObservedState());

		cs.unregister(co1);
		cs.unregister(co2);
		cs.setState("TestMultipleResubscription2");

		assertEquals("TestMultipleResubscription", co1.getObservedState());
		assertEquals("TestMultipleResubscription", co2.getObservedState());

		cs.register(co1);
		cs.register(co2);
		cs.setState("TestMultipleResubscription3");

		assertEquals("TestMultipleResubscription3", co1.getObservedState());
		assertEquals("TestMultipleResubscription3", co2.getObservedState());
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

		assertEquals("TestPartialResubscription", co1.getObservedState());
		assertEquals("TestPartialResubscription", co2.getObservedState());

		cs.unregister(co1);
		cs.unregister(co2);
		cs.setState("TestPartialResubscription2");

		assertEquals("TestPartialResubscription", co1.getObservedState());
		assertEquals("TestPartialResubscription", co2.getObservedState());

		cs.register(co1);
		cs.setState("TestPartialResubscription3");

		assertEquals("TestPartialResubscription3", co1.getObservedState());
		assertEquals("TestPartialResubscription", co2.getObservedState());
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

		assertEquals("TestMixedSubscriptionUnsubscription", co1.getObservedState());
		assertEquals(null, co2.getObservedState());

		cs.unregister(co1);
		cs.register(co2);
		cs.setState("TestMixedSubscriptionUnsubscription2");

		assertEquals("TestMixedSubscriptionUnsubscription", co1.getObservedState());
		assertEquals("TestMixedSubscriptionUnsubscription2", co2.getObservedState());
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

		assertEquals("TestMixedSubscriptionUnsubscription", co1.getObservedState());
		assertEquals(null, co2.getObservedState());

		cs.unregister(co1);
		cs.register(co2);
		cs.setState("TestMixedSubscriptionUnsubscription2");

		assertEquals("TestMixedSubscriptionUnsubscription", co1.getObservedState());
		assertEquals("TestMixedSubscriptionUnsubscription2", co2.getObservedState());
	}
}

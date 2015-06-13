package observer;

public class ConcreteObserver extends AbstractObserver {
	
	private String observedState = null;
	
	@Override
	public void update() {
		if (subject == null) {
			System.out.println("pero que cojones?");
		}
		observedState = (String) ((ConcreteSubject)subject).getState();
	}
	
	public String getObservedState() {
		return observedState;
	}
}

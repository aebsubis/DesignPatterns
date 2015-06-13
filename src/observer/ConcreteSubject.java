package observer;

public class ConcreteSubject extends AbstractSubject {

    private String state;
    
    public Object getState() {
		return this.state;
	}
    
	public void setState(String state) {
		this.state = state;
		notifyObservers();
	}
}

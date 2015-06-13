package observer;

import java.util.ArrayList;

public abstract class AbstractSubject implements ISubject{

	private ArrayList<IObserver> observers;
    private final Object MUTEX = new Object();
    
    public AbstractSubject() {
    	this.observers = new ArrayList<IObserver>();
	}
    
	@Override
	public void register(IObserver obj) {
		if(obj == null) {
			throw new NullPointerException("Null Observer");
		}
		
        synchronized (MUTEX) {
        	if(!observers.contains(obj)) {
        		observers.add(obj);
        		obj.setSubject(this);
        	}
        }
	}

	@Override
	public void unregister(IObserver obj) {
		synchronized (MUTEX) {
			observers.remove(obj);
        }
	}

	@Override
	public void notifyObservers() {
		ArrayList<IObserver> observersLocal = null;
        synchronized (MUTEX) {
            observersLocal = new ArrayList<>(this.observers);
        }
        
        for (IObserver obj : observersLocal) {
            obj.update();
        }
	}
}

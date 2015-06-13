package observer;

public class AbstractObserver implements IObserver{

    protected ISubject subject;

	@Override
	public void update() {
	}

	@Override
	public void setSubject(ISubject sub) {
		this.subject = sub;
	}
}

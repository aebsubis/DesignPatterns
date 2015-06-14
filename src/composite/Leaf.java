package composite;

public class Leaf implements IComponent {
	
	protected String status = null;
	
	public Leaf(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
}

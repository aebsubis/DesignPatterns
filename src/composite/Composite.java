package composite;

import java.util.ArrayList;

public class Composite implements IComponent {
	private final  static  char STATUS_SEPARATOR = ' ';
	ArrayList<IComponent> components = null;
	
	public Composite() {
		components = new ArrayList<IComponent>();
	}
	
	public void add(IComponent component) {
		components.add(component);
	}
	
	public String getStatus() {
		String status = "";
		
		for (IComponent c: components) {
			if (!status.isEmpty() && status.charAt(status.length()-1) != STATUS_SEPARATOR) {
				status += STATUS_SEPARATOR;
			}
			status += c.getStatus();
		}
		return status;
	}
}

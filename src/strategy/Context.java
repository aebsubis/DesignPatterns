package strategy;

public class Context {
	private IStrategy strategy = null;
	
	public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}
	
	public IStrategy getStrategy() {
		return this.strategy;
	}
	
	public String action() {
		if (strategy == null) {
			return "No strategy.";
		}
		
		return strategy.action();
	}
}

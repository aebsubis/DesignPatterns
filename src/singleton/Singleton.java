package singleton;

/**
 * TODO: Describe pros and cons
 */
public class Singleton {
	
	private static Singleton m_singletonInstance = null;
	
	public static Singleton getInstance() {
		if (m_singletonInstance == null) {
			m_singletonInstance = new Singleton();
		}
		return m_singletonInstance;
	}
	
	private Singleton() {	}

	private int m_nExecutionCount = 0;
	
	public int execute() {
		m_nExecutionCount += 1;
		System.out.println("Executed " + m_nExecutionCount);
		return m_nExecutionCount;
	}
	
}

package assertcustom;

public class AssertionErrorCustom extends AssertionError {
	private static final long serialVersionUID = 1L;
	private String message;

	public AssertionErrorCustom(String message) {
		super(message);
		this.message=message;
	}
	
	@Override
	public synchronized Throwable fillInStackTrace() {
		return null;
	}
	
	@Override
	public String toString() {
		return message;
	}
}
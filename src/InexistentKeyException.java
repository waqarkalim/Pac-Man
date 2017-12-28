public class InexistentKeyException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InexistentKeyException (String key){
		super ("The key does not exist");
	}
}
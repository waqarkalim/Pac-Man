public class DuplicatedKeyException extends RuntimeException{
	/**
	 * 
	 */
	public DuplicatedKeyException (String key){
		super("The key is duplicated");
	}
}
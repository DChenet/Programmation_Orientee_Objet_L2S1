package exceptions;

public class NotSupportedFileException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotSupportedFileException(String file) {
		super("File: "+file+" cannot be loaded, it might be corrupted or incompleate");
	}
	

}

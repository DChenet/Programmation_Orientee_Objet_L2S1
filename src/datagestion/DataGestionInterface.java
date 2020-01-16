package datagestion;

import java.io.File;

import exceptions.NotSupportedFileException;

/**
 * 
 * @author Javadoc CHOLLET Alexis
 * @author Javadoc CHENET Dorian
 * @author Class CHENET Dorian
 *
 */
public interface DataGestionInterface {

	/**
	 * Puts every objects with matching search query from database into
	 * searchresults.
	 * 
	 * @param searchquery
	 */
	public void search(String searchquery);

	public void clearDataBase();

	public void clearSearchResults();

	/**
	 * Loads a text file with matching file extension into database.
	 * 
	 * @param file
	 * @throws NotSupportedFileException
	 */
	public void loadFile(File file) throws NotSupportedFileException;

	/**
	 * Loads every text file with matching file extension from a directory into
	 * database.
	 * 
	 * @param file
	 * @throws NotSupportedFileException
	 */
	public void loadDirectory(File file) throws NotSupportedFileException;

	/**
	 * Loads a binary file into database.
	 * 
	 * @param file
	 */
	public void loadSerFile(String file);
}

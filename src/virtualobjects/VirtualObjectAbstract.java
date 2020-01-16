package virtualobjects;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Javadoc CHOLLET Alexis
 * @author Javadoc CHENET Dorian
 * @author Class CHENET Dorian
 *
 */
public abstract class VirtualObjectAbstract {

	/**
	 * Writes a VirtualObject into a text file at location file.
	 * 
	 * @param file
	 * @param text
	 */
	public void exportTextFile(String text, String file) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(text);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Writes a VirtualObject into a binary file at destination file.
	 * 
	 * @param file
	 */
	public void exportSerFile(String file) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(this);
			oos.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

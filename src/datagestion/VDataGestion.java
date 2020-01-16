package datagestion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import database.Adress;
import database.Contact;
import database.Phone;
import exceptions.NotSupportedFileException;
import virtualobjects.Card;

/**
 * 
 * @author Javadoc CHOLLET Alexis
 * @author Javadoc CHENET Dorian
 * @author Class CHENET Dorian
 *
 */
public class VDataGestion implements DataGestionInterface {

	private Card selectedcard;
	private ArrayList<Card> database;
	private ArrayList<Card> searchresults;

	public VDataGestion() {
		selectedcard = new Card();
		database = new ArrayList<Card>();
		searchresults = new ArrayList<Card>();
	}

	/**
	 * Adds a card to database if it doesn't contain it already.
	 * 
	 * @param card
	 */
	public void add(Card card) {
		if (!database.contains(card)) {
			database.add(card);
		}
	}

	public void clearDataBase() {
		database.clear();
	}

	public void clearSearchResults() {
		searchresults.clear();
	}

	/**
	 * Searches every card in database with its name attribute matching the search
	 * query.
	 * 
	 * @param searchquery
	 */
	public void search(String searchquery) {
		clearSearchResults();
		for (Card card : database) {
			if (card.machingString(searchquery)) {
				searchresults.add(card);
			}
		}
	}

	/**
	 * Loads a .vcf file into database.
	 * 
	 * @param directory
	 * @throws NotSupportedFileException
	 */
	public void loadFile(File directory) throws NotSupportedFileException {

		Card card = new Card();
		card.loadVcfFile(directory.getAbsolutePath());
		add(card);

	}

	/**
	 * Loads every .vcf files containted into directory.
	 * 
	 * @param directory
	 * @throws NotSupportedFileException
	 */
	public void loadDirectory(File directory) throws NotSupportedFileException {
		File[] list = directory.listFiles();
		if (list != null) {
			for (File fil : list) {
				if (fil.isDirectory()) {
					loadDirectory(fil);
				}

				else if (fil.getName().endsWith(".vcf")) {
					Card card = new Card();
					card.loadVcfFile(fil.getAbsolutePath());
					add(card);
				}
			}
		}
	}

	/**
	 * Loads a .ser file into database.
	 * 
	 * @param file
	 */
	public void loadSerFile(String file) {

		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			Card card = (Card) ois.readObject();
			add(card);
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}

	}

	/**
	 * 
	 * @return database
	 */
	public ArrayList<Card> getDataBase() {
		return database;
	}

	/**
	 * 
	 * @return searchresults
	 */
	public ArrayList<Card> getSearchResults() {
		return searchresults;
	}

	/**
	 * 
	 * @return selectedcard
	 */
	public Card getSelectedCard() {
		return selectedcard;
	}

	/**
	 * 
	 * @param index
	 * @return card
	 */
	public Card getCardDataBase(int index) {
		return database.get(index);
	}

	/**
	 * 
	 * @param index
	 */
	public void setSelectedCard(int index) {
		selectedcard = database.get(index);
	}

	/**
	 * 
	 * @param card
	 */
	public void setSelectedCard(Card card) {
		selectedcard = card;
	}

	/**
	 * 
	 * @param contact
	 */
	public void modifySelectedCard(Contact contact) {
		selectedcard.setContact(contact);
	}

	/**
	 * 
	 * @param s
	 */
	public void modifyFirstNameSelectedCard(String s) {
		selectedcard.getContact().setFirstName(s);
	}

	/**
	 * 
	 * @param s
	 */
	public void modifyLastNameSelectedCard(String s) {
		selectedcard.getContact().setLastName(s);
	}

	/**
	 * 
	 * @param s
	 */
	public void modifyEmailSelectedCard(String s) {
		selectedcard.getContact().seteMail(s);
	}

	/**
	 * 
	 * @param phone
	 */
	public void modifyPhoneSelectedCard(Phone phone) {
		selectedcard.getContact().setPhone(phone);
	}

	/**
	 * 
	 * @param adress
	 */
	public void modifyAdressSelectedCard(Adress adress) {
		selectedcard.getContact().setAdress(adress);
	}

	/**
	 * 
	 * @param s
	 */
	public void modifyTitleSelectedCard(String s) {
		selectedcard.getContact().setTitle(s);
	}

	/**
	 * 
	 * @param s
	 */
	public void modifyCompanySelectedCard(String s) {
		selectedcard.getContact().setCompany(s);
	}

	/**
	 * 
	 * @param s
	 */
	public void modifyCivilitySelectedCard(String s) {
		selectedcard.getContact().setCivility(s);
	}

}

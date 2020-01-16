package datagestion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import exceptions.NotSupportedFileException;
import virtualobjects.Calendar;

/**
 * 
 * @author Javadoc CHOLLET Alexis
 * @author Javadoc CHENET Dorian
 * @author Class CHENET Dorian
 *
 */
public class IDataGestion implements DataGestionInterface {

	private Calendar selectedcalendar;
	private ArrayList<Calendar> database;
	private ArrayList<Calendar> searchresults;

	public IDataGestion() {
		selectedcalendar = new Calendar();
		database = new ArrayList<Calendar>();
		searchresults = new ArrayList<Calendar>();
	}

	/**
	 * Adds a calendar to database if it doesn't contain it already.
	 * 
	 * @param calendar
	 */
	public void add(Calendar calendar) {
		if (!database.contains(calendar)) {
			database.add(calendar);
		}
	}

	public void clearDataBase() {
		database.clear();
	}

	public void clearSearchResults() {
		searchresults.clear();
	}

	/**
	 * Searches every calendar in database with its company attribute matching
	 * the search query.
	 * 
	 * @param searchquery
	 */
	public void search(String searchquery) {
		clearSearchResults();
		for (Calendar calendar : database) {
			if (calendar.machingString(searchquery)) {
				searchresults.add(calendar);
			}
		}
	}

	/**
	 * Loads a .ics file into database.
	 * 
	 * @param file
	 * @throws NotSupportedFileException
	 */
	public void loadFile(File file) throws NotSupportedFileException {

		Calendar calendar = new Calendar();
		calendar.loadIcsFile(file.getAbsolutePath());
		add(calendar);
	}

	/**
	 * Loads every .ics files contained into directory.
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

				else if (fil.getName().endsWith(".ics")) {
					Calendar calendar = new Calendar();
					calendar.loadIcsFile(fil.getAbsolutePath());
					add(calendar);
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

			Calendar calendar = (Calendar) ois.readObject();
			add(calendar);

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
	 * Prints every objects contained in database into the terminal
	 */
	public void printData() {
		for (Calendar calendar : database) {
			System.out.println(calendar.toString());
		}
	}

	/**
	 * Prints every objects contained in searchresults into the terminal
	 */
	public void printSearchResults() {
		Calendar calendar = null;
		for (int i = 0; (i < searchresults.size()); i++) {
			calendar = searchresults.get(i);
			System.out.println(calendar.toString());
		}
	}

	/**
	 * 
	 * @return database
	 */
	public ArrayList<Calendar> getDataBase() {
		return database;
	}

	/**
	 * 
	 * @return searchresult
	 */
	public ArrayList<Calendar> getSearchResults() {
		return searchresults;
	}

	/**
	 * 
	 * @return selectedcalendar
	 */
	public Calendar getSelectedCalendar() {
		return selectedcalendar;
	}

	/**
	 * 
	 * @param index
	 */
	public void setSelectedCalendar(int index) {
		selectedcalendar = database.get(index);
	}

	/**
	 * 
	 * @param calendar
	 */
	public void setSelectedCalendar(Calendar calendar) {
		selectedcalendar = calendar;
	}

	/**
	 * 
	 * @param name
	 */
	public void modifyNameSelectedCalendar(String name) {
		selectedcalendar.getProdid().setName(name);
	}

	/**
	 * @param country
	 */
	public void modifyCountrySelectedCalendar(String country) {
		selectedcalendar.getProdid().setCountry(country);
	}

	/**
	 * 
	 * @param place
	 */
	public void modifyPlaceSelectedCalendar(String place) {
		selectedcalendar.getVevent().getLocation().setPlace(place);
	}

	/**
	 * 
	 * @param city
	 */
	public void modifyCitySelectedCalendar(String city) {
		selectedcalendar.getVevent().getLocation().setCity(city);
	}

	/**
	 * 
	 * @param state
	 */
	public void modifyStateSelectedCalendar(String state) {
		selectedcalendar.getVevent().getLocation().setState(state);
	}

	/**
	 * 
	 * @param summary
	 */
	public void modifySummarySelectedCalendar(String summary) {
		selectedcalendar.getVevent().setSummary(summary);
	}

	/**
	 * 
	 * @param url
	 */
	public void modifyUrlSelectedCalendar(String url) {
		selectedcalendar.getVevent().setUrl(url);
	}

	/**
	 * 
	 * @param day
	 * @param month
	 * @param year
	 */
	public void modifySDateSelectedCalendar(String day, String month, String year) {
		selectedcalendar.getVevent().getSdate().setDay(day);
		selectedcalendar.getVevent().getSdate().setMonth(month);
		selectedcalendar.getVevent().getSdate().setYear(year);
	}

	/**
	 * 
	 * @param day
	 * @param month
	 * @param year
	 */
	public void modifyFDateSelectedCalendar(String day, String month, String year) {
		selectedcalendar.getVevent().getFdate().setDay(day);
		selectedcalendar.getVevent().getFdate().setMonth(month);
		selectedcalendar.getVevent().getFdate().setYear(year);
	}

}

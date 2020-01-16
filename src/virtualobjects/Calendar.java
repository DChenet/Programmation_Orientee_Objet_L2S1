package virtualobjects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import database.Date;
import database.Event;
import database.Location;
import database.Prodid;
import exceptions.NotSupportedFileException;

/**
 * 
 * @author Javadoc CHOLLET Alexis
 * @author Class CHOLLET Alexis
 * @author Javadoc CHENET Dorian
 * @author Class CHENET Dorian
 *
 */
public class Calendar extends VirtualObjectAbstract implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Prodid prodid;
	private Event vevent;

	/**
	 * 
	 * @param prodid
	 * @param vevent
	 */
	public Calendar(Prodid prodid, Event vevent) {
		this.prodid = prodid;
		this.vevent = vevent;

	}

	/**
	 * Creates a blank Calendar object.
	 */
	public Calendar() {
		this.prodid = new Prodid();
		this.vevent = new Event();
	}

	/**
	 * Returns the ICalendar as a String.
	 */
	public String toString() {
		return "BEGIN:VCALENDAR \n" + "PRODID:" + prodid.toString() + "\n" + "VERSION:2.0 \n" + vevent.toString()
				+ "END:VCALENDAR \n";
	}

	/**
	 * Returns an Html fragment generated from vevent and prodid.
	 * 
	 * @return frag
	 */
	public String getHtmlFragment() {
		String frag;

		frag = " <div class=\"vevent\">\n";
		frag += " <a class=\"url\"\n";
		frag += " href=\"" + this.getVevent().getUrl() + "\">\n";
		frag += this.getVevent().getUrl() + "\n";
		frag += "</a>\n";
		frag += "<span class=\"summary\"> Summary: " + this.getVevent().getSummary() + "\n";
		frag += "<abbr class=\"dtstart\" title=\"Starting date\">  | From the: " + this.getVevent().getSdate().getYear()
				+ "/" + this.getVevent().getSdate().getMonth() + "/" + this.getVevent().getSdate().getDay()
				+ "</abbr> to the \n";
		frag += "<abbr class=\"dtend\" title=\"Ending date\">" + this.getVevent().getSdate().getYear() + "/"
				+ this.getVevent().getSdate().getMonth() + "/" + this.getVevent().getSdate().getDay() + "</abbr>,\n";
		frag += "| Location: <span class=\"location\">" + this.getVevent().getLocation().getPlace() + ","
				+ this.getVevent().getLocation().getCity() + "," + this.getVevent().getLocation().getState()
				+ "</span>\n";
		frag += "</div>";

		return frag;
	}

	/**
	 * Sets vevent and prodid attributes with the informations extracted from
	 * file.
	 * 
	 * @param file
	 * @throws NotSupportedFileException
	 */
	@SuppressWarnings("resource")
	public void loadIcsFile(String file) throws NotSupportedFileException {
		String ligne = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			Prodid prodid = null;
			String url = "";
			Date sdate = null;
			Date fdate = null;
			String summary = "";
			Location location = null;

			while ((ligne = br.readLine()) != null) {

				String[] res = ligne.split(":");

				switch (res[0]) {
				case "PRODID":
					String[] res2 = res[1].split("//");
					prodid = new Prodid(res2[1], res2[2]);

					break;

				case "URL":
					for (int i = 1; i < res.length; i++) {
						if (i < res.length - 1) {
							url += res[i] + ":";
						} else {
							url += res[i];
						}
					}
					break;

				case "DTSTART":
					String[] res3 = res[1].split("");
					sdate = new Date(res3[0] + res3[1], res3[2] + res3[3], res3[4] + res3[5]);
					break;

				case "DTEND":
					String[] res4 = res[1].split("");
					fdate = new Date(res4[0] + res4[1], res4[2] + res4[3], res4[4] + res4[5]);
					break;

				case "SUMMARY":
					summary = res[1];
					break;

				case "LOCATION":
					String[] res5 = res[1].split("\\\\, ");
					location = new Location(res5[0], res5[1], res5[2]);
					break;

				default:
					break;
				}
			}

			if (prodid != null && sdate != null && fdate != null && location != null) {
				this.vevent = new Event(url, sdate, fdate, summary, location);
				this.prodid = prodid;
			} else {
				throw new NotSupportedFileException(file);
			}

			br.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param s
	 * @return true if one of the attributes contains the String s
	 */
	public boolean machingString(String s) {
		return prodid.machingString(s) || vevent.machingString(s);
	}

	/**
	 * Prints the VCalendar in the terminal.
	 */
	public void print() {
		System.out.println(this.toString());
	}

	/**
	 * 
	 * @return prodid
	 */
	public Prodid getProdid() {
		return prodid;
	}

	/**
	 * 
	 * @param prodid
	 */
	public void setProdid(Prodid prodid) {
		this.prodid = prodid;
	}

	/**
	 * 
	 * @return vevent
	 */
	public Event getVevent() {
		return vevent;
	}

	/**
	 * 
	 * @param vevent
	 */
	public void setVevent(Event vevent) {
		this.vevent = vevent;
	}
}

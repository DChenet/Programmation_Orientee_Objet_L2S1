package virtualobjects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import database.Adress;
import database.Contact;
import database.Phone;
import exceptions.NotSupportedFileException;

/**
 * 
 * @author Javadoc CHOLLET Alexis
 * @author Class CHOLLET Alexis
 * @author Javadoc CHENET Dorian
 * @author Class CHENET Dorian
 *
 */
public class Card extends VirtualObjectAbstract implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Contact contact;

	/**
	 * 
	 * @param contact
	 */
	public Card(Contact contact) {
		this.contact = contact;
	}

	/**
	 * Creates a blank Card object.
	 */
	public Card() {
		this.contact = new Contact();
	}

	/**
	 * Returns VCard generated with attribute contact.
	 * 
	 * @return card
	 */
	public String toString() {
		return "BEGIN:VCARD \n" + "VERSION:3.0 \n" + contact.toString() + "END:VCARD \n";

	}

	/**
	 * Returns an Html Fragment as a String generated from attribute contact
	 * 
	 * @return frag
	 */
	public String getHtmlFragment() {
		String frag;

		frag = " <div class=\"vcard\"> \n";
		frag += "<abbr class=\"name\" title=\"Person\">";
		frag += contact.getCivility() + " " + contact.getFirstName() + " " + contact.getLastName() + "\n";
		frag += "</abbr> \n";
		frag += " <div class=\"adr\"> \n";

		Adress adr = contact.getAdress();

		frag += " <span class=\"type\">" + adr.getType() + "</span>: \n";
		frag += " <div class=\"street-address\">" + adr.getStreet() + "</div> \n";
		frag += " <span class=\"locality\">" + adr.getCity() + "</span>,";
		frag += " <abbr class=\"region\" title=\"Region\">" + adr.getState() + "</abbr> \n";
		frag += " <span class=\"postal-code\">" + adr.getPostal() + "</span> \n";
		frag += " <div class=\"country-name\">" + adr.getCountry() + "</div> \n";
		frag += " </div>";

		Phone pho = contact.getPhone();

		frag += "<div class=\"tel\"> \n";
		frag += "<span class=\"type\">" + pho.getPlace() + "</span> " + pho.getNumber() + "\n</div> \n";
		frag += "</div> \n";

		return frag;
	}

	/**
	 * Sets the attribute contact by extracting data from file.
	 * 
	 * @param file
	 * @throws NotSupportedFileException
	 */
	@SuppressWarnings("resource")
	public void loadVcfFile(String file) throws NotSupportedFileException {
		String ligne = null;
		try {

			BufferedReader br = new BufferedReader(new FileReader(file));

			String lastname = "aaa";
			String firstname = null;
			String email = null;
			Phone phone = new Phone();
			Adress adress = new Adress();
			String title = null;
			String civility = null;
			String company = null;
			boolean stop = false;

			while (!stop) {

				ligne = br.readLine();
				String[] res = ligne.split(":");

				switch (res[0]) {

				case "N":
					String[] res2 = res[1].split(";");
					lastname = res2[0];
					firstname = res2[1];
					civility = res2[3];
					break;

				case "ORG":
					company = res[1];
					break;

				case "TITLE":
					title = res[1];
					stop = true;
					break;
				}
			}

			while ((ligne = br.readLine()) != null) {

				String[] res = ligne.split(";");
				String[] mail = ligne.split(":");

				if (res[0].equals("TEL")) {
					String[] tel = res[1].split(",");
					String[] typetel = tel[0].split("=");
					String[] voice = tel[1].split("=");
					String[] voice2 = voice[0].split(":");

					phone = new Phone(typetel[1], voice2[1]);
				}

				if (res[0].equals("ADR")) {
					String[] typeadr1 = res[1].split(",");
					String[] typeadr2 = typeadr1[0].split("=");
					adress = new Adress(typeadr2[1], res[3], res[4], res[5], res[6], res[7]);

				}

				if (mail[0].equals("EMAIL")) {
					email = mail[1];
				}
			}

			if (phone != null && adress != null) {
				this.contact = new Contact(lastname, firstname, email, phone, adress, title, civility, company);
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
		return contact.machingString(s);
	}

	/**
	 * Prints the VCard in the terminal.
	 */
	public void print() {
		System.out.println(this.toString());
	}

	/**
	 * 
	 * @return
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * 
	 * @param contact
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		return true;
	}

}

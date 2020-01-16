package database;

import java.io.Serializable;

/**
 * 
 * @author Javadoc CHOLLET Alexis
 * @author Class CHENET Dorian
 *
 */
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lastname;
	private String firstname;
	private String email;
	private Phone phone;
	private Adress adress;
	private String title;
	private String civility;
	private String company;

	/**
	 * 
	 * @param lastname
	 * @param firstname
	 * @param email
	 * @param phone
	 * @param adress
	 * @param title
	 * @param civility
	 * @param company
	 */
	public Contact(String lastname, String firstname, String email, Phone phone, Adress adress, String title,
			String civility, String company) {

		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
		this.title = title;
		this.civility = civility;
		this.company = company;
	}

	/**
	 * Creates a blank Contact object.
	 */
	public Contact() {
		this.lastname = "";
		this.firstname = "";
		this.email = "";
		this.phone = new Phone();
		this.adress = new Adress();
		this.title = "";
		this.civility = "";
		this.company = "";
	}

	/**
	 * 
	 * @param s
	 * @return true if one of the attributes contains the String s
	 */
	public boolean machingString(String s) {
		return firstname.contains(s) || lastname.contains(s) || email.contains(s) || title.contains(s)
				|| civility.contains(s) || company.contains(s) || adress.machingString(s) || phone.machingString(s);
	}

	/**
	 * 
	 * @return phone
	 */
	public Phone getPhone() {
		return phone;
	}

	/**
	 * 
	 * @param phone
	 */
	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	/**
	 * 
	 * @return adress
	 */
	public Adress getAdress() {
		return adress;
	}

	/**
	 * 
	 * @param adress
	 */
	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	/**
	 * 
	 * @return lastname
	 */
	public String getLastName() {
		return lastname;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	/**
	 * 
	 * @return firstname
	 */
	public String getFirstName() {
		return firstname;
	}

	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	/**
	 * 
	 * @return email
	 */
	public String geteMail() {
		return email;
	}

	/**
	 * 
	 * @param eMail
	 */
	public void seteMail(String eMail) {
		this.email = eMail;
	}

	/**
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return civility
	 */
	public String getCivility() {
		return civility;
	}

	/**
	 * 
	 * @param civility
	 */
	public void setCivility(String civility) {
		this.civility = civility;
	}

	/**
	 * 
	 * @return company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * 
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "N:" + lastname + ";" + firstname + ";;" + civility + "; \n" + "FN:" + firstname + " " + lastname + "\n"
				+ "ORG:" + company + "\n" + "TITLE:" + title + "\n" + phone.toString() + adress.toString() + "EMAIL:"
				+ email + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((civility == null) ? 0 : civility.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Contact other = (Contact) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (civility == null) {
			if (other.civility != null)
				return false;
		} else if (!civility.equals(other.civility))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}

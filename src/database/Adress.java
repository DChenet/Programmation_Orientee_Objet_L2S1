package database;

import java.io.Serializable;

/**
 * 
 * @author Javadoc CHOLLET Alexis
 * @author Class CHOLLET Alexis
 *
 */
public class Adress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private String street;
	private String city;
	private String state;
	private String postal;
	private String country;

	/**
	 * 
	 * @param type
	 * @param street
	 * @param city
	 * @param state
	 * @param postal
	 * @param country
	 */
	public Adress(String type, String street, String city, String state, String postal, String country) {
		this.type = type;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postal = postal;
		this.country = country;
	}

	/**
	 * Creates a blank Adress objects.
	 */
	public Adress() {
		this.type = "";
		this.street = "";
		this.city = "";
		this.state = "";
		this.postal = "";
		this.country = "";
	}

	/**
	 * 
	 * @param s
	 * @return true if one of the attributes contains the String s
	 */
	public boolean machingString(String s) {
		return type.contains(s) || street.contains(s) || city.contains(s) || state.contains(s) || postal.contains(s)
				|| country.contains(s);

	}

	/**
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * 
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 
	 * @return postal
	 */
	public String getPostal() {
		return postal;
	}

	/**
	 * 
	 * @param postal
	 */
	public void setPostal(String postal) {
		this.postal = postal;
	}

	/**
	 * 
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "ADR;TYPE=" + type + ",PREF:;;" + street + ";" + city + ";" + state + ";" + postal + ";" + country + "\n"
				+ "LABEL;TYPE=" + type + ",PREF:" + street + " " + city + "," + state + " " + postal + " " + country
				+ "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((postal == null) ? 0 : postal.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Adress other = (Adress) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (postal == null) {
			if (other.postal != null)
				return false;
		} else if (!postal.equals(other.postal))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}

package database;

import java.io.Serializable;

/**
 * 
 * @author Javadoc CHOLET Alexis
 * @author Class CHENET Dorian
 *
 */
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String place;
	private String number;

	/**
	 * 
	 * @param place
	 * @param number
	 */
	public Phone(String place, String number) {
		this.place = place;
		this.number = number;
	}

	/**
	 * Creates a blank Phone object.
	 */
	public Phone() {
		this.place = "";
		this.number = "";
	}

	/**
	 * 
	 * @param s
	 * @return true if one of the attributes contains the String s
	 */
	public boolean machingString(String s) {
		return place.contains(s) || number.contains(s);
	}

	/**
	 * 
	 * @return place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * 
	 * @param place
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * 
	 * @return number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * 
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "TEL;TYPE=" + place + ",VOICE:" + number + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
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
		Phone other = (Phone) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		return true;
	}

}

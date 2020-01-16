package database;

import java.io.Serializable;

/**
 * 
 * @author Javadoc CHOLLET Alexis
 * @author Class CHOLLET Alexis
 *
 */
public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String place;
	private String city;
	private String state;

	/**
	 * 
	 * @param place
	 * @param city
	 * @param state
	 */
	public Location(String place, String city, String state) {
		this.place = place;
		this.city = city;
		this.state = state;
	}

	/**
	 * Creates a blank Location object.
	 */
	public Location() {
		this.place = "";
		this.city = "";
		this.state = "";
	}

	/**
	 * 
	 * @param s
	 * @return true if one of the attributes contains the String s
	 */
	public boolean machingString(String s) {
		return place.contains(s) || city.contains(s) || state.contains(s);
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

	@Override
	public String toString() {
		return "LOCATION:" + place + "\\, " + city + "\\, " + state + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Location other = (Location) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

}

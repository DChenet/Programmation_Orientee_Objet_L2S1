package database;

import java.io.Serializable;

/**
 * 
 * @author Javadoc CHOLET Alexis
 * @author Class CHENET Dorian
 *
 */
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url;
	private Date sdate;
	private Date fdate;
	private String summary;
	private Location location;

	/**
	 * 
	 * @param url
	 * @param sdate
	 * @param fdate
	 * @param summary
	 * @param location
	 */
	public Event(String url, Date sdate, Date fdate, String summary, Location location) {
		this.url = url;
		this.sdate = sdate;
		this.fdate = fdate;
		this.summary = summary;
		this.location = location;
	}

	/**
	 * Creates a blank vevent object.
	 */
	public Event() {
		this.url = "";
		this.sdate = new Date();
		this.fdate = new Date();
		this.summary = "";
		this.location = new Location();
	}

	/**
	 * 
	 * @param s
	 * @return true if one of the attributes contains the String s
	 */
	public boolean machingString(String s) {
		return url.contains(s) || sdate.machingString(s) || fdate.machingString(s) || summary.contains(s)
				|| location.machingString(s);
	}

	/**
	 * 
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 
	 * @return sdate
	 */
	public Date getSdate() {
		return sdate;
	}

	/**
	 * 
	 * @param sdate
	 */
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	/**
	 * 
	 * @return fdate
	 */
	public Date getFdate() {
		return fdate;
	}

	/**
	 * 
	 * @param fdate
	 */
	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}

	/**
	 * 
	 * @return summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * 
	 * @param summary
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * 
	 * @return locatio,
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * 
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Returns a VEvent file as string.
	 */
	@Override
	public String toString() {
		return "BEGIN:VEVENT \n" + "URL:" + url + "\n" + "DTSTART:" + sdate.getFullDate() + "\n" + "DTEND:"
				+ fdate.getFullDate() + "\n" + "SUMMARY:" + summary + "\n" + location.toString() + "END:VEVENT \n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fdate == null) ? 0 : fdate.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((sdate == null) ? 0 : sdate.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Event other = (Event) obj;
		if (fdate == null) {
			if (other.fdate != null)
				return false;
		} else if (!fdate.equals(other.fdate))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (sdate == null) {
			if (other.sdate != null)
				return false;
		} else if (!sdate.equals(other.sdate))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

}

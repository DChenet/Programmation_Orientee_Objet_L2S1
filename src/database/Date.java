package database;

import java.io.Serializable;

/**
 * 
 * @author Javadoc CHOLLET Alexis
 * @author Class CHENET Dorian
 *
 */
public class Date implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String year;
	private String month;
	private String day;

	/**
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public Date(String year, String month, String day) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * Creates a blank Date object.
	 */
	public Date() {
		this.day = "";
		this.month = "";
		this.year = "";
	}

	/**
	 * 
	 * @param s
	 * @return true if one of the attributes contains the String s
	 */
	public boolean machingString(String s) {
		return day.contains(s) || month.contains(s) || year.contains(s);
	}
	
	/**
	 * 
	 * @return Date as string yy/mm/dd.
	 */
	public String getFullDate() {
		return year+month+day;
	}

	/**
	 * 
	 * @return year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 
	 * @return month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * 
	 * @return day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * 
	 * @param day
	 */
	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Date [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		Date other = (Date) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

}

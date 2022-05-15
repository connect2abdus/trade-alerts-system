package com.dbassignment.tradesurveillance.model;

public class TradeAlert {

	//private Long tradingCount;
	
	private String firstName;

	private String lastName;

	private String nationality;

	private String countryOfResidence;

	private String dateOfBirth;

	private String traderId;

	private String stockId;

	/**
	 * @param tradingCount
	 * @param firstName
	 * @param lastName
	 * @param nationality
	 * @param countryOfResidence
	 * @param dateOfBirth
	 * @param traderId
	 * @param stockId
	 */
	public TradeAlert(/*Long tradingCount,*/ String firstName, String lastName, String nationality,
			String countryOfResidence, String dateOfBirth, String traderId, String stockId) {
		super();
		//this.tradingCount = tradingCount;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
		this.countryOfResidence = countryOfResidence;
		this.dateOfBirth = dateOfBirth;
		this.traderId = traderId;
		this.stockId = stockId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the countryOfResidence
	 */
	public String getCountryOfResidence() {
		return countryOfResidence;
	}

	/**
	 * @param countryOfResidence the countryOfResidence to set
	 */
	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the traderId
	 */
	public String getTraderId() {
		return traderId;
	}

	/**
	 * @param traderId the traderId to set
	 */
	public void setTraderId(String traderId) {
		this.traderId = traderId;
	}

	/**
	 * @return the stockId
	 */
	public String getStockId() {
		return stockId;
	}

	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TradeAlert [firstName=" + firstName + ", lastName=" + lastName + ", nationality=" + nationality
				+ ", countryOfResidence=" + countryOfResidence + ", dateOfBirth=" + dateOfBirth + ", traderId="
				+ traderId + ", stockId=" + stockId + "]";
	}

	// private Timestamp reportingtime;

}

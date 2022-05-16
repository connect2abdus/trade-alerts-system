package com.dbassignment.tradesurveillance.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "traderinfo")
public class TraderInfo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName; 

	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "country")
	private String countryOfResidence;

	@Column(name = "dateofbirth")
	private String dateOfBirth;
	
	@Column(name = "traderid")
	private String traderId;

	@Column(name = "stockid")
	private String stockId;

	@Column(name = "reportingtime")
	private String reportingtime;

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

	/**
	 * @return the reportingtime
	 */
	public String getReportingtime() {
		return reportingtime;
	}

	/**
	 * @param reportingtime the reportingtime to set
	 */
	public void setReportingtime(String reportingtime) {
		this.reportingtime = reportingtime;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param nationality
	 * @param countryOfResidence
	 * @param dateOfBirth
	 * @param traderId
	 * @param stockId
	 * @param reportingtime
	 */
	public TraderInfo(String firstName, String lastName, String nationality, String countryOfResidence,
			String dateOfBirth, String traderId, String stockId, String reportingtime) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
		this.countryOfResidence = countryOfResidence;
		this.dateOfBirth = dateOfBirth;
		this.traderId = traderId;
		this.stockId = stockId;
		this.reportingtime = reportingtime;
	}

	/**
	 * 
	 */
	public TraderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TraderInfoDto [firstName=" + firstName + ", lastName=" + lastName + ", nationality=" + nationality
				+ ", countryOfResidence=" + countryOfResidence + ", dateOfBirth=" + dateOfBirth + ", traderId="
				+ traderId + ", stockId=" + stockId + ", reportingtime=" + reportingtime + "]";
	}
	
}

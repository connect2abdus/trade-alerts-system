package com.dbassignment.tradesurveillance.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Abdus Mondal
 * 
 */

@Entity
@Table(name = "holdingtransactions")
public class HoldingTransactions {

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
	
	@Column(name = "tradeamount")
	private Double tradeAmount;
	
	@Column(name = "currency")
	private String currency;
		
	@Column(name = "buyorsell")
	private String buyOrSell;
	
	@Column(name = "tradeexecutiontime")
	private Timestamp tradeExecutionTime;
	
	@Column(name = "transactioncreationtime")
	private Timestamp transactionCreationTime;
	
	@Column(name = "isscanned")
	private boolean isScanned;
	
	@Column(name = "scandatetime")
	private Timestamp scanDateTime;

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param nationality
	 * @param countryOfResidence
	 * @param dateOfBirth
	 * @param traderId
	 * @param stockId
	 * @param tradeAmount
	 * @param currency
	 * @param buyOrSell
	 * @param tradeExecutionTime
	 * @param transactionCreationTime
	 * @param isScanned
	 * @param scanDateTime
	 */
	public HoldingTransactions(long id, String firstName, String lastName, String nationality,
			String countryOfResidence, String dateOfBirth, String traderId, String stockId, Double tradeAmount,
			String currency, String buyOrSell, Timestamp tradeExecutionTime, Timestamp transactionCreationTime,
			boolean isScanned, Timestamp scanDateTime) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
		this.countryOfResidence = countryOfResidence;
		this.dateOfBirth = dateOfBirth;
		this.traderId = traderId;
		this.stockId = stockId;
		this.tradeAmount = tradeAmount;
		this.currency = currency;
		this.buyOrSell = buyOrSell;
		this.tradeExecutionTime = tradeExecutionTime;
		this.transactionCreationTime = transactionCreationTime;
		this.isScanned = isScanned;
		this.scanDateTime = scanDateTime;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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

	/**
	 * @return the tradeAmount
	 */
	public Double getTradeAmount() {
		return tradeAmount;
	}

	/**
	 * @param tradeAmount the tradeAmount to set
	 */
	public void setTradeAmount(Double tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the buyOrSell
	 */
	public String getBuyOrSell() {
		return buyOrSell;
	}

	/**
	 * @param buyOrSell the buyOrSell to set
	 */
	public void setBuyOrSell(String buyOrSell) {
		this.buyOrSell = buyOrSell;
	}

	/**
	 * @return the tradeExecutionTime
	 */
	public Timestamp getTradeExecutionTime() {
		return tradeExecutionTime;
	}

	/**
	 * @param tradeExecutionTime the tradeExecutionTime to set
	 */
	public void setTradeExecutionTime(Timestamp tradeExecutionTime) {
		this.tradeExecutionTime = tradeExecutionTime;
	}

	/**
	 * @return the transactionCreationTime
	 */
	public Timestamp getTransactionCreationTime() {
		return transactionCreationTime;
	}

	/**
	 * @param transactionCreationTime the transactionCreationTime to set
	 */
	public void setTransactionCreationTime(Timestamp transactionCreationTime) {
		this.transactionCreationTime = transactionCreationTime;
	}

	/**
	 * @return the isScanned
	 */
	public boolean isScanned() {
		return isScanned;
	}

	/**
	 * @param isScanned the isScanned to set
	 */
	public void setScanned(boolean isScanned) {
		this.isScanned = isScanned;
	}

	/**
	 * @return the scanDateTime
	 */
	public Timestamp getScanDateTime() {
		return scanDateTime;
	}

	/**
	 * @param scanDateTime the scanDateTime to set
	 */
	public void setScanDateTime(Timestamp scanDateTime) {
		this.scanDateTime = scanDateTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HoldingTransactions [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", nationality=" + nationality + ", countryOfResidence=" + countryOfResidence + ", dateOfBirth="
				+ dateOfBirth + ", traderId=" + traderId + ", stockId=" + stockId + ", tradeAmount=" + tradeAmount
				+ ", currency=" + currency + ", buyOrSell=" + buyOrSell + ", tradeExecutionTime=" + tradeExecutionTime
				+ ", transactionCreationTime=" + transactionCreationTime + ", isScanned=" + isScanned
				+ ", scanDateTime=" + scanDateTime + "]";
	}

		
}

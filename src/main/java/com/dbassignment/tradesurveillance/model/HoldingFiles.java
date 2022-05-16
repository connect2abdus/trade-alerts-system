package com.dbassignment.tradesurveillance.model;

import java.sql.Timestamp;

import javax.persistence.*;
/**
 * 
 * @author Abdus Mondal
 *
 */

@Entity
@Table(name = "holdingfiles")
public class HoldingFiles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "filename")
	private String filename;

	@Column(name = "filelocation")
	private String filelocation;

	@Column(name = "isprocessed")
	private boolean isprocessed;
	
	@Column(name = "fileCreationTimestamp")
	private Timestamp fileCreationTimestamp;
	
	@Column(name = "loadstatus")
	private String loadstatus;

	@Column(name = "errorlog")
	private String errorlog;


	public HoldingFiles() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilelocation() {
		return filelocation;
	}

	public void setFilelocation(String filelocation) {
		this.filelocation = filelocation;
	}

	public boolean isIsprocessed() {
		return isprocessed;
	}

	public void setIsprocessed(boolean isprocessed) {
		this.isprocessed = isprocessed;
	}

	public Timestamp getFileCreationTimestamp() {
		return fileCreationTimestamp;
	}

	public void setFileCreationTimestamp(Timestamp fileCreationTimestamp) {
		this.fileCreationTimestamp = fileCreationTimestamp;
	}

	public String getLoadstatus() {
		return loadstatus;
	}

	public void setLoadstatus(String loadstatus) {
		this.loadstatus = loadstatus;
	}

	public String getErrorlog() {
		return errorlog;
	}

	public void setErrorlog(String errorlog) {
		this.errorlog = errorlog;
	}

	
	public HoldingFiles(long id, String filename, String filelocation, boolean isprocessed,
			Timestamp fileCreationTimestamp, String loadstatus, String errorlog) {
		super();
		this.id = id;
		this.filename = filename;
		this.filelocation = filelocation;
		this.isprocessed = isprocessed;
		this.fileCreationTimestamp = fileCreationTimestamp;
		this.loadstatus = loadstatus;
		this.errorlog = errorlog;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HoldingFiles [id=" + id + ", filename=" + filename + ", filelocation=" + filelocation + ", isprocessed="
				+ isprocessed + ", fileCreationTimestamp=" + fileCreationTimestamp + ", loadstatus=" + loadstatus
				+ ", errorlog=" + errorlog + "]";
	}

	
}

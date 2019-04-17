package com.danny.andela.andelacode.model;
import java.util.Date;

public class Member {
	private long id;
	private String fName;
	private String lName;
	private Date dateofBirth;
	
	
	public Member(){
		
		
	}
	
	public Member(long id, String fName, String lName, Date dateofBirth) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.dateofBirth = dateofBirth;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

}

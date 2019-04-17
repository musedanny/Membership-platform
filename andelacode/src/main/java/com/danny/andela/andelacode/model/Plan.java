package com.danny.andela.andelacode.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.danny.andela.andelacode.model.Member;


@XmlRootElement
public class Plan {
private long id;
private String planDescr;
private Date startDate;
private Date endDate;
private boolean planTimeStatus;
private Map<Long,Member> members= new HashMap<>();


public Plan(){
	
}
public Plan(long id,String planDescr, Date startDate, Date endDate, boolean planTimeStatus) {
	this.id = id;
	this.planDescr = planDescr;
	this.startDate = startDate;
	this.endDate = endDate;
	this.planTimeStatus = planTimeStatus;
	
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}

public String getPlanDescr() {
	return planDescr;
}
public void setPlanDescr(String planDescr) {
	this.planDescr = planDescr;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public boolean isPlanTimeStatus() {
	return planTimeStatus;
}
public void setPlanTimeStatus(boolean planTimeStatus) {
	this.planTimeStatus = planTimeStatus;
}
@XmlTransient
public Map<Long, Member> getMembers() {
	return members;
}

public void setComments(Map<Long, Member> members) {
	this.members = members;
}


}

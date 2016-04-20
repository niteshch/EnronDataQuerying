package com.textiq.model;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Email implements Serializable {
	private static final long serialVersionUID = 7794205201289026721L;
	
	private Integer emailID;
	private String subject;
	private String content;
	private Date timeSent;
	private String senderName;
	private List<String> recepientList;
	
	public Integer getEmailID() {
		return emailID;
	}
	public void setEmailID(Integer emailID) {
		this.emailID = emailID;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTimeSent() {
		return timeSent;
	}
	public void setTimeSent(Date timeSent) {
		this.timeSent = timeSent;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public List<String> getRecepientList() {
		if(recepientList == null){
			recepientList = new ArrayList<String>();
		}
		return recepientList;
	}
	public void setRecepientList(List<String> recepientList) {
		this.recepientList = recepientList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((emailID == null) ? 0 : emailID.hashCode());
		result = prime * result + ((recepientList == null) ? 0 : recepientList.hashCode());
		result = prime * result + ((senderName == null) ? 0 : senderName.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((timeSent == null) ? 0 : timeSent.hashCode());
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
		Email other = (Email) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (emailID == null) {
			if (other.emailID != null)
				return false;
		} else if (!emailID.equals(other.emailID))
			return false;
		if (recepientList == null) {
			if (other.recepientList != null)
				return false;
		} else if (!recepientList.equals(other.recepientList))
			return false;
		if (senderName == null) {
			if (other.senderName != null)
				return false;
		} else if (!senderName.equals(other.senderName))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (timeSent == null) {
			if (other.timeSent != null)
				return false;
		} else if (!timeSent.equals(other.timeSent))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Email [emailID=" + emailID + ", subject=" + subject + ", content=" + content + ", timeSent=" + timeSent
				+ ", senderName=" + senderName + ", recepientList=" + recepientList + "]";
	}

}

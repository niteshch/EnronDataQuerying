package com.textiq.model;

public class SearchQuery {
	private String senderName;
	private String recepientName;
	private String datefrom;
	private String dateto;
	@Override
	public String toString() {
		return "SearchQuery [senderName=" + senderName + ", recepientName=" + recepientName + ", datefrom=" + datefrom
				+ ", dateto=" + dateto + "]";
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getRecepientName() {
		return recepientName;
	}
	public void setRecepientName(String recepientName) {
		this.recepientName = recepientName;
	}
	public String getDatefrom() {
		return datefrom;
	}
	public void setDatefrom(String datefrom) {
		this.datefrom = datefrom;
	}
	public String getDateto() {
		return dateto;
	}
	public void setDateto(String dateto) {
		this.dateto = dateto;
	}
	

}

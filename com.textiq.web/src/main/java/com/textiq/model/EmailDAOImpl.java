package com.textiq.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmailDAOImpl implements EmailDAO{
	@Autowired
	private NamedParameterJdbcTemplate template;
	@Autowired
	private EmailResultSetExtractor extractor;
	  
	public EmailResultSetExtractor getExtractor() {
		return extractor;
	}

	public void setExtractor(EmailResultSetExtractor extractor) {
		this.extractor = extractor;
	}

	public NamedParameterJdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(NamedParameterJdbcTemplate template) {  
	    this.template = template;  
	}

	public List<Email> getEmailBySenderName(String senderName) {
		String query = "SELECT T.*,USERS.USERNAME AS RECEPIENTNAME FROM (SELECT EMAILS.*,USERS.USERNAME AS SENDERNAME, RECEPIENTS.RECEPIENTID as RID FROM EMAILS INNER JOIN USERS ON EMAILS.SENDERID = USERS.USER_ID INNER JOIN RECEPIENTS ON RECEPIENTS.EMAIL_ID = EMAILS.EMAIL_ID WHERE USERS.USERNAME = :senderName) AS T INNER JOIN USERS ON USERS.USER_ID = T.RID";
		Map<String,String> namedParameters = new HashMap<String,String>();     
		namedParameters.put("senderName", senderName);
		List<Email> emailList = this.template.query(query, namedParameters, extractor);
		return emailList;
	}

	public List<Email> getEmailByRecepientName(String recepientName) {
		String query = "SELECT T.*,USERS.USERNAME AS RECEPIENTNAME FROM "
						+ "(SELECT EMAILS.*,USERS.USERNAME AS SENDERNAME, RECEPIENTS.RECEPIENTID as RID FROM EMAILS "
						+ "INNER JOIN USERS ON EMAILS.SENDERID = USERS.USER_ID "
						+ "INNER JOIN RECEPIENTS ON RECEPIENTS.EMAIL_ID = EMAILS.EMAIL_ID "
						+ "WHERE EMAILS.EMAIL_ID IN "
							+ "(SELECT DISTINCT EMAILS.EMAIL_ID FROM EMAILS "
							+ "INNER JOIN RECEPIENTS ON RECEPIENTS.EMAIL_ID = EMAILS.EMAIL_ID "
							+ "INNER JOIN USERS ON RECEPIENTS.RECEPIENTID = USERS.USER_ID WHERE USERS.USERNAME = :recepientName)"
						+ ") AS T INNER JOIN USERS ON USERS.USER_ID = T.RID";
		Map<String,String> namedParameters = new HashMap<String,String>();     
		namedParameters.put("recepientName", recepientName);
		List<Email> emailList = this.template.query(query, namedParameters, extractor);
		return emailList;
	}

	public List<Email> getEmailWithDateRange(String from, String to) {
		String query = "SELECT T.*,USERS.USERNAME AS RECEPIENTNAME FROM (SELECT EMAILS.*,USERS.USERNAME AS SENDERNAME, RECEPIENTS.RECEPIENTID as RID FROM EMAILS INNER JOIN USERS ON EMAILS.SENDERID = USERS.USER_ID INNER JOIN RECEPIENTS ON RECEPIENTS.EMAIL_ID = EMAILS.EMAIL_ID) AS T INNER JOIN USERS ON USERS.USER_ID = T.RID WHERE T.timesent >= :datefrom::timestamp and T.timesent <= :dateto::timestamp";
		Map<String,String> namedParameters = new HashMap<String,String>();     
		namedParameters.put("datefrom", from);
		namedParameters.put("dateto", to);
		List<Email> emailList = this.template.query(query, namedParameters, extractor);
		return emailList;
	}

}

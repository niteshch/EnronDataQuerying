package com.textiq.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class EmailResultSetExtractor implements ResultSetExtractor<List<Email>> {

	public List<Email> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Email> emailMap = new HashMap<Integer, Email>();
		while(rs.next()){
			int emailId = rs.getInt("email_id");
			Email email = emailMap.get(emailId);
			if(email != null){
				email.getRecepientList().add(rs.getString("recepientname"));
			}else{
				email = new Email();
				String content = rs.getString("content");
//				content= content.replaceAll("(\r\n|\n|\\n)", "<br />");
				email.setEmailID(emailId);
				email.setSubject(rs.getString("subject"));
				email.setContent(content);
				email.setTimeSent(rs.getDate("timesent"));
				email.setSenderName(rs.getString("sendername"));
				email.getRecepientList().add(rs.getString("recepientname"));
			}
			emailMap.put(emailId, email);
		}
		return new ArrayList<Email>(emailMap.values());
	}
}
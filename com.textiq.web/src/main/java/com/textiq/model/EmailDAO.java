package com.textiq.model;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public interface EmailDAO {
	/**
	 * This is the method to be used to initialize database resources ie.
	 * connection.
	 */
	public void setTemplate(NamedParameterJdbcTemplate template);

	public List<Email> getEmailBySenderName(String senderName);

	public List<Email> getEmailByRecepientName(String recepientName);

	public List<Email> getEmailWithDateRange(String from, String to);
}
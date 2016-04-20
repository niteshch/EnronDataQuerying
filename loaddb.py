import sys
import json
import os
import psycopg2
from sqlalchemy import *
from sqlalchemy.exc import IntegrityError
from datetime import datetime
import time
from sqlalchemy.pool import NullPool
DATABASEURI = "postgresql://postgres:@localhost:5432/textiq"


engine = create_engine(DATABASEURI)


engine.execute("""DROP TABLE IF EXISTS users;""")
engine.execute("""DROP TABLE IF EXISTS emails;""")
engine.execute("""DROP TABLE IF EXISTS recepients;""")
#engine.execute("""DROP TABLE IF EXISTS users;""")
idsquery = text("CREATE TABLE IF NOT EXISTS users (user_id varchar(30) primary key,username varchar(1000));")
emailsquery = text("CREATE TABLE IF NOT EXISTS emails (email_id serial primary key, subject text,content text, timeSent timestamp, senderId	varchar(30), FOREIGN KEY (senderId) REFERENCES users(user_id));")
recepientsquery = text("CREATE TABLE IF NOT EXISTS recepients (email_id integer, recepientId varchar(30),FOREIGN KEY (recepientId) REFERENCES users(user_id));")

engine.execute(idsquery)
engine.execute(emailsquery)
engine.execute(recepientsquery)

with open('ids.json') as data_file:    
    data = json.load(data_file)
    for key, value in data.items():
    	query = text("INSERT INTO users values(:user_id,:username)")
    	engine.execute(query,user_id=key,username=value)

emailInsert = text("INSERT INTO emails (subject ,content , timeSent , senderId) values (:subject,:content,:timeSent,:senderId)")
recepientInsert = text("INSERT INTO recepients (email_id ,recepientId) values (:email_id,:recepientId)")
with open('emails.json') as data_file:    
    data = json.load(data_file)
    for x in data:
    	timeSent = None
    	subject=x['subject']
    	content=x['content'].encode('utf-8').encode('string_escape')
    	senderId=x['senderId']
    	try:
    		timeSent = datetime.fromtimestamp(x['timeSent']/1e3)
    	except:
    		print x['timeSent']
    	try:
    		engine.execute(emailInsert,subject=subject,content=content,timeSent=timeSent,senderId=senderId)
    		query = text("SELECT currval(pg_get_serial_sequence('emails','email_id')) as email_id;")
	    	result = engine.execute(query)
	    	row = result.fetchone()
	    	email_id = row['email_id']
	    	for recepientId in x['recipientIds']:
	    		try:
	    			engine.execute(recepientInsert,email_id=email_id,recepientId=recepientId)
	    		except:
	    			print sys.exc_info()
	    			print "Recepient Insert Failed: ",recepientId," Email ID:", email_id
    	except IntegrityError:
    		# print sys.exc_info()
    		print "SenderID Not found: ",senderId





# EnronDataQuerying
This web application can be used for querying enron email data. The data is contained in 2 json files in the repository, namely - emails.json, ids.json

You need to first load the data into the PostgreSQL DB using the loaddb.py file provided.

## How it works


### Pre-requisites
- Install JDK 8
- Install PostgresSQL
- Install Tomcat 8
- Install Maven

### Application Set Up
Check out the code from the repository. Update the loaddb.py file and change the database URI
```
DATABASEURI = "postgresql://postgres:@localhost:5432/textiq"
```

Also, update the path of the json file in case the files are located elsewhere on your system.
Run the python script to load the data into the PostgreSQL database.
```
python loaddb.py
```

Update the data source configuration in `spring-web-servlet.xml` file in the `com.textiq.web/src/main/webapp/WEB-INF/` directort
```
<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="org.postgresql.Driver" />
		<property name="url" value="jdbc:postgresql://localhost:5432/textiq" />
		<property name="username" value="postgres" />
		<property name="password" value="*****" />
</bean>
```
Run `mvn clean install` in `com.textiq.web` directory

Copy the war file from `com.textiq.web/target` directory and paste it into the webapps folder of tomcat

Start tomcat server and you can access the application using the following URL:
[http://localhost:8080/textiq/email/](http://localhost:8080/textiq/email/)

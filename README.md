# jpa-javaee8

This is a project to show how to use Java Persistence API (JPA) from Java EE.

## Technologies

- Maven
- Java EE (JPA)

## Getting Started

The Java EE application will be deployed in a web server like Glassfish, Payara or WildFly.

### Deployment on Payara

1. Install Payara (MacOS):

    ```
    brew install payara
    ```

2. Start Payara:

    ```
    asadmin start-domain --verbose domain
    ```

3. Copy database driver. To use Payara server with MySQL you will have to download [Connector/J 5.1.49](https://dev.mysql.com/downloads/connector/j/5.1.html) and place it in `/usr/local/Cellar/payara/5.192/libexec/glassfish/lib`
4. Go to Payara administration console at `localhost:8080`. The first time it will ask you to set a password for the admin user.
5. Configure a JDBC connection pool: Go to "Resources">"JDBC">"JDBC Connection Pools" and click on "New..." Select:
    - Name: `MySQLPool`
    - Resource Type: `javax.sql.DataSource`
    - Datasource Classname: `com.mysql.jdbc.jdbc2.optional.MysqlDataSource`
    - Add the following "Additional Properties":
        * `DatabaseName`: `jpa_example`
        * `UseSSL`: `false`
        * `Password` `<your_mysql_password>`
        * `URL`: `jdbc:mysql://:3306/jpa_example`
        * `Url`: `jdbc:mysql://:3306/jpa_example`
        * `ServerName`: `localhost`
        * `PortNumber`: `3306`
        * `User`: `<your_mysql_user>`
        
>The MySQL root user does not work

5. Now you should be able to ping the database.
6. Add JDBC Resource: Go to "JDBC">"JDBC Resources" and click on "New...":
    - JNDI Name: Choose the desired JNDI name that will be used by the Java EE application.
    - Pool Name: `MySQLPool`
    - Enabled: true                                                 
7. Build Java EE application:

    ```
    mvn clean install
    ```

8. Deploy Java EE application: go to Applications>Deploy... and choose the file 
  `jpa-javaee8/target/jpa-javaee8.war` to deploy the Java EE application.
9. Go to the `jpa-javaee8` configuration and change the context root to `/jpa-javaee8`.
10. Access API:
```
http://localhost:8080/jpa-javaee8/jpa
```
  
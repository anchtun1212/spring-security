# Spring Security, Spring Boot Security, CORS, CSRF, JWT, OAUTH2, OpenID Connect, KeyCloak

# Create new Database and new user

sudo -u postgres psql

postgres=# create database springdb;

postgres=# create user springuser with encrypted password 'springpass';

postgres=# grant all privileges on database springdb to springuser;

# Notes

- When we want to load the user details based on our own tables, columns, custom logic, then we need to create a bean that implements `UserDetailsService` and overrides the method `loadUserByUsername`. 


- By default, spring security framework is going to stop all POST/PUT requests that are going to update the data inside the database or inside the back end.
So all such requests will be blocked by default just to make sure to avoid the CSRF attack.

# Tips

- Please note that when you add `spring-boot-starter-security` in the `pom.xml`, spring will secure your application.

The default credentials are:

`username`: user

`password`: will be generated and you can see it in the `console` when you run the application.

- If you don't know/forget some spring properties go to: 
https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html

and for spring security go to: 
https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.security

- You can use static username and password for POC purpose for example by adding those two lines in the `application.properties`

`spring.security.user.name`=yourstaticusername

`spring.security.user.password`=yourstaticpassword

- Go to `org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl` to see the queries and schema (dll) used by spring (by default) when you use `JdbcUserDetailsManager`: Spring expect that the tables exists.


- To create the same tables inside your application go to: 
https://docs.spring.io/spring-security/site/docs/4.2.x/reference/html/appendix-schema.html 
and copy/paste User Schema scripts, but change `varchar_ignorecase` to `varchar`.

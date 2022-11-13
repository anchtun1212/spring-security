# Spring Security, Spring Boot Security, CORS, CSRF, JWT, OAUTH2, OpenID Connect, KeyCloak

# Tips

- Please note that when you add `spring-boot-starter-security` in the `pom.xml`, spring will secure your application.

The default credentials are:

`username`: user

`password`: will be generated and you can see it in the `console` when you run the application.

- If you don't know/forget some spring properties go to:  `https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html` 

and for spring security go to: 

`https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.security`

- You can use static username and password for POC purpose for example by adding those two lines in the `application.properties`

`spring.security.user.name`=yourstaticusername

`spring.security.user.password`=yourstaticpassword

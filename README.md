# Demo Patient Tracker App Backend

Read more about this project on the [patient-js](https://github.com/JayMartMedia/patient-js) repository. 

This Spring application connects to a PostgreSQL database and presents a REST API which is used by the patient-js web application. 

## Tools Used
+ #### Backend [patient-service](https://github.com/JayMartMedia/patient-service)
    + [Spring Boot](https://spring.io/projects/spring-boot) - Popular Java framework for building REST APIs
    + [Spring Boot Security](https://spring.io/projects/spring-security#overview) - Used for user login and protecting rest endpoints
    + [PostgreSQL](https://www.postgresql.org/) - Open source relational database system
    
# Starting the Application
View the [Starting the Application](https://github.com/JayMartMedia/patient-js#starting-the-application) section on the patient-js readme for information about starting the application.

# Areas of Improvement
+ Users are currently hardcoded into the [ApplicationSecurityConfig](https://github.com/JayMartMedia/patient-service/blob/master/src/main/java/com/jaymartmedia/patientservice/security/ApplicationSecurityConfig.java#L59) - [Move them into the database](https://github.com/JayMartMedia/patient-service/issues/6)
+ [Add user registration](https://github.com/JayMartMedia/patient-service/issues/8)

#customer orders api

Required
    maven 3.0+
    java 1.8 or later version



Project runs with embedded in memory H2 database

To run the project:
    open cmd:
    cd  {project location}\bite\commerce
    mvn spring-boot:run

for testing purposes:
    mock data can be found at:
    src/main/java/resources/data.sql

    api test can be accessed via:
    http://localhost:8080/swagger-ui.html


Built with:
    spring boot 2.2.6.RELEASE
    H2 Database 1.4.200
    spring boot hateoas

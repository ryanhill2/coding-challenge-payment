Prerequisites
====
How to get setup
We have 3 parts to the setup.
1. A springboot application build using java 17 using maven.
2. A python web application using flask.
3. A docker container running a postgres database.

1.1. Springboot application will create the database tables and populate them with data
via the REST API endpoints. 

1.2 to set this application you will need java installed on your machine. 
I'm using Java 17.0.1. I would suggest you use the same version.

1.3 You will also need maven installed on your machine. I'm using 
maven 3.8.6. I would suggest you use the same version.

2.1 The python application will expose one REST API to get the EUR to GBP exchange rate.
the springboot application will call this API to get the exchange rate on port 5000.

2.2 to set this application you will need python installed on your machine.
I'm using python 3.8 I would suggest you use the same version.


How to run the applications
====
Once all the above is installed run the applications.

To run the springboot application run the following command in the root of the java project.
- run mvn clean install
- mvn spring-boot:run

To run the python application run the following command in the root of the python project.
- export FLASK_APP=exchange_rate_service_v1.py
- flask run

To run the docker container run the following command in the root of the solution project.
- docker-compose up

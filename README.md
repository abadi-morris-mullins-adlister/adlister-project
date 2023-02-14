AdLister Project
Introduction
AdLister is an online platform for classified advertisements. It is a web-based application that allows registered users to create, read, update, and delete advertisements. The application is built using Java technologies like MySQL, DAOs, Servlets, Java Beans, and JSP files.

Requirements
To run AdLister on your local machine, you need to have the following installed:

Java 8 or higher
Apache Tomcat 8 or higher
MySQL 5.6 or higher
Setup
To set up AdLister on your local machine, follow the steps below:

Clone the AdLister repository to your local machine.
Import the project into your favorite IDE.
Create a MySQL database and a user account.
Update the database credentials in the config.properties file located in the src/main/resources folder.
Run the SQL script located in the src/main/resources folder to create the necessary tables and insert sample data.
Build the project using the mvn clean package command.
Deploy the WAR file located in the target folder to your Apache Tomcat server.
Architecture
AdLister follows a layered architecture that separates the business logic, data access, and presentation layers. The application consists of the following components:

DAOs: Data Access Objects are responsible for retrieving and updating data from the MySQL database. They use JDBC to connect to the database and execute SQL queries. The DAOs in AdLister are implemented using the Singleton design pattern to ensure only one instance of each DAO exists at runtime.
Java Beans: Java Beans are POJOs (Plain Old Java Objects) that represent the data entities in AdLister. They are used to transfer data between the DAOs and the servlets.
Servlets: Servlets are the main entry point for handling HTTP requests in AdLister. They receive HTTP requests from the clients, extract the necessary data, interact with the DAOs to retrieve or update data, and send the HTTP responses back to the clients. AdLister uses the Model-View-Controller (MVC) pattern to separate the logic of handling HTTP requests from the presentation layer.
JSP files: JSP files are used to generate the HTML pages that are sent back to the clients. They use Java Beans to retrieve data from the servlets and display them in a user-friendly way.
Usage
To use AdLister, follow the steps below:

Open your web browser and go to http://localhost:8080/AdLister/.
Register a new account by clicking the "Log in" link in the top right corner of the page and then the register button below.
Login to your account by clicking the "Log in" link and entering your username and password.
Create a new advertisement by clicking the "Create Ad" link and filling in the form.
View your advertisements by clicking the "My Ads" link in the top right corner of the page.
Edit or delete your advertisements by clicking the "Edit" or "Delete" links next to each ad.
Conclusion
AdLister is a simple yet powerful application that demonstrates the use of Java technologies like MySQL, DAOs, Servlets, Java Beans, and JSP files to build web-based applications. With AdLister, users can easily create, read, update, and delete classified advertisements in a user-friendly way.
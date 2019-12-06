# SLU-Twitter
A clone of Twitter social network, providing simple features such as:
- user accounts and a database authentication system
- ability to follow other users and be followed
- tweet both text and images

## About Project
The focus of the project is not necessarily the cloning the full functionality of Twitter, rather a demonstration of dexterity with MariaDB DBMS in managing and persisting data for a social media web application such as Twitter.

### To compile the project
Create a classes directory with the command `mkdir classes` for contain the compiled files

Execute the command `javac -cp .:libs/* -d classes/ *.java` in the root directory to compile the project

### To run the project
The entry point for the project is the `Controller.class` file

Run the project with `cd classes; java -cp .:../libs/* Controller`

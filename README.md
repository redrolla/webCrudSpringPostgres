# webCrudSpringPostgres
https://spring-crud-postgres.herokuapp.com/users
(deployed on heroku, first load can be long 5-10 secs, please be patient)

Core application part is Spring, view uses thymeleaf, working with postgresql database via jpa.

Screenshot of a main page is in repository folder

Functional:

    Add new user: 
      top side of home page, fill up the fields and press "submit" ("reset" if you want to make the fields empty),
      the error warning will appear if you enter something wrong, and you can retry
      User table bellow will refresh after adding a user.
    
    Edit user:
      last two columns are "edit" and "delete"
      press edit to be redirected to edit page, change information as you wish, the error warning will appear if you enter something wrong, and you can retry
      
    Delete user:
      press delete to delete user

DataBase propeties:

    File name - application.properties
    Currently postgresql is connected
    
    DB currently has one table called "users" with fields:
    id;login;password;email;phone_number
    "id" is primary key, autoincrement
    
    
SQL script (for postgresql):
    DROP TABLE IF EXISTS users;

    CREATE SEQUENCE users_id_seq;

    CREATE TABLE users(
    	id bigint NOT NULL PRIMARY KEY DEFAULT nextval('users_id_seq'),
    	login text,
    	password text,
    	email text,
    	phone_number text
    );
    INSERT INTO users VALUES (1,'tony','montana','miamy@gold.usd','0123456789');

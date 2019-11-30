# webCrudSpringPostgres

Core application part is Spring, view uses thymeleaf, working with postgresql database via jpa

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
    
    
    

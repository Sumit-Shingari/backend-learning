This project has been created by Sumit Shingari for learning purpose.

Basic Outline
#####################################################################
This project demonstrate a working example on how to multi login functionality using spring boot + JPA + spring security + JWT + spring social + thymeleaf.

In this project we have made use of spring social to perform login using facebook.
 
 We have used JWT along with spring security for authentication, and we have storing the JWT token in cookies.
 
 Also we have provided a simple functionality to disable editing and deleting of facebook user.
 
 Once a facebook user has been logged in, his details are stored in database. so he can login directly using his facebook name as username and email as password.
 
 Once a user has logged in using facebook must not login again using the same id, as this is a demo project and does not validate any duplicate user.
 
 In case if duplicate user the authentication process will throw exception in the application.
 
 Please make sure the cookie created in this project is destroyed by clicking on "Back to login" from the index page.
 
#####################################################################
This project is just to demonstrate multi login process along with spring security + JWT + thymeleaf.

If you have any query or anything to express.
contact me on my email id : sumit007shingari@gmail.com

# Songr

This Site is solution for Java401d5, and it's contains a wep application that Uses Spring boots, and thymeleaf.

## Usage

This Site contains some end point mapping:

1. `/` The Root end point that will great you and display the browser and operating system the user use.
2. `/hello?name={YourName}` The user greeting end point that rquiers the user to enter their name and the page will
   display Custom Greeting for the entered name
3. `/albums` This end point will display some albums that are stored in the database.
4. `/capitalize/${word}` This end point will display the entered word WITH ALL UPPER CASE.
# Songr

This Site is solution for Java401d5, and it's contains a wep application that Uses Spring boots, and thymeleaf.

> Most of this Site feature are still in localhost and not on the internet.

## Usage

To Start the Application run the following command in the terminal:
`$ gradle bootRun`
and this will start Spring boot server at port 8080.

> http://localhost:8080/

This Site contains some end point mapping:

* Get:
    1. `/` The Root end point that will great you and display the browser and operating system the user use.
    2. `/hello?name={YourName}` The user greeting end point that rquiers the user to enter their name and the page will
       display Custom Greeting for the entered name
    3. `/albums` This end point will display some albums that are stored in the database.
    4. `/capitalize/${word}` This end point will display the entered word WITH ALL UPPER CASE.
    5. `/albums/{albumTitle}` This end point will display html page with the required album title
* POST:
    1. `addAlbum` This method will take a json body as request and save it to the created Data base while returning the
       data of the created database, this end point are duplicate save so when creating duplicating title the response
       will be "Duplicated title"
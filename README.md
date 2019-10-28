# Phonebook Application
A simple Console Application similar with a PhoneBook Manager

# Prerequisites
You need to have at least JDK8 installed in your machine, in order for the application to run. You can [click here](https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html)
for reading a tutorial on how to install JDK in Windows and/or Ubuntu

# Installation
This Application does not require any specific installation. You just need to download it locally, and after that you simple run the code.

# Running the Application
  1. After you have download the app, you open your CMD and go to the Downloads\PhoneBook\out\production\PhoneBook (in case your Project
  folder is located somewhere else rather than the download folder, you just go in that location).
  2. You simple run the pre-complied class PhoneBookApp.class, because there is where the MAIN function is
    
    java PhoneBookApp
    
  3. You can open the project from you favourite IDE, and then run the main function of the Application from inside your IDE
  
 # Built With
* [JAVA 8](https://www.java.com/en/download/) - The programming language used


# General discription of how code is thought

This is a relatively simple project which imitates the behaviour of a Phonebook Manager. The project has in itself 5 classes:
  1. PhoneBookApp -> the class which also executes the whole application, since the "main" function is placed there.
  2. Contact      -> the class which serves as BluePrint for the contact objects. Each contact contains: Name and Surname of the person, 
                     the type of the number and the contact number
  3. Type         -> Which is an ENUM of the types each number can be. The types are WORK, CELLPHONE, HOME; The number is not allowed to
                     be of another type. If the users tries to add another type of number, that type would be rejected and user forced to
                     reenter the appropriate type.
  4. PhoneManager -> the class the does all the actions. THE MANAGER of the CONTACTS. The manager has a list of all the Contacts. When 
                     needed, the manager is called to do a certain action with the contacts, such is: add a new contact, delete or 
                     edit an existing one, show all the saved contacts and even find a certain contact, searching by name and surname.
  5. Menu         -> which is used to simplify and make code more structured and readable, by avoiding the menu options to be shown in 
                     the main class.
                    

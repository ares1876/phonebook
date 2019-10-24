# phonebook
Console Application of a Phonebook Manager

GENERAL DESCRIPTION OF THE APPLICATION

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
                     
HOW IT WORKS

  After you run the application, the first thing it appears is the welcoming menu. It allows you to perform 5 actions. Based on which 
  number you choose, the main function calls the PhoneManager, which performs the required action. The actions are as follows and are self
  explanatory.
    1. Search Contact
    2. Show all Contacts
    3. Add a new Contact
    4. Modify Contact
    5. Delete Contact
    Each other number exits the program.
    
  All the modifications are saved in a list contained in PhoneManager class. When we exit the program, all the modification (new or
  deleted contacts) are written in the PhoneBook.bin binary file.

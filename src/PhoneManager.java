import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/*Klasa PhoneManager sherben si nje nderfaqe per ekzekutimin e funksionaliteteve te aplikacionit. Kjo klase shton nje shkalle
* abstraksioni, ne menyre qe veprimet me kontaktet te mos realizohen drejperdrejte nga useri ne klasen Main. PhoneManager permban
* nje liste e cila gjate inicializimit lexon te gjithe kontaktet e ruajtura ne filen binar PhoneBook.bin. Gjate kohes se ekzekutimit
* te aplikacionit eshte pikerisht kjo Liste qe do sherbeje si memorie e perkohshme e te gjithe listes se kontakteve.
*
* Phone manager permban edhe te gjithe funksionalitet e aplikacionit. Funksionet veprojne ne menyre direkte ne listen e kontakteve,]
* por gjithmone pasi jane thirrur nga funksioni Main.*/

public class PhoneManager {

    //Lista qe mban kontaktet
    private List<Contact> contactList = new ArrayList<>();

    //Inicializimi i phoneManager. Leximi i rekordeve nga File PhoneBook.bin ku ruhen ne menyre te perhershme, dhe kalimi ne listen
    //e perkohshme
    public PhoneManager(){
        contactList = new ArrayList<>();
        try(FileInputStream fs1 = new FileInputStream("PhoneBook.bin")){
            ObjectInputStream in = new ObjectInputStream(fs1);
            contactList = (ArrayList<Contact>) in.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Funksionaliteti i gjetjes dhe shfaqjes se te dhenave mbi nje kontakt
    public void findContact(){
        Scanner input = new Scanner(System.in);
        System.out.println("Cilin kontakt deshironi te shikoni? ");
        System.out.print("Emri ketu -> ");
        String name =input.nextLine();
        System.out.print("Mbiemri ketu -> ");
        String surname = input.nextLine();

        boolean notfound = true;

        for (Contact contact: contactList){
            if (contact.getFirstName().equals(name) && contact.getLastName().equals(surname)){
                System.out.println("\nKontakti qe ju kerkuat eshte si me poshte:");
                System.out.println(name.toUpperCase() +" " + surname.toUpperCase());
                System.out.println(contact.getType() + ": " + contact.getNumber());
                notfound = false;
                break;
            }
        }
        if (notfound){
            System.out.println("\nKontakti nuk u gjet");
        }
    }

    //Funksionaliteti i te shtuarit te nje kontakti te ri
    public void addContact(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ju lutem fusni te dhenat e kontaktit qe doni te shtoni! ");
        System.out.print("Emri ketu -> ");
        String name = input.nextLine();
        System.out.print("Mbiemri ketu -> ");
        String surname = input.nextLine();
        System.out.print("Numri ketu -> ");
        String number = input.nextLine();
        Type type = takeType();

        Contact contact = new Contact(name, surname, number, type);

        contactList.add(contact);
        System.out.println("Kontakti u shtua me sukses!");

    }

    //Funksionaliteti i modifikimit te nje kontakti ekzistues
    public void modifyContact(){
        Scanner input = new Scanner(System.in);
        System.out.println("Cilin kontakt deshironi te modifikoni? ");
        System.out.print("Emri ketu -> ");
        String name =input.nextLine();
        System.out.print("Mbiemri ketu -> ");
        String surname = input.nextLine();
        Contact contact1 = null;
        boolean notfound = true;

        for (Contact contact: contactList){
            if (contact.getFirstName().equals(name) && contact.getLastName().equals(surname)){
               contact1 = contact;
               notfound = false;
            }
        }

        if (notfound){
            System.out.println("Kontakti qe ju kerkoni te perditsoni nuk ekziston");
        }else{
            System.out.print("Emri i ri: ");
            contact1.setFirstName(input.nextLine());
            System.out.print("Mbiemri i ri: ");
            contact1.setLastName(input.nextLine());
            System.out.print("Numri i ri: ");
            contact1.setNumber(input.nextLine());
            Type type = takeType();
            contact1.setType(type);

            System.out.println("Kontakti u perditesua me sukses!");
        }

    }

    //Funksionaliteti i shfaqjes se te gjithe listes ne menyre iterative sipas rendit alfabetik te emrit dhe mbiemrit
    public void showContacts(){

        ListIterator<Contact> iterator = contactList.listIterator();
        int track = 1;
        boolean quit = false;
        Scanner in = new Scanner(System.in);

        if (contactList.isEmpty()) {
            System.out.println("Nuk ka asnje kontakt ne kete telefon! ");
        } else {

            printMenu();

            Contact contact = iterator.next();
            System.out.println("\nContact nr " + track + ". -> " + contact.getFirstName().toUpperCase() + " " + contact.getLastName().toUpperCase());
            System.out.println(contact.getType() + ": " + contact.getNumber());
            boolean movingForward = true;

            while (!quit) {
                int selection = in.nextInt();
                in.nextLine();


                switch (selection) {
                    case 0:
                        quit = true;
                        break;
                    case 1:
                        if (!movingForward){
                            movingForward = true;
                            contact = iterator.next();
                        }
                        if (iterator.hasNext()) {
                            contact = iterator.next();
                            track++;
                            System.out.println("\nContact nr " + track + ". -> " + contact.getFirstName().toUpperCase() + " " + contact.getLastName().toUpperCase());
                            System.out.println(contact.getType() + ": " + contact.getNumber());

                        } else {
                            System.out.println("Nuk ka asnje kontakt tjeter ne telefon.");
                            quit = true;
                        }
                        break;
                    case 2:
                        if (movingForward){
                            contact = iterator.previous();
                            movingForward = false;
                        }
                        if (iterator.hasPrevious()) {
                            track--;
                            contact = iterator.previous();
                            System.out.println("\nContact nr " + track + ". -> " + contact.getFirstName().toUpperCase() + " " + contact.getLastName().toUpperCase());
                            System.out.println(contact.getType() + ": " + contact.getNumber());

                        } else {
                            System.out.println("Nuk ka asnje kontakt tjeter me perpara!");
                            quit = true;
                        }
                        break;
                }
            }


        }
    }

    //Funksionaliteti i fshirjes se nje kontakti ekzistues
    public void deleteContact(){
        Scanner input = new Scanner(System.in);
        System.out.println("Cilin kontakt deshironi te modifikoni? ");
        System.out.print("Emri ketu -> ");
        String name =input.nextLine();
        System.out.print("Mbiemri ketu -> ");
        String surname = input.nextLine();
        boolean notfound = true;
        Contact contact1 = null;


        for (Contact contact: contactList){
            if (contact.getFirstName().equals(name) && contact.getLastName().equals(surname)){
                contact1 = contact;
                notfound = false;
            }
        }

        if (notfound){
            System.out.println("Kontakti qe ju kerkoni te perditsoni nuk ekziston");
        }else {
          contactList.remove(contact1);
        }
    }


    public List<Contact> getContactList(){
        return contactList;
    }

    //Funksion ndihme qe siguron qe tipi eshte nje nga tre llojet HOME, CELLPHONE, WORK
    private Type takeType(){
        Scanner input = new Scanner(System.in);
        System.out.println("Tipi ketu -> ");
        String type = input.nextLine();
        while (!type.toUpperCase().equals(Type.WORK.toString())&& !type.toUpperCase().equals(Type.HOME.toString())&& !type.toUpperCase().equals(Type.CELLPHONE.toString())){
            System.out.println("Tipi i numrit te kontaktit nuk njihet.");
            System.out.println("Sigurohu qe tipi te jete nje nga tipet ne vijim: 1. Cellphone 2. Home 3. Work");
            type = input.nextLine();
        }

        Type type1=null;
        if (type.toUpperCase().equals(Type.CELLPHONE.toString())){
            type1 = Type.CELLPHONE;
        } else if (type.toUpperCase().equals(Type.HOME.toString())){
            type1 = Type.HOME;
        }else if (type.toUpperCase().equals(Type.WORK.toString())) {
            type1 = Type.WORK;
        }
        return type1;
    }

    //Shfaqjae menuse ndihmese se si te iterohet ne listen e plote te kontakteve
    private void printMenu(){
        System.out.println("\nNderkohe qe po degjoni kenge mund te shtypni: \n" +
                "0. Per te dale nga direktoria e kontakteve!\n" +
                "1. Per te shikuar kontakin pasaardhese.\n" +
                "2. Per te degjuar kontakin paraardhese.\n");
    }
}

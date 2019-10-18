import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Funksioni main i cili eshte edhe fillimi i aplikacionit

public class PhoneBookApp {

    private static boolean exitVariable = false;
    private static boolean firstRun = true;

	//Krijimi i objektit phoneManager i cili do te sherbeje si nderfaqe per ekzekutimin e funksionaliteteve te applikacionit
    private static PhoneManager phoneManager;


    public static void main(String[] args) {

        int selection;

        //Krijimi i nje phone manager vetem nje here, ne menyre qe te kemi vetem nje phone manager gjate gjithe ekzekutimit
        if (firstRun) {
            phoneManager = new PhoneManager();
            firstRun = false;
        }

        while (!exitVariable) {

		    //Menuja kryesore
            Menu.showWelecomingMenu();

            selection = Menu.selectMenu();
            switch (selection) {
                case 1:
			        //Kerkon per nje kontakt ne listen e kontakteve
                    phoneManager.findContact();
                    break;
                case 2:
			        //Shfaq te gjithe kontaktet ne rend alfabetik duke iteruar para ose mbrapa sipas deshires
                    phoneManager.showContacts();
                    break;
                case 3:
			        //Shton nje kontakt ne listen e kontakteve
                    phoneManager.addContact();
                    break;
                case 4:
			        //Kerkon per nje kontakt ne listen e kontakteve
                    phoneManager.modifyContact();
                    break;
                case 5:
			        //Kerkon per nje kontakt ne listen e kontakteve
                    phoneManager.deleteContact();
                    break;
                default:
                    //Perfundo ekzekutimi i aplikacionit
                    exitApp();
                    break;

            }
        }
    }

    //Funksioni mbylles i aplikacionit. Para se aplikacioni te mbyllet te gjitha ndryshimet e bera me kontaktet i mbishkruhen
    //filet ekzistues qe mban rekordet ne menyre te perhershme. Ne kete funksion behet edhe renditja e listes se kontakteve
    // ne rend alfabetik
    public static void exitApp(){
        System.out.println("Aplikacioni po mbyllet!");
        try(FileOutputStream fs1 = new FileOutputStream("PhoneBook.bin")){
            ObjectOutputStream obj = new ObjectOutputStream(fs1);

            List<Contact> list = phoneManager.getContactList();

            Collections.sort(list, new Comparator<Contact>() {
                @Override
                public int compare(Contact o1, Contact o2) {
                    if (o1.getFirstName().compareTo(o2.getFirstName())!= 0){
                        return o1.getFirstName().compareTo(o2.getFirstName());
                    }else{
                        return o1.getLastName().compareTo(o2.getLastName());
                    }
                }
            });
            obj.writeObject(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        exitVariable = true;
    }
}

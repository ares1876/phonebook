import java.util.Scanner;


//Menuja e shfaqur ne faqen kryesore te aplikacionit
public class Menu {

    public Menu(){

    }

    public static void showWelecomingMenu(){
        System.out.println("\n--------Ky eshte Aplikacioni i Menaxhimit te Kontakteve-------");
        System.out.println("1 -> Kerko kontakt");
        System.out.println("2 -> Shfaq Kontaktet rradhazi");
        System.out.println("3 -> Shto kontakt");
        System.out.println("4 -> Modifiko kontakt");
        System.out.println("5 -> Fshij kontakt");
        System.out.println("Cdo buton tjeter per te mbyllur aplikacionin");
        System.out.print("\nZgjedhja juaj eshte: ");
    }

    public static int selectMenu(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}

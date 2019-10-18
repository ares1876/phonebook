import java.io.Serializable;


//Klasa Contact
public class Contact implements Serializable{

    private String firstName;
    private String lastName;
    private String number;
    private Type type;

    public Contact(String firstName, String lastName, String number, Type type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}

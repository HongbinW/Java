package basic.OOP.O3;
import basic.OOP.O3.Eg1Account;
public class Eg1Customer {
    private String firstName;
    private String lastName;
    private Eg1Account account;

    public Eg1Customer(String f,String l){
        this.firstName = f;
        this.lastName = l;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public Eg1Account getAccount(){
        return account;
    }
    public void setAccount(Eg1Account account){
        this.account = account;
    }

}

package banking4;

public class Bank {
    private Customer[] customers;   //用于存放客户
    private int numberOfCustomers;  //客户个数
    public Bank(){
        customers = new Customer[5];
    }
    public void addCustomer(String f,String l){
        Customer cust = new Customer(f,l);
        customers[numberOfCustomers] = cust;
        numberOfCustomers++;
    }
    public int getNumberOfCustomers(){
        return numberOfCustomers;
    }
    public Customer getCustomer(int index){
        return customers[index];
    }


}

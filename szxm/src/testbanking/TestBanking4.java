package testbanking;
/*
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 */

import banking4.*;

public class TestBanking4 {

  public static void main(String[] args) {
    Bank bank = new Bank();

    // Add Customer Jane, Simms
    bank.addCustomer("Jane", "Simms");
	//code
    //Add Customer Owen, Bryant
    bank.addCustomer("Owen", "Bryant");
	//code
    // Add Customer Tim, Soley
    bank.addCustomer("Tim", "Soley");
	//code
    // Add Customer Maria, Soley
    bank.addCustomer("Maria", "Soley");
	//code
    for ( int i = 0; i < bank.getNumberOfCustomers(); i++ ) {
      Customer customer = bank.getCustomer(i);

      System.out.println("Customer [" + (i+1) + "] is "
			 + customer.getLastName()
			 + ", " + customer.getFirstName());
    }
  }
}

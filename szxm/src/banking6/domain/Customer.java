package banking6.domain;

public class Customer {
	private String firstName;
	private String lastName;
	//private Account account;
	private Account[] accounts;
	private int numberOfAccounts;//��¼Account�ĸ���
	
	public Customer(String f,String l){
		firstName = f;
		lastName = l;
		accounts = new Account[5];
	}
	
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
//	public Account getAccount(){
//		return account;
//	}
//	
//	public void setAccount(Account acct){//Account acct = new SavingAccount()
//		account = acct;
//	}
	//���һ���˻���Account[]��
	public void addAccount(Account acct){
		accounts[numberOfAccounts] = acct;
		numberOfAccounts++;
	}
	//�����˻��ĸ���
	public int getNumOfAccounts(){
		return numberOfAccounts;
	}
	//����ָ�����������˻�
	public Account getAccount(int index){
		return accounts[index];
	}
}

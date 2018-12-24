package banking6.domain;
//ʵ�ֵ���ģʽ
public class Bank {
	private Customer[] customers;//���ڴ�ſͻ�
	private int numberOfCustomers;//��¼Customer�ĸ���
	
	private Bank(){
		customers = new Customer[5];
	}
	private static Bank bank = new Bank();
	
	public static Bank getBanking(){
		return bank;
	}
	//���һ��Customer��������
	public void addCustomer(String f,String l){
		Customer cust = new Customer(f, l);
		customers[numberOfCustomers] = cust;
		numberOfCustomers++;
	}
	//��ȡCustomer�ĸ���
	public int getNumOfCustomers(){
		return numberOfCustomers;
	}
	//����ָ������λ�õ�Customer
	public Customer getCustomer(int index){
		return customers[index];
	}
}

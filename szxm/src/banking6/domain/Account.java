package banking6.domain;
//�˻�
public class Account {
	protected double balance;//�˻����
	
	public Account(double init_balance){
		balance = init_balance;
	}
	
	public double getBalance(){
		return balance;
	}
	
	//��Ǯ
	public boolean deposit(double amt){//amt:Ҫ��Ķ��
		balance += amt;
		return true;
	}
	//ȡǮ
	public boolean withdraw(double amt){//amt��Ҫȡ�Ķ��
		if(balance >= amt){
			balance -= amt;
			return true;
		}else{
			System.out.println("���㣡");
			return false;
		}
	}
}

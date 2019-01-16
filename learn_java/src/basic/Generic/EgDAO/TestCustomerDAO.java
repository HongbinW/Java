package basic.Generic.EgDAO;

public class TestCustomerDAO {
    public static void main(String[] args) {
        CustomerDAO c = new CustomerDAO();
        c.add(new Customer());
        c.get(0);
    }
}

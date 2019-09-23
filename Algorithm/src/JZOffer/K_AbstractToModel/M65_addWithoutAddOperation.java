package JZOffer.K_AbstractToModel;

public class M65_addWithoutAddOperation {
    public static int addWithoutAddOperation(int num1, int num2){
        int res = 0;
        int carry = 0;
        do{
            res = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = res;
            num2 = carry;
        }while (carry != 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(addWithoutAddOperation(17,5));
    }
}

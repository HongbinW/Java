package JZOffer.K_AbstractToModel;

public class M64_Add1ToN {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean t = (n > 0) && (sum + Sum_Solution(n-1)) > 0;
        return sum;
    }
}

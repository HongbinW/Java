public class Test{
    int a,b;
    public void move(int da, int db){
        a += da;
        b += db;
        System.out.println(da);
        System.out.println(db);
    }
}
class t extends Test{
    int c;
    public void move(int da, int db, int dc){
        a += da;
        b += db;
        c += dc;
    }
}
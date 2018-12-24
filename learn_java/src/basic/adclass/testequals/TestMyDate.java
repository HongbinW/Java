package basic.adclass.testequals;

/**
 * 请根据以下代码自行定义能满足需要的MyDate类,在MyDate类中覆盖equals方法，
 * 使其判断当两个MyDate类型对象的年月日都相同时，结果为true，否则为false。
 * public boolean equals(Object o)
 */
public class TestMyDate {
    public static void main(String[] args){
        MyDate m1 = new MyDate(14, 3, 1976);
        MyDate m2 = new MyDate(14, 3, 1976);

        if ( m1 == m2 ) {
            System.out.println("m1==m2");
        } else {
            System.out.println("m1!=m2"); //m1 != m2
        }

        if ( m1.equals(m2) ) {
            System.out.println("m1 is equal to m2");
            // m1 is equal to m2
        } else {
            System.out.println("m1 is not equal to m2");
        }
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }else if(this instanceof MyDate){
            MyDate m = (MyDate) obj;
            return this.year == m.year && this.month == m.month && this.day == m.day;
        }else {
            return false;
        }
    }
}
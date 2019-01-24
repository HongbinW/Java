package basic.changyonglei;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
    与时间相关的类：
    1.System 类下的currentTimeMillis()，记录的是当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
      主要用于计算时间差。
    2.Date类：java.util.Date 如何创建其实例，其下的方法：toString()、getTime()
     子类 java.sql.Date
    3.SimpleDateFormat类
    4.Calendar类
 */
public class TestDate {
    @Test
    public void test1(){
        //java.util.Date不易于国际化，很多方法已过时
        //创建一个Date实例
        Date d1 = new Date();
        System.out.println(d1.toString());  //Thu Jan 24 15:32:32 CST 2019
        System.out.println(d1.getTime());   //每一个Date对应一个lang型的值
//        java.sql.Date d2 = new java.sql.Date(21323123L);
//        System.out.println(d2); //1970-01-01
        Date d2 = new Date(1548315277895L);
        System.out.println(d2);
    }
    //java.text.SimpleDateFormat类易于国际化
    /*
        格式化：日期 ----> 文本 使用SimpleDateFormat的format()方法
        解析：文本 ----> 日期
     */
    @Test
    public void test2() throws Exception{
        //1.格式化1（默认）
        SimpleDateFormat sdf = new SimpleDateFormat();
        String date = sdf.format(new Date());
        System.out.println(date);   //19-1-24 下午3:41
        //2.格式化2
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//pattern具体见API
        date = sdf1.format(new Date());
        System.out.println(date);   //2019-01-24 03:45:45
        //3.解析：
        Date date1 = sdf.parse("19-1-24 下午3:41");
        System.out.println(date1);  //解析时，要按照格式化时的pattern来转，即sdf只能按照默认的转，sdf1，只能按照上面指定的转

    }

    /**
     * “三天打鱼，两天晒网”  渔夫从1990-01-01开始照此打鱼，则XXXX-XX-XX他是在打鱼还是晒网
     */
    public int getDays(String date1, String date2) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(date1);
        Date d2 = sdf.parse(date2);
        long milliTime = d2.getTime() - d1.getTime();
        return (int)milliTime/1000/3600/24 + 1; //去尾，然而应该进一
    }
    @Test
    public void test3()throws ParseException{
        String str1 = "1990-01-01";
        String str2 = "2019-01-24";
        int dates = getDays(str1,str2);
        if(dates % 5 == 0 || dates % 5 == 4){
            System.out.println("晒网");
        }else
            System.out.println("打鱼");
    }
    //Calendar

    /**
     * public void set(int field,int value)
     * public void add(int field,int amount)
     * public final Date getTime()
     * public final void setTime(Date date)
     */
    @Test
    public void test4(){
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        c.add(Calendar.DAY_OF_MONTH,11);
        day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        c.set(Calendar.DAY_OF_MONTH,23);
        Date d = c.getTime();
        System.out.println(d);
    }
}

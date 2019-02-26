package questions;

import org.junit.Test;

public class TestTryCatchFinally {
    @Test
    public void test1(){
        System.out.println(test1Eg());
    }
    public String test1Eg(){
        String t = "";
        try{
            t = "try";
            return t;
        }catch (Exception e){
            t = "catch";
            return t;
        }finally {
            t = "finally";
        }
    }
    /**
     * Solution:try
     * 过程：首先t赋值为try，然后将结果（JVM中是定义了一个t'）保存到return要返回的值（此时的t已然是t'）中，
     * 然后执行finally中的语句，此时t赋值为finally，之后，return返回，仍然返回的是
     */

    @Test
    public void test2(){
        System.out.println(test2Eg());
    }
    public String test2Eg(){
        String str = "";
        try{
            str = "try";
            return str;
        }catch (Exception e){
            str = "catch";
            return str;
        }finally {
            str = "finally";
            return str;
        }
    }
    /**
     * Solution:finally
     * 过程：try和finally中均有return返回值，此时JVM会直接忽略掉try中的return语句，
     * 因此str先被赋值为try，之后被赋值为finally，返回结果，所以结果为finally
     */
    @Test
    public void test3(){
        System.out.println(test3Eg());
    }
    public String test3Eg(){
        String str = "";
        try{
            str = "try";
            Integer.parseInt(null);
            return str;
        }catch (Exception e){
            str = "catch";
            return str;
        }finally {
            str = "finally";
        }
    }
    /**
     * Solution:catch
     * 过程：相当于以上的综合，首先str赋值为try，然后报错，被catch捕获，然后str赋值为catch，并将临时变量str'
     * 放于return返回值处（即已经将结果放在了return处），然后执行finally，将str赋值为finally，而后返回结果，
     * 返回的是catch代码块中的结果，即str'
     */
    @Test
    public void test4(){
        System.out.println(test4Eg());
    }
    public String test4Eg(){
        String str = "";
        try{
            str = "try";
            Integer.parseInt(null);
            return str;
        }catch (Exception e){
            str = "catch";
            return str;
        }finally {
            str = "finally";
            return str;
        }
    }
    /**
     * Solution:finally
     * 不解释了
     */
    @Test
    public void test5(){
        System.out.println(test5Eg());
    }
    public String test5Eg(){
        String str = "";
        try{
            str = "try";
            Integer.parseInt(null);
            return str;
        }catch (Exception e){
            str = "catch";
            Integer.parseInt(null);
            return str;
        }finally {
            str = "finally";
        }
    }
    /**
     * Solution:java.lang.NumberFormatException
     */
    @Test
    public void test6(){
        System.out.println(test6Eg());
    }
    public String test6Eg(){
        String str = "";
        try{
            str = "try";
            Integer.parseInt(null);
            return str;
        }catch (Exception e){
            str = "catch";
            Integer.parseInt(null);
            return str;
        }finally {
            str = "finally";
            return str;
        }
    }
    /**
     * Solution:finally
     * 过程：同上，在catch中出现异常后，还未报错，先进入finally代码块，然后将str赋值为finally，
     * 然后return返回结果，所以不报错
     */
    @Test
    public void test7(){
        System.out.println(test7Eg());
    }
    public String test7Eg(){
        String str = "";
        try{
            str = "try";
            Integer.parseInt(null);
            return str;
        }catch (NullPointerException e){
            str = "catch";
            return str;
        }finally {
            str = "finally";
            return str;
        }
    }
    /**
     * Solution：finally
     * 过程：由于catch中捕获的是空指针异常，而try中是NumberFormatException，所以不会进入catch，
     * 若finally中无return语句，则会报出NumberFormatException异常
     */
    @Test
    public void test8(){
        System.out.println(test8Eg());
    }
    public String test8Eg(){
        String str = "";
        try{
            str = "try";
            Integer.parseInt(null);
            return str;
        }catch (Exception e){
            str = "catch";
            return str + "###";
        }finally {
            str = "finally";
            System.out.println("finally已执行完毕");
        }
    }
    /**
     * Solution:
     * finally已执行完毕
     * catch###
     *
     * NowCoder:说是先计算完catch中return中的值，再进行finally，然后在catch中return
     */
}

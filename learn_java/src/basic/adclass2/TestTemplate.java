package basic.adclass2;
//模板方法设计模式
public class TestTemplate {
    public static void main(String[] args){
        new SubTemplate().spendTime();  //编译时用的是父类的code，实际运行用的是子类的code

    }
}

abstract class Template{
    public abstract void code();       //该部分是不确定的，所以由子类来实现
    public void spendTime(){    //部分实现方法是确定的
        long start = System.currentTimeMillis();
        this.code();
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end-start));
    }
}

class SubTemplate extends Template{
    public void code(){ //求10000以内的素数
        boolean flag = false;
        for(int i = 2;i <= 10000; i++){
            for(int j = 2;j <= Math.sqrt(i);j++){
                if(i % j == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println(i);
            }
            flag = false;
        }
    }
}
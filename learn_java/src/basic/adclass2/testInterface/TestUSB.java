package basic.adclass2.testInterface;
//接口的应用
public class TestUSB {
    public static void main(String[] args){
        Computer c = new Computer();
        c.dowork(new Printer());

        Flash f = new Flash();
        c.dowork(f);
        System.out.println(f.i);

        //实现接口的匿名类的对象
        USB phone = new USB() {
            @Override
            public void start() {
                System.out.println("phone is linking");
            }

            @Override
            public void stop() {
                System.out.println("phone is unlink");
            }
        };
        c.dowork(phone);
        //实现接口的匿名类的对象
        c.dowork(new USB() {
            @Override
            public void start() {
                System.out.println("phone is linking");
            }

            @Override
            public void stop() {
                System.out.println("phone is unlink");
            }
        });
    }
}

interface USB{
    //功能设置为抽象方法
    void start();
    void stop();
    //USB尺寸的大小可以设置为常量
    int i = 10;
}

class Computer{
    public void dowork(USB usb){
        usb.start();
        System.out.println("-----working-----");
        usb.stop();
        System.out.println("------stop------");
    }
}

class Printer implements USB{
    public void start(){
        System.out.println("Printer starts working");
    }
    public void stop(){
        System.out.println("Printer stop working");
    }
}

class Flash implements USB{
    public void start(){
        System.out.println("Flash starts working");
    }
    public void stop(){
        System.out.println("Flash stop working");
    }

}

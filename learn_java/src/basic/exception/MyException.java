package basic.exception;
//如何自定义一个异常类
//1.自定义异常类继承现有的异常
//2.提供一个序列号，提供几个重载的构造器

public class MyException extends RuntimeException {
    static final long serialVersionUID = -7034897190745766939L;     //由此序号可以唯一对应一个异常类的对象
    public MyException(){

    }
    public MyException(String msg){
        super(msg);
    }
}

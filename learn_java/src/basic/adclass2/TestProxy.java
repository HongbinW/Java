package basic.adclass2;

import org.omg.CORBA.Object;

/**
 * @Author: HongbinW
 * @Date: 2019/4/5 15:27
 * @Version 1.0
 * @Description: 代理模式
 */
public class TestProxy {
    public static void main(String[] args) {
        Obj obj = new ProxyObj();
        obj.action();
    }
}

interface Obj{
    void action();
}
//代理模式
class ProxyObj implements Obj{
    Obj obj;

    public ProxyObj(){
        System.out.println("代理类创建成果");
        obj = new BDLL();
    }

    public void action(){
        System.out.println("代理类开始执行");
        obj.action();
        System.out.println("代理类执行结束");
    }
}

//被代理类
class BDLL  implements Obj{
    public void action(){
        System.out.println("============被代理类开始执行============");
        System.out.println("============具体操作=========");
        System.out.println("============执行完毕=========");
    }
}

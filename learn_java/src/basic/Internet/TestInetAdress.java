package basic.Internet;

/**
 * Description
 * Author  HongbinW
 * Date 2019/1/30
 */

import java.net.InetAddress;

/**
 *  网络通信的第一个要素：IP地址。通过IP地址，唯一的定位互联网上的一台主机
 *  InetAddress:位于java.net包下
 *  1.InetAddress用来代表IP地址。一个InetAddress的对象就代表一个IP地址
 *  2.如何创建InetAddress的对象:getByName(String host)
 *  3.getHostName():获取IP地址对应的域名
 *    getHostAddress():获取IP地址
 */
public class TestInetAdress {
    public static void main(String[] args) throws Exception{
        //如何创建一个InetAddress对象：getByName()
        InetAddress inet = InetAddress.getByName("www.baidu.com");
//        inet = InetAddress.getByName("61.135.169.121");
        System.out.println(inet);
        //两个方法
        System.out.println(inet.getHostName());
        System.out.println(inet.getHostAddress());

        InetAddress inet1 = InetAddress.getLocalHost(); //本机IP:getLocalHost()
        System.out.println(inet1);
        System.out.println(inet1.getHostAddress());
        System.out.println(inet1.getHostName());
    }
}

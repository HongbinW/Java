package basic.Internet;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Description
 * Author  HongbinW
 * Date 2019/1/30
 */

/**
 * UDP编程实现
 */
public class TestUDP {
    //发送端
    @Test
    public void send(){
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            byte[] b = "sending!~~~~".getBytes();
            //创建一个数据报：每一个数据报不能大于64k，每个都记录着数据信息、发送端的IP及端口号，以及要发送到的
            DatagramPacket pack = new DatagramPacket(b,0,b.length,InetAddress.getByName("192.168.0.105"),9090);
            ds.send(pack);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ds != null){
                ds.close();
            }
        }
    }
    //接收端
    @Test
    public void receive(){
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(9090);
            byte[] b = new byte[1024];
            DatagramPacket pack = new DatagramPacket(b,0,b.length);
            ds.receive(pack);
            String str = new String(pack.getData(),0,pack.getLength());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ds != null) {
                ds.close();
            }
        }
    }
}

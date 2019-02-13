package basic.Internet;

/**
 * Description
 * Author  HongbinW
 * Date 2019/1/30
 */

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP编程例一：
 * 客户端给服务端发送信息。服务端输出此信息到控制台上
 * 网络编程实际上就是Socket的编程
 */
public class TestTCP1 {
    //客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建Socket对象，通过构造器指明服务端的IP地址以及接受的端口号
            socket = new Socket(InetAddress.getByName("192.168.0.105"),9090);
            //2.getOutputStream()：发送数据，方法返回OutputStream的对象
            os = socket.getOutputStream();
            //3.具体的输出过程
            os.write("I'm client".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭相应的流和Socket对象
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    //服务端
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        try {
            //1.创建一个ServerSocket的对象，通过构造器指明自身的端口号
            ss = new ServerSocket(9090);
            //2.调用其accept()方法，返回一个Socket的对象
            s = ss.accept();
            //3.调用Socket对象的getInputStream()获取一个从客户端发送过来的输入流
            is = s.getInputStream();
            //4.对获取的流进行的操作
            byte[] b = new byte[20];
            int len;
            while ((len = is.read(b)) != -1){
                System.out.println(new String(b,0,len));
            }
            System.out.println("收到来自于" + s.getInetAddress().getHostAddress() + "的信息");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭相应的流以及Socket、ServerSocket的对象
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(s != null){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

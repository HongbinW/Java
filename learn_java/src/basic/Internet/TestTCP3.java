package basic.Internet;

/**
 * Description
 * Author  HongbinW
 * Date 2019/1/30
 */

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  TCP编程例三
 *  从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端，并关闭相应的连接
 */
public class TestTCP3 {
    //客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        try {
            //1.Socket对象
            socket = new Socket("192.168.0.105",9898);
            //2.从本地获取文件发送给服务端
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("1.jpg"));
            byte[] b = new byte[1024];
            int len;
            while((len = fis.read(b)) != -1){
                os.write(b);
            }
            socket.shutdownOutput();
            //3.接受来自于服务端的信息
            is = socket.getInputStream();
            byte[] b1 = new byte[1024];
            while((len = is.read(b1)) != -1){
                System.out.println(new String(b1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭相应的流和Socket对象
            if(is != null){
                try{
                    is.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(socket != null){
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
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            //1.创建一个ServerSocket对象
            ss = new ServerSocket(9898);
            //2.调用其accept()方法，返回一个Socket对象
            s = ss.accept();
            //3.将从客户端的信息保存到本地
            is = s.getInputStream();
            fos = new FileOutputStream(new File("C:\\Users\\W\\Desktop\\2.jpg"));
            byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b)) != -1){
                fos.write(b,0,len);
            }
            System.out.println("收到来自于" + s.getInetAddress().getHostAddress() + "的信息");
            //4.发送“接收成功”的信息，反馈给客户端
            os = s.getOutputStream();
            os.write("发送成功".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭相应的流和Socket和ServerSocket对象
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
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

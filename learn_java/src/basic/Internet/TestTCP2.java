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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  TCP编程例二：客户端给服务端发送信息，服务端将信息打印到控制台上，同时发送“已收到信息”给客户端
 */
public class TestTCP2 {
    //客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            socket = new Socket("192.168.0.105",9091);
            os = socket.getOutputStream();
            os.write("I'm client,hahaha".getBytes());
            //shutdownOutput():执行此方法，显示地告诉服务端发送完毕
            socket.shutdownOutput();
            is = socket.getInputStream();
            byte[] b = new byte[20];
            int len;
            while ((len = is.read(b)) != -1){
                System.out.println(new String(b,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is != null){
                try{
                    is.close();
                }catch (IOException e ){
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
        OutputStream os = null;
        try {
            ss = new ServerSocket(9091);
            s = ss.accept();
            is = s.getInputStream();
            byte[] b = new byte[20];
            int len;
            while ((len = is.read(b)) != -1){       //该read方法是阻塞式的，下面发送根本执行不到
                System.out.println(new String(b,0,len));
            }
            os = s.getOutputStream();
            os.write("已收到！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os != null){
                try {
                    os.close();
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

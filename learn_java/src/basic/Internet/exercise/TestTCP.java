package basic.Internet.exercise;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端给服务端发送文本，服务端会将文本转成大写后返回给客户端
 */
public class TestTCP {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            os = socket.getOutputStream();
            os.write("abcdefghijklmn".getBytes());
            socket.shutdownOutput();
            is = socket.getInputStream();
            byte[] b = new byte[10];
            int len;
            while((len = is.read(b)) != -1){
                String str1 = new String(b,0,len);
                System.out.print(str1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server(){
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(9090);
            s = ss.accept();
            is = s.getInputStream();
            //3.接受来自客户端的信息
            byte[] b = new byte[10];
            int len;
            String str = "";
            while((len = is.read(b)) != -1){
                String str1 = new String(b,0,len);
                str += str1;
            }
            String res = str.toUpperCase();
            //4.返回给客户端
            os = s.getOutputStream();
            os.write(res.getBytes());
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

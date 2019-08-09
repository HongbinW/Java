package Socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: HongbinW
 * @Date: 2019/8/9 21:22
 * @Version 1.0
 * @Description:
 */
public class Client {
    public static void main(String[] args){
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            socket = new Socket("10.170.64.15",65000);
            os = socket.getOutputStream();
            os.write("abc".getBytes());
            socket.shutdownOutput();
            is = socket.getInputStream();
            byte[] rcv = new byte[32];
            int len = is.read();
            System.out.println(len);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

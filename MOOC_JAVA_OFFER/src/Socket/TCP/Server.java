package Socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: HongbinW
 * @Date: 2019/8/9 21:31
 * @Version 1.0
 * @Description:
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket ss = null;
        InputStream is = null;
        OutputStream os = null;
        Socket socket = null;
        try {
            ss = new ServerSocket(65000);
            socket = ss.accept();
            is = socket.getInputStream();
            byte[] input = new byte[64];
            int len = 0;
            String rcvStr = null;
            while ((len = is.read(input)) != -1){
                rcvStr = new String(input, 0, len);
                System.out.println(rcvStr);
            }
            os = socket.getOutputStream();
            os.write(rcvStr.length());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
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
            try{
                ss.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

package Socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author: HongbinW
 * @Date: 2019/8/9 22:07
 * @Version 1.0
 * @Description:
 */
public class UDPServer {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket(65001);
        byte[] buff = new byte[100];
        DatagramPacket dp = new DatagramPacket(buff,buff.length);
        ds.receive(dp);

        byte[] data = dp.getData();
         String content = new String(data,0,dp.getLength());
        System.out.println(content);

        byte[] sendedContent = String.valueOf(content.length()).getBytes();

        DatagramPacket packetToClient = new DatagramPacket(sendedContent,sendedContent.length,dp.getAddress(),dp.getPort());
        ds.send(packetToClient);
    }
}

package Socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author: HongbinW
 * @Date: 2019/8/9 22:11
 * @Version 1.0
 * @Description:
 */
public class UDPClient {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        byte[] b = "abc".getBytes();
        DatagramPacket packet = new DatagramPacket(b,b.length,InetAddress.getByName("10.170.64.15"),65001);
        socket.send(packet);

        byte[] data = new byte[100];
        DatagramPacket rcvPacket = new DatagramPacket(data,data.length);
        socket.receive(rcvPacket);
        String rcvContent = new String(rcvPacket.getData(),0,rcvPacket.getLength());
        System.out.println(rcvContent);
    }
}

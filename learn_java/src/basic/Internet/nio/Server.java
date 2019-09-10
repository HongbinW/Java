package basic.Internet.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Author: HongbinW
 * @Date: 2019/9/8 15:12
 * @Version 1.0
 * @Description:
 */
public class Server {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel server =  ServerSocketChannel.open();
        server.configureBlocking(false);    //非阻塞
        //绑定本地端口
        server.socket().bind(new InetSocketAddress(8080));

        //启动客户端监听


        //注册事件,客户端连接到达监听
        server.register(selector,SelectionKey.OP_ACCEPT);

        //以下在线程中进行================================

        if (selector.select() == 0){

        }

        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
        while (iterator.hasNext()){
            SelectionKey key = iterator.next();
            iterator.remove();

            if (key.isAcceptable()){
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                //非阻塞状态拿到客户端
                SocketChannel socketChannel = serverSocketChannel.accept();
            }

            //异步处理操作


        }



    }
}

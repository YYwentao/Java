package Test202106;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * ClassName: Test20210617
 * Description: UdpEchoServer 的回响服务器
                TcpEchoServer 的回响服务器
 * date: 2021/6/18 12:57
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210617 {
    public static void main1(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}


class UdpEchoServer {
    /**
     (UdpEchoServer 的回响服务器)
     对于一个服务器来说，核心步骤分为两步
         1.进行初始化操作 (实例化 Socket 对象)
         2.进入主循环，接收并处理请求 (主循环就是死循环)
           a).读取数据并解析
           b).根据请求计算响应
           c).把相应结果返回客户端
     */
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动:");
        while (true) {
            // a).读取数据并解析,有数据就接收到缓冲区(缓冲区大小暂4Kb,就是4096个字节，单位4096B)，没数据就一直进入阻塞
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096 );
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(),0,requestPacket.getLength()).trim();
            // b).根据请求计算响应
            String response = process(request);
            // c).把响应结果返回给客户端,响应数据就是 response ,把它封装成 Packet 对象,并指定返回的客户端的 IP 和端口号
            DatagramPacket responsePack = new DatagramPacket(response.getBytes(),
                    response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(responsePack);

            //打印日志
            System.out.printf("[%s:%d] req: %s; resp: %s\n",requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }
    }

    private String process(String request) {
        //因为此处是一个回响服务器,请求是啥,响应就是啥
        return request;
    }
}

class  TcpEchoServer {
    /**
     (TcpEchoServer 的回响服务器)
     1. 初始化服务器
     2. 进入主循环
       1) 先去从内核中获取一个 TCP 的连接
       2) 处理这个 TCP 连接
         a).读取请求并解析
         b).根据请求计算响应
         c).把相应写回给客户端
     */
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        //这个操作和前面的 Udp 类似,也要绑定端口号
        serverSocket = new ServerSocket(port);
    }

    public void start() {
        
    }
}
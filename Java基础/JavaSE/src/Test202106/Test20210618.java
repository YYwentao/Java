package Test202106;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * ClassName: Test20210618
 * Description:
 * date: 2021/6/18 17:51
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210618 {
    public static void main1(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
class UdpEchoClient {
    /**
     客户端的主要流程分为四部
     1.从用户这里读取输入的数据
     2.构造请求发送给服务器
     3.从服务器读取响应
     4.把响应写回给客户端
     */
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    //需要在启动客户端的时候指定连接到那个服务器
    public UdpEchoClient(String serverIp,int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1.读取用户输入的内容
            System.out.println(">:");
            String request = scanner.nextLine();
            if (request.equals("exit")) {
                break;
            }
            // 2.构造请求发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);
            // 3.从服务器读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4069],4069);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength()).trim();
            // 4.把响应返回给客户端
            System.out.println(response);
        }
    }
}
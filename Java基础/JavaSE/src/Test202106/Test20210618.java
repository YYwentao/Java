package Test202106;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * ClassName: Test20210618
 * Description: UdpEchoClient 的回响客户端
                TcpEchoClient 的回响客户端
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

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
class UdpEchoClient {
    /**
     (UdpEchoClient 的回响客户端)
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

class TcpEchoClient {
    /**
     (TcpEchoClient 的回响客户端)
     1. 启动客户端(不要绑定端口号)和服务器获取连接
     2. 进入主循环
        a).读取用户输入内容
        b).构建一个请求发送给服务器
        c).读取服务器的响应数据
        d).把响应数据返回给显示器
     */
    private Socket socket = null;

    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        //此处的实例化 socket 对象，就是建立 TCP 连接(三次握手，四次挥手)
        socket = new Socket(serverIp,serverPort);
    }

    public void start() {
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
            while (true) {
                //1.读取用户输入内容
                System.out.print(">");
                String request = scanner.nextLine();
                if (request.equals("exit")) {
                    break;
                }
                //2.构建一个请求发送给服务器. 此处的 \n 是为了和服务器中的 readLine 对应
                bufferedWriter.write(request + "\n");
                bufferedWriter.flush();
                //3.读取服务器的响应数据
                String response = bufferedReader.readLine();
                //4.把响应返回给显示器
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package cn.geliang.netty.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Classname WebServer
 * @Description TODO
 * @Date 2019-08-12
 * @Created by Geliang TIAN
 */
public class WebServer {
    public static String WEBROOT = "/Users/geliang";//默认目录
    public static String defaultPage = "index.htm";//默认文件

    public static void main(String[] args) throws IOException {
        System.out.println("Start server...");
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepting Connection...");
            Thread thread = new Thread(new ServerThread(socket));
            thread.start();
        }
    }

    private static class ServerThread implements Runnable {
        private Socket socket;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = socket.getInputStream();
                out = socket.getOutputStream(); //接收来自客户端的请求。
                Request rq = new Request(in); //解析客户请求
                String sURL = rq.parse();
                System.out.println("sURL=" + sURL);
                if (sURL.equals("/"))
                    sURL = WebServer.defaultPage;
                Response rp = new Response(out);
                rp.Send(sURL);
            } catch (IOException e) {
                System.out.println(e.toString());
            } finally {
                System.out.println("关闭连接...\n");
                //最后释放资源
                try {
                    if (in != null)
                        in.close();
                    if (out != null) out.close();
                    if (socket != null) socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}

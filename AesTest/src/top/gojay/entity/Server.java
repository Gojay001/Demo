package top.gojay.entity;

import top.gojay.utils.AesUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Gojay
 * @program AesTest
 * @description Server that receive file
 * @date 2019-01-09 16:42
 **/

public class Server {

    public static void main(String[] args) {
        new Server().start();
    }

    /**
     * 启动服务端
     */
    private void start() {
        try {
            //创建ServerSocket对象
            ServerSocket server = new ServerSocket(1210);

            while (true) {
                //监听端口
                Socket client = server.accept();
                String ip = client.getInetAddress().getHostAddress();
                System.out.println(ip + "已经成功连接！");

                //启动处理数据线程
                new Thread(new HandlerThread(client)).start();
            }
        } catch (IOException e) {
            System.out.println("端口被占用");
            System.exit(0);
        }

    }

    /**
     * 处理数据的线程
     */
    class HandlerThread implements Runnable {
        Socket socket = null;

        /**
         * 传递客户端socket并获取输入流
         * @param socket client socket
         */
        private HandlerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            receiveFile(socket);
        }
    }

    /**
     * 接收文件并用AES解密
     * @param socket 客户端socket
     */
    private static void receiveFile(Socket socket) {
        byte[] inputByte = null;
        int length = 0;
        DataInputStream dis = null;
        FileOutputStream fos = null;

        // 存储文件路径
        String receivedPath = "/Users/gojay/IdeaProjects/AesTest/file/server/receivedFile.png";
        File receivedFile = new File(receivedPath);
        String decryptPath = "/Users/gojay/IdeaProjects/AesTest/file/server/decryptFile.png";
        File decryptFile = new File(decryptPath);
        String key = "123456";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            try {
                // 接收client传来的文件
                dis = new DataInputStream(socket.getInputStream());
                fos = new FileOutputStream(receivedPath);
                inputByte = new byte[1024];
                System.out.println("开始接收数据...");
                while ((length = dis.read(inputByte, 0, inputByte.length)) > 0) {
                    fos.write(inputByte, 0, length);
                    fos.flush();
                }
                System.out.println("完成接收：" + receivedFile);

                // 解密文件
                System.out.print("请输入解密密钥:");
                key = reader.readLine();
                AesUtil.decryptFile(receivedFile, decryptFile, key);
                System.out.println("完成解密：" + decryptFile);
            } finally {
                if (fos != null) {
                    fos.close();
                }
                if (dis != null) {
                    dis.close();
                }
                if (socket != null) {
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
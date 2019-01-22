package top.gojay.entity;

import top.gojay.utils.AesUtil;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author Gojay
 * @program AesTest
 * @description Client that transport file
 * @date 2019-01-09 16:39
 **/

public class Client {
    public static void main(String[] args) throws IOException {
        int length = 0;
        double sumL = 0 ;
        byte[] sendBytes = null;
        Socket socket = null;
        DataOutputStream dos = null;
        FileInputStream fis = null;
        boolean bool = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 初始化文件路径及密钥
        String sourcePath = "/Users/gojay/IdeaProjects/AesTest/file/china_map.png";
        String encryptPath = "/Users/gojay/IdeaProjects/AesTest/file/client/encryptFile.png";
        String key = "123456";

        // 对文件进行AES加密
        try {
            System.out.println("原文件路径:" + sourcePath);
            System.out.print("请输入加密密钥：");
            key = reader.readLine();

            // AES加密文件
            File sourceFile = new File(sourcePath);
            File encryptFile = new File(encryptPath);
            File file = sourceFile;
            file = AesUtil.encryptFile(sourceFile, encryptFile, key);
            System.out.println("加密成功!");
            System.out.println("加密后文件路径:" + encryptPath);

            // 通过socket传输文件
            long l = file.length();
            socket = new Socket();
            socket.connect(new InetSocketAddress("127.0.0.1", 1210));
            dos = new DataOutputStream(socket.getOutputStream());
            fis = new FileInputStream(file);
            sendBytes = new byte[1024];
            while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
                sumL += length;
                dos.write(sendBytes, 0, length);
                dos.flush();
            }
            if(sumL==l){
                bool = true;
            }
        }catch (Exception e) {
            System.out.println("客户端文件传输异常!");
            bool = false;
            e.printStackTrace();
        } finally{
            if (dos != null) {
                dos.close();
            }
            if (fis != null) {
                fis.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
        System.out.println(bool?"发送成功!":"发送失败!");
    }

}
package top.gojay.utils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author Gojay
 * @program AesTest
 * @description util about AES
 * @date 2019-01-09 18:42
 **/

public class AesUtil {
    /**
     * 初始化 AES Cipher
     *
     * @param sKey 密码
     * @param cipherMode 密码器模式
     * @return cipher 密码器
     */
    private static Cipher initAESCipher(String sKey, int cipherMode) {
        KeyGenerator keyGenerator = null;
        Cipher cipher = null;
        try {
            // 创建Key生产者
            keyGenerator = KeyGenerator.getInstance("AES");
            // 随机数初始化
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(sKey.getBytes());
            keyGenerator.init(128, secureRandom);
            // 根据用户密码，生成密钥
            SecretKey secretKey = keyGenerator.generateKey();
            // 返回基本编码格式的密钥
            byte[] codeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(codeFormat, "AES");
            // 创建密码器
            cipher = Cipher.getInstance("AES");
            // 初始化密码器
            cipher.init(cipherMode, key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return cipher;
    }

    /**
     * 加密字符串
     *
     * @param content 需要加密的内容
     * @param sKey 密码
     * @return result 加密后字符串
     */
    private static byte[] encryptString(String content, String sKey) {
        try {
            byte[] byteContent = content.getBytes("utf-8");
            // 初始化为加密模式的加密器
            Cipher cipher = initAESCipher(sKey, Cipher.ENCRYPT_MODE);
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密字符串
     *
     * @param content 需要解密的字符串
     * @param sKey 密码
     * @return result 解密后的字符串
     */
    private static byte[] decryptString(byte[] content, String sKey) {
        try {
            // 初始化为解密模式的加密器
            Cipher cipher = initAESCipher(sKey, Cipher.DECRYPT_MODE);
            // 解密
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对文件进行AES加密
     *
     * @param sourceFilePath 原文件路径
     * @param encryptFilePath 加密后文件路径
     * @param sKey 密码
     * @return encryptFilePath 加密后文件路径
     */
    public static File encryptFile(File sourceFilePath, File encryptFilePath, String sKey) {

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(sourceFilePath);
            outputStream = new FileOutputStream(encryptFilePath);
            // 初始化为加密模式的密码器
            Cipher cipher = initAESCipher(sKey, Cipher.ENCRYPT_MODE);
            // 以加密流写入文件
            CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
            byte[] cache = new byte[1024];
            int nRead = 0;
            while ((nRead = cipherInputStream.read(cache)) != -1) {
                outputStream.write(cache, 0, nRead);
                outputStream.flush();
            }
            cipherInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return encryptFilePath;
    }

    /**
     *  AES方式解密文件
     * @param sourceFilePath 需要解密的文件路径
     * @param decryptFilePath 解密后的文件路径
     * @param sKey 密码
     * @return
     */
    public static File decryptFile(File sourceFilePath, File decryptFilePath, String sKey) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(sourceFilePath);
            outputStream = new FileOutputStream(decryptFilePath);
            // 初始化为解密模式的密码器
            Cipher cipher = initAESCipher(sKey, Cipher.DECRYPT_MODE);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = inputStream.read(buffer)) >= 0) {
                cipherOutputStream.write(buffer, 0, r);
            }
            cipherOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return decryptFilePath;
    }

    // 测试方法
    public static void main(String[] args) {
        // 加密文件
        String sKey = "123";
        //原文件文件路径
        File sourceFilePath = new File("/Users/gojay/IdeaProjects/AesTest/file/test.txt");
        //加密后的文件路径
        File encryptFilePath = new File("/Users/gojay/IdeaProjects/AesTest/file/encryptFile.txt");
        //解密后的文件路径
        File decryptFilePath  = new File("/Users/gojay/IdeaProjects/AesTest/file/decryptFile.txt");
        //加密文件
        encryptFile(sourceFilePath, encryptFilePath, sKey);
        System.out.println("加密成功!");
        //解密文件
        decryptFile(encryptFilePath, decryptFilePath, "111");
        System.out.println("解密成功!");

        // 加密字符串
        String content = "hello";
        String password = "123";
        System.out.println("加密之前：" + content);
        // 加密
        byte[] encrypt = encryptString(content, password);
        System.out.println("加密后的内容：" + new String(encrypt));
        // 解密
        byte[] decrypt = decryptString(encrypt, password);
        System.out.println("解密后的内容：" + new String(decrypt));
    }
}
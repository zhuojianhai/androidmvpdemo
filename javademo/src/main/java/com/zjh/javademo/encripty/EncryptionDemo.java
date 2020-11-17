package com.zjh.javademo.encripty;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import static com.sun.org.apache.bcel.internal.classfile.Utility.toHexString;
import static com.sun.org.apache.xml.internal.serialize.Method.TEXT;

public class EncryptionDemo {
    public static void main(String[] args) {
        System.out.println("麓山国际上炼钢");
        try {
            encryptData("hello,jack");

            testMac();

            testCertificate();

            testCipherRSA();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * AES 对称加密
     * @param data
     * @throws Exception
     */
    private static void encryptData(String data)throws Exception{
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        Key key = keyGenerator.generateKey();
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] bytes = cipher.doFinal(data.getBytes());

        System.out.println("AES Encypt "+ Base64.getEncoder().encodeToString(bytes));

        byte[] initializeVector = cipher.getIV();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializeVector);
        cipher.init(Cipher.DECRYPT_MODE,key,ivParameterSpec);

        bytes = cipher.doFinal(bytes);

        System.out.println("AES decypt "+new String(bytes));


    }

    private static void  testMac() throws Exception{
        Mac mac = Mac.getInstance("HmacMD5");
        //第一个参数可以是任意字符串,第二个参数与获取Mac对象的algorithm相同
        SecretKeySpec secretKeySpec = new SecretKeySpec("123456".getBytes(), "HmacMD5");
        mac.init(secretKeySpec);
        byte[] bytes = mac.doFinal("helloworld".getBytes());
        System.out.println("HmacMD5结果：" + toHexString(bytes));

        mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec("123456".getBytes(), "HmacSHA1"));
        bytes = mac.doFinal("helloworld".getBytes());
        System.out.println("HmacSHA1结果：" + toHexString(bytes));
    }


    /**
     * 公钥、私钥 加解密学习过程
     * @throws Exception
     */
    private static void testCertificate() throws Exception{
        final String alias = "lisi";
        final String keystore_password = "123456";//秘钥库密码
        final String ca_password = "123456";//证书密码

        //公钥证书的编码格式是x509  私钥通常是pkcs8
        /*从lisi.cer中提取公钥*/

        X509Certificate x509Certificate = null;
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        FileInputStream fis = new FileInputStream("E://test//lisi.cer");
        x509Certificate = (X509Certificate) certificateFactory.generateCertificate(fis);
        fis.close();

        /*==公钥加密*/
        Key key = x509Certificate.getPublicKey();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] bytes = cipher.doFinal("卓建海".getBytes());
        System.out.println("加密结果："+Base64.getEncoder().encodeToString(bytes));

        /**==提取私钥*/
        fis = new FileInputStream("E://test//lu.keystore");
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(fis,keystore_password.toCharArray());
        fis.close();

        PrivateKey privateKey = (PrivateKey)keyStore.getKey(alias,ca_password.toCharArray());

        /**使用私钥解密*/

        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        bytes = cipher.doFinal(bytes);
        System.out.println("解密： "+new String(bytes));


    }

    /***
     * java 代码动态生成RSA的公、私钥对
     * @throws Exception
     */
    private static void testCipherRSA() throws Exception{
        //获取cipher对象
        Cipher cipher = Cipher.getInstance("RSA");
        //通过KeyPairGenerator来生成公钥和私钥
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();//公钥
        PrivateKey privateKey = keyPair.getPrivate();//私钥

        System.out.println("加密的文本为--TEXT.getBytes() "+TEXT);
        /*加密*/
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(TEXT.getBytes());
        final String encryptText = Base64.getEncoder().encodeToString(bytes);
        System.out.println("RSA公钥加密：" + encryptText);

        /*解密*/
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        bytes = cipher.doFinal(Base64.getDecoder().decode(encryptText));
        System.out.println("RSA解密：" + new String(bytes));
    }
}

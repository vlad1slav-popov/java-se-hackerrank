package com.company.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;

public class RSA {

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public RSA() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            KeyPair pair = generator.generateKeyPair();
            privateKey = pair.getPrivate();
            publicKey = pair.getPublic();
        } catch (Exception ignored) {
        }
    }

    public byte[] encrypt(String message) throws Exception {

        byte[] messageToBytes = message.getBytes();
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");

        OAEPParameterSpec oaepParams = new OAEPParameterSpec("SHA-512",
                "MGF1", new MGF1ParameterSpec("SHA-512"),
                PSource.PSpecified.DEFAULT);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey, oaepParams);
        byte[] encryptedBytes = cipher.doFinal(messageToBytes);
        return encode(encryptedBytes);
    }

    private byte[] encode(byte[] data) {
        return Base64.getEncoder().encode(data);
    }

    public String decrypt(byte[] encryptedMessage) throws Exception {

        byte[] encryptedBytes = decode(encryptedMessage);
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
        OAEPParameterSpec oaepParams = new OAEPParameterSpec("SHA-512",
                "MGF1",
                new MGF1ParameterSpec("SHA-512"), PSource.PSpecified.DEFAULT);
        cipher.init(Cipher.DECRYPT_MODE, privateKey, oaepParams);
        byte[] decryptedMessage = cipher.doFinal(encryptedBytes);
        return new String(decryptedMessage, StandardCharsets.UTF_8);
    }

    private byte[] decode(byte[] data) {
        return Base64.getDecoder().decode(data);
    }



    public static void main(String[] args) {
        RSA rsa = new RSA();
        try {
            byte[] encryptedMessage = rsa.encrypt("Hello World");
            System.err.println("Encrypted:\n" + new String(encryptedMessage));

            String decryptedMessage = rsa.decrypt(encryptedMessage);
            System.err.println("Decrypted:\n" + decryptedMessage);

        } catch (Exception ingored) {
            ingored.printStackTrace();
        }
    }

}

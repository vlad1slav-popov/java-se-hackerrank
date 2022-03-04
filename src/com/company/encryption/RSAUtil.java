package com.company.encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtil {

    private static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoFXqbllrh/JGLMJV7U2p7xbcJsDY2dkA0X+3Fd6Ey7bJDdehhLzvMT24DSVFDwU9iI7h+iqJsLAXo+1pjdCdIeHUyB+l/oRIRUa3lErsCTVMtynsHIlcDt9jOTi+9wSRR4Yt25Y1BiLS8C6PWreGQGPzge116awGgVMVBAvkgzXPIbrSwQw50mMC0FUtpbjHuQX/xFj7GgoA6viO+GueCRR46UJ+1iqCqxVNpbzs6y5M42Vxcclm8LZXF6Fl62JLOISyJnJNKoI/+f591lp+sw/9KY06CSPsZPA2EiLu0jR7ZtalnUAr1mzmWFaX0PADaHsKyeNoiGkyFj3tF2cM8wIDAQAB";
    private static String privateKey = "Xtj+VoyAJ1Wl0mquG9LAlSLcFguyXf41XFCuN/NFs+XMwRvz/RlvjbdWCVN9okZwaSPbfebq4uO955yoeM/6yJTL7eH+lWi/ZbpVYkBHTEBr7a+8h3Q6fofq8VTgBsyusrnEzBxH4BCydYZnC9HT95b2NDvpLjviG3AitsZqUdyHOT7ATFYOOQsoAibp6TXtCZVnLLoWMUDxIq/ONH8VpIHDCtcA1cOCfQRg1Ii+4LhVHIs0a1vQw3tk0qNU4iLqz3w2UIME1OsDV0SxOfI+377SMUc6je++ld7Zms7geeigUuoBSDwz/qJt836Pv7jp37C65r3GzHycU8Kyrzshkg==";

    public static PublicKey getPublicKey(String base64PublicKey) {
        PublicKey publicKey = null;
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    public static PrivateKey getPrivateKey(String base64PrivateKey) {
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes()));
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    public static byte[] encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");

        OAEPParameterSpec oaepParams = new OAEPParameterSpec("SHA-512",
                "MGF1", new MGF1ParameterSpec("SHA-512"),
                PSource.PSpecified.DEFAULT);
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey), oaepParams);
        return cipher.doFinal(data.getBytes());
    }

    public static String decrypt(byte[] data, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
        OAEPParameterSpec oaepParams = new OAEPParameterSpec("SHA-512",
                "MGF1",
                new MGF1ParameterSpec("SHA-512"), PSource.PSpecified.DEFAULT);
        cipher.init(Cipher.DECRYPT_MODE, privateKey, oaepParams);
        return new String(cipher.doFinal(data));
    }

    public static String decrypt(String data, String base64PrivateKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        return decrypt(Base64.getDecoder().decode(data.getBytes()), getPrivateKey(base64PrivateKey));
    }

    public static void main(String[] args) throws IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, BadPaddingException {
        try {
            String encryptedString = Base64.getEncoder().encodeToString(encrypt("Dhiraj is the author", publicKey));
            System.out.println(encryptedString);
            String decryptedString = RSAUtil.decrypt(encryptedString, privateKey);
            System.out.println(decryptedString);
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }

    }
}

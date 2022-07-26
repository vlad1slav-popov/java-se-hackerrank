package com.company.encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtil {

    //4096
    private static final String publicKey = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAqFr5FMe1mvpFtKLMySpKtPqme+SFDMv6QKfxElFXJeDF+a3JJ2+LmBDReMfLqLJkyeqw/wMKSkSgQOEFRl3BfOpKvpLR5AxG6gPIBDbyx0gbhJskBZ3RMTViRuJw/0x8e+rPr87r8fkSjHEWblDRQnzyc0oxUSROo6o+oP6Eaqq7zroa/vn1MssSokU/axnYBTuOWlIkib3DTsLoxsEtqmQSoirN/0dJVAL+P78dlq9yoVjNlItcnvlPOOUVW5FdaGlDR2PWhYhEennOiOoqVNb7a4cIo6siL/BjsbWfhD0jRtzVzTZCCPmLYCbpWH4dn9dNzx+0V9hhFaQkSdMq53d4o+Ijfg42H8Lqu5DPScHM+2dIagIr5XgN9YrQniRpGn1X2i/dDO6/KEpRPdywkNxkFRLauvdjhALwFw9kfDv4mRyeBAsmg56z3HjQCUZCkSODQCKqoZml7cIz8jlLTHu1Kyn+JxJAI4ID65Qxlm5OJx0f8TbNHnFfOH4mv7rYlBpWp7rDgjI20hYXGMFGQ6MH9AkNjERQF49f8N7zsK1pYwNEV3Fme5MN0N9aF0TafOhya5yFwiKL+5FASCwoitZ+YqYzhpHiIh0Zqp/DN/yIKEOjLiL8CSJ8bwoygn8+/pV7ndNuZmU4N8Q/6hnjAC9MqKxeaqzV8ziK551Wzn8CAwEAAQ==";
    private static final String privateKey = "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";

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

    public static PrivateKey getPrivateKey(String base64PrivateKey) throws NoSuchAlgorithmException {
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

    public static byte[] encrypt(String data, String publicKey) throws BadPaddingException,
            IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("RSA/None/OAEPWithSHA-512AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
        return cipher.doFinal(data.getBytes());
    }

    public static String decrypt(byte[] data, PrivateKey privateKey) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
//        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("RSA/None/OAEPWithSHA-512AndMGF1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(data));
    }

    public static String decrypt(String data, String base64PrivateKey) throws IllegalBlockSizeException,
            InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidAlgorithmParameterException {
        return decrypt(Base64.getDecoder().decode(data.getBytes()), getPrivateKey(base64PrivateKey));
    }

    public static void main(String[] args) throws IllegalBlockSizeException,
            InvalidKeyException, NoSuchPaddingException, BadPaddingException {
        try {
            String encryptedString = Base64.getEncoder().encodeToString(encrypt("4012001036853337", publicKey));
//            String encryptedString = "MHcKWpeYI9l4DhTzQINsfSfnp+lsmssscBpRlPMkPOQFiT7OacjrCMd1A6UNDkibzU5AFPDD/D8sTFBXMwHY/JD8IWe91bv7hSwFlEbQ24RJgnbzhyw5xAp5gBsusUafJPglufvCamYILb/TQOavSx7Q5x0rMLWb1gi4L+Gn2XPQs4OSwADx/NEPEsOgPLxoOSggqpyiE2gy8tALxBeKduYSmJwdYrybbr3YKiTzQed6MJCcmdlf0nvmIatWQFkzQ4OZinKTaHYb462b0wdu4cvT4BnVn2d7T1OVlLd2Lda7Z3HGERlAgkiECgtDPjoU326mN+SJTFUSXti57PN1bwQQP/EJWBqvzqJEUHjpKlXZs1Vk670z1RmON1YO3NybcZyP7kKjtSE5Q6nwn7zCJ1GOL8K8AmkLbKQEa2jgQ7Tt/fKXo7lUGj2NqwC/hijG23b4wzDNjqHlePd3zE+wWcRUz5HHv66IvXHry4SoFXZ5PAlQ4+8JXFusey3AN/5Q702OGaq3XhWbjg3dGKEWrd80TvUTT53bnLOm4RtM8/DY47BWgrqWYX8TN1T+hLUvXSM/kK/2igXW/MGzorr8rKHcJtfoluHVPJiExbwq0CiAjo/x5FIwCyBRHAIsEEWNsowZGGonp5zrJwQS+UkuQL832XDWinZXEIO7sc9nsGc=";
//            String encryptedString = "jlY5Y2+GpmQr6QUQ2QCdRECk+GeJoakZMlFyiM5j0Wnnmgu075Bu9UiqglO1jx+yAucHMSyS7nmT1eLvll38FSb6Cck9+RzorQyqI3Nb8DRiHbPE3JuExS60L7uX9esZRSO64yl7+/uWftT4pyPm6zKXYJHfWq60sQV5f87Wnn5dhgE26i+XRPZIy+ZWV/Zpg+jiNPOiICQK/xUcof5kfCJrFRUyNJzVJIo6g7vLeDD44qWn9YGrXHrwMRxNmLhOQArpRWKb1U78/sE+vg2Df/giG0B0Ld2dHYfAXlzg5nKxj/1YGgrg81mvEaIE31+KbokRVMWeNO9/gnnTQWZTXIo4HPX/LjAqOL0PkSAY0OjKyeVU5XJK7k+1lpvSFxV0xZNdKVaKUg1T8txuQShcI/BQefSwuj+9soN/F7KqCzSn3XaqKiB/DbOOztrOjHtE5kwoyMOBpxTM1fIX6CKp/hrGmLZgIhwHaZ3DVM+C9KjUTGV5kl9fvnlhEcsrajzz4uL8FzYDEDeGc/M/3MjhOfsyGR1UgBefvOanWUw6cdVpdkGUJ9sq2antxxu1gkvPzypv9nykh73sEG8FCtD7QRCqOblJ9hJRWZ/lfyBzh715NOc4Eg1hVQg6S5DoFBibk0YhqlFyMKR76KEcQ1N54W+lqNLb33oSCiZn2QfMC0s=";
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

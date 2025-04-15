// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

class Main {
    public static void main(String[] args) {
        result("");
    }

    public static boolean result(String str) {
        byte[] bArr;
        byte[] bArr2 = new byte[0];
        try {
            bArr = a(b("8d127684cbc37c17616d806cf50473cc"), Base64.getDecoder().decode("5UJiFctbmgbDoLXmpL12mkno8HT4Lv8dlat8FxR2GOc=".getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println(e.toString());
            bArr = bArr2;
        }

        String secret = new String(bArr);
        System.out.println("The password is: " + secret);
        return str.equals(new String(bArr));
    }


    public static byte[] a(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    public static byte[] b(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}

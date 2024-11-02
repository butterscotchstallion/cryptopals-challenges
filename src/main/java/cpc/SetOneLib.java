package main.java.cpc;

import java.util.Base64;
import java.util.HexFormat;

public class SetOneLib {

    /**
     * @param hex String
     * @return base64 encoded hex string
     */
    public String hexToBase64(String hex) {
        byte[] hexBytes = HexFormat.of().parseHex(hex);
        byte[] base64Bytes = Base64.getEncoder().encode(hexBytes);
        return new String(base64Bytes);
    }

    public String getFixedXOR(String s1, String s2) throws RuntimeException {
        if (s1.length() != s2.length()) {
            throw new RuntimeException("s1 length is not equal to s2 length");
        }

        byte[] bytes1 = Base64.getDecoder().decode(s1);
        byte[] bytes2 = Base64.getDecoder().decode(s2);
        int length = bytes1.length;
        byte[] result = new byte[length];

        for (int i = 0; i < length; i++) {
            byte b1 = i < length ? bytes1[i] : 0;
            byte b2 = i < length ? bytes2[i] : 0;
            result[i] = (byte) (b1 ^ b2);
        }

        return new String(result);
    }
}
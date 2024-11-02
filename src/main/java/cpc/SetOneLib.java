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
}
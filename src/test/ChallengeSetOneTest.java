package test;

import main.java.cpc.SetOneLib;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChallengeSetOneTest {

    @Test
    public void hexToBase64_validHex() {
        SetOneLib setOneLib = new SetOneLib();
        String hex = "4d616e"; // Example: "Man" in hexadecimal
        String expectedBase64 = "TWFu"; // Expected Base64 output for "Man"
        Assertions.assertEquals(expectedBase64, setOneLib.hexToBase64(hex));
    }

    @Test
    public void hexToBase64_emptyHex() {
        SetOneLib setOneLib = new SetOneLib();
        String hex = ""; // Empty hex string
        String expectedBase64 = ""; // Expected Base64 output for empty string
        Assertions.assertEquals(expectedBase64, setOneLib.hexToBase64(hex));
    }

    @Test
    public void hexToBase64_invalidHex() {
        SetOneLib setOneLib = new SetOneLib();
        String hex = "invalid"; // Invalid hex string
        assertThrows(IllegalArgumentException.class, () -> {
            setOneLib.hexToBase64(hex);
        });
    }
}
package test;

import main.java.cpc.SetOneLib;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChallengeSetOneTest {

    @Test
    public void hexToBase64_validHex() {
        SetOneLib setOneLib = new SetOneLib();
        String hex = "4d616e";
        String expectedBase64 = "TWFu";
        Assertions.assertEquals(expectedBase64, setOneLib.hexToBase64(hex));
    }

    @Test
    public void hexToBase64_emptyHex() {
        SetOneLib setOneLib = new SetOneLib();
        String hex = "";
        String expectedBase64 = "";
        Assertions.assertEquals(expectedBase64, setOneLib.hexToBase64(hex));
    }

    @Test
    public void hexToBase64_invalidHex() {
        SetOneLib setOneLib = new SetOneLib();
        String hex = "invalid";
        assertThrows(IllegalArgumentException.class, () -> {
            setOneLib.hexToBase64(hex);
        });
    }
}
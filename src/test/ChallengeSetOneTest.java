package test;

import main.java.cpc.SetOneLib;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChallengeSetOneTest {

    @Test
    public void hexToBase64_validHex() {
        SetOneLib setOneLib = new SetOneLib();
        String hex = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
        String expectedBase64 = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t";
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

    @Test
    public void getFixedXOR() {
        SetOneLib setOneLib = new SetOneLib();
        String expected = "1c0111001f010100061a024b53535009181c";
        String actual = "746865206b696420646f6e277420706c6179";
        Assertions.assertEquals(actual, setOneLib.getFixedXOR(expected, expected));
    }
}
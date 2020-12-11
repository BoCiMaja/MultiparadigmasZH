package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RomanNumeralsTest {

    private RomanNumerals romanNumerals;

    @BeforeEach
    void setUp()
    {
        romanNumerals = new RomanNumerals();
    }

    @Test
    void shouldThrowExceptionIfTheValueIsTooHigh()
    {
        //given
        int testNumber = 5796;
        Assertions.assertThrows(IllegalArgumentException.class, ()->romanNumerals.ConvertNormalToRomans(testNumber));
    }

    @Test
    void shouldThrowExceptionIfNumberIsTooLow(){
        //given
        int testNumber = -10;
        Assertions.assertThrows(IllegalArgumentException.class, ()->romanNumerals.ConvertNormalToRomans(testNumber));
    }

    @Test
    void testBetweenOneAndFive(){
        //given
        int testNumber = 3;
        String expected = "III";
        //when
        String actual = romanNumerals.ConvertNormalToRomans(testNumber);
        //then
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testBetweenFiveAndTen(){
        //given
        int testNumber = 9;
        String expected = "IX";
        //when
        String actual = romanNumerals.ConvertNormalToRomans(testNumber);
        //then
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testNumberFive(){
        //given
        int testNumber = 5;
        String expected = "V";
        //when
        String actual = romanNumerals.ConvertNormalToRomans(testNumber);
        //then
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testBetweenTenAndFifty(){
        int testNumber = 44;
        String expected = "XLIV";
        String actual = romanNumerals.ConvertNormalToRomans(testNumber);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testBetweenFiftyAndOneHundred(){
        int testNumber = 86;
        String expected = "LXXXVI";
        String actual = romanNumerals.ConvertNormalToRomans(testNumber);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testNumberFifty(){
        int testNumber = 50;
        String expected = "L";
        String actual = romanNumerals.ConvertNormalToRomans(testNumber);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testBetweenOneHundredAndFiveHundred(){
        int testNumber = 273;
        String expected = "CCLXXIII";
        String actual = romanNumerals.ConvertNormalToRomans(testNumber);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testBetweenFiveHundredAndOneThousand(){
        int testNumber = 894;
        String expected = "DCCCXCIV";
        String actual = romanNumerals.ConvertNormalToRomans(testNumber);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testNumberFiveHundred(){
        int testNumber = 500;
        String expected = "D";
        String actual = romanNumerals.ConvertNormalToRomans(testNumber);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testBetweenOneThousandAndThreeThousandNineHundredNinetyNine(){
        int testNumber = 3795;
        String expected = "MMMDCCXCV";
        String actual = romanNumerals.ConvertNormalToRomans(testNumber);
        Assertions.assertEquals(expected,actual);
    }
}

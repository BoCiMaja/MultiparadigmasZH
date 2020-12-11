package org.example;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {

    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 3999;
    private static final Map<Integer, String> ROMAN_VALUES;

    static
    {
        ROMAN_VALUES = new HashMap<>();
        ROMAN_VALUES.put(1, "I");
        ROMAN_VALUES.put(5, "V");
        ROMAN_VALUES.put(10, "X");
        ROMAN_VALUES.put(50, "L");
        ROMAN_VALUES.put(100, "C");
        ROMAN_VALUES.put(500, "D");
        ROMAN_VALUES.put(1000, "M");
    }

    public String ConvertNormalToRomans(int num)  throws IllegalArgumentException
    {
        if(num < MINIMUM_VALUE || num > MAXIMUM_VALUE)
        {
            throw new IllegalArgumentException("The value of tha number must be 1-3999!");
        }

        int numberOfThousands = num / 1000;
        int numberOfHundreds =  num % 1000 / 100;
        int numberOfTens = num % 100 / 10;
        int numberOfOnes = num % 10;

        String roman = SimpleConcatenation(ROMAN_VALUES.get(1000), numberOfThousands) +
                       ComplicatedConcatenation(ROMAN_VALUES.get(100), ROMAN_VALUES.get(500), ROMAN_VALUES.get(1000), numberOfHundreds) +
                       ComplicatedConcatenation(ROMAN_VALUES.get(10), ROMAN_VALUES.get(50), ROMAN_VALUES.get(100), numberOfTens) +
                       ComplicatedConcatenation(ROMAN_VALUES.get(1), ROMAN_VALUES.get(5), ROMAN_VALUES.get(10), numberOfOnes);

        return roman;
    }

    private String SimpleConcatenation(String roman, int quantity)
    {
        String temp = "";
        for (int i = 0; i < quantity; i++)
        {
            temp += roman;
        }
        return temp;
    }

    private String ComplicatedConcatenation(String mainRoman, String midRoman, String subRoman, int quantity)
    {
        switch (quantity)
        {
            case 1:
            case 2:
            case 3:
                return SimpleConcatenation(mainRoman, quantity);
            case 4:
                return mainRoman + midRoman;
            case 5:
                return midRoman;
            case 6:
            case 7:
            case 8:
                return midRoman + SimpleConcatenation(mainRoman, quantity - 5);
            case 9:
                return mainRoman + subRoman;
            default: return "";
        }
    }

    //public int ConvertRomansToNormal(String num) throws IllegalArgumentException
    //{
    //    if(num.length() == 0 || num == null)
    //    {
    //        throw new IllegalArgumentException("The value can't be null!");
    //    }
//
    //    int normal = 0;
//
    //    for (int i = 0; i < num.length(); i++)
    //    {
    //        if(num.length() == 1)
    //            normal += ROMAN_VALUES;
    //        for (Map.Entry<Integer, String> entry: entrySet())
    //        if(map.get)
    //    }
    //    switch(num[0])
    //    {
//
    //    }
//
    //    return normal;
    //}
}

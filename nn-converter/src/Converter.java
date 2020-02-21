/**
 * This class is responsible for conversion including integer to Roman Numeral conversion. I have decided
 * to make this Converter class to induce modularity into this program (if more conversions are necessary in the future).
 *
 * Developer: Abhi Dubal
 * Purpose: AEM Assessment
 * Date: Feb 20, 2020
 */
public class Converter {

    /**
     * A method that takes an integer as a string and returns its Roman Numeral conversion. Thankfully, I've done a
     * problem similar to this with good optimization. My implementation was inspired by:
     * https://www.youtube.com/watch?v=LBsvAwQbVdw. If the string cannot be parsed as an integer, this method will
     * return "ERROR." If the integer exceeds the allowed conversions, an "OUT OF RANGE" will be returned.
     * @return String - Roman numeral or error
     */
    public String integerToRomanNumeral(String integer)
    {
        String[] ones = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] hundreds = { "", "C", "CC"};

        int number;

        try
        {
            number = Integer.parseInt(integer);
        }
        catch (Exception e)
        {
            return "ERROR";
        }

        if (number > 255)
        {
            return "OUT OF RANGE";
        }

        if (number < 10)
        {
            return ones[number];
        }
        else if (number < 100)
        {
            return tens[number/10] + ones[number % 10];
        }
        else
        {
            return hundreds[number/100] + tens[(number % 100)/10] + ones[(number % 100) % 10];
        }
    }
}

package converter;

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
    	int number;
    	String[] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    	String[] tens = {"","X","XX", "XXX","XL","L","LX","LXX","LXXX","XC"};
    	String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    	String[] thousands = {"","M","MM","MMM"};
    	
        try
        {
            number = Integer.parseInt(integer);
        }
        catch (Exception e)
        {
            return "ERROR";
        }

        if (number > 3999 || number == 0)
        {
            return "OUT OF RANGE";
        }
        
        // Simply retrieve the corresponding digit in the ones array
        if (number < 10)
        {	
            return ones[number];
        }
        // Get the tens digit and concatenate the numeral corresponding to the ones digit
        else if (number < 100)
        {
            return tens[number/10] + ones[number % 10];
        }
        // Get the 100s digit and concatenate the numerals corresponding to the tens digit and the ones digit
        else if (number < 1000)
        {
            return hundreds[number/100] + tens[(number % 100)/10] + ones[(number % 100) % 10];
        }
        else
        {
        	return thousands[number/1000] + hundreds[(number%1000)/100] + tens[((number % 1000) % 100)/10] + ones[((number % 1000) % 100) % 10];
        }
    }
}

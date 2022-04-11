import java.util.List;

public class Numeric {
    public static String convertNumber(String number) {
        if (!isRomanSystem(number)) {
            return number;
        }
        String romanNumeral = number.toUpperCase();
        int result = 0;
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
        int i = 0;

        while ( (romanNumeral.length() > 0) && (i < romanNumerals.size()) ) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(number + " cannot be converted to a Roman system");
        }

        return Integer.toString(result);
    }

    public static String convertStringToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException("The format does not satisfy the task");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public static boolean isRomanSystem(String str) {
        if (str.equals("I") ||
                str.equals("II") ||
                str.equals("III") ||
                str.equals("IV") ||
                str.equals("V") ||
                str.equals("VI") ||
                str.equals("VII") ||
                str.equals("VIII") ||
                str.equals("IX") ||
                str.equals("X")
        ) {
            return true;
        }

        return false;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}

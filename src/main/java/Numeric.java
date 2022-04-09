public class Numeric {
    public static String convertNumber(String number) {
        String formattedNumber = "";
        if (number.equals("I")) {
            formattedNumber = "1";
        } else if (number.equals("II")) {
            formattedNumber = "2";
        } else if (number.equals("III")) {
            formattedNumber = "3";
        } else if (number.equals("IV")) {
            formattedNumber = "4";
        } else if (number.equals("V")) {
            formattedNumber = "5";
        } else if (number.equals("VI")) {
            formattedNumber = "6";
        } else if (number.equals("VII")) {
            formattedNumber = "7";
        } else if (number.equals("VIII")) {
            formattedNumber = "8";
        } else if (number.equals("IX")) {
            formattedNumber = "9";
        } else if (number.equals("X")) {
            formattedNumber = "10";
        } else {
            formattedNumber = number;
        }

        return formattedNumber;
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

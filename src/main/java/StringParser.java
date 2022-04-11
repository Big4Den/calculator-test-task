public class StringParser {
    protected String text;
    StringParser(String text) {
        this.text = text;
    }

    public String parse() throws Exception {
        String[] splitData;
        try {
            splitData = this.text.split("\\s");
            int number1 = Integer.parseInt(Numeric.convertNumber(splitData[0]));
            int number2 = Integer.parseInt(Numeric.convertNumber(splitData[2]));
            String method = splitData[1];

            int calcResult = this.calculate(number1, number2, method);
            if (Numeric.isRomanSystem(splitData[0]) && Numeric.isRomanSystem(splitData[2])) {
                if (calcResult <= 0) {
                    throw new Exception("There are no zero numbers in the Roman system");
                } else {
                    return Numeric.convertStringToRoman(calcResult);
                }
            } else {
                return Integer.toString(calcResult);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private int calculate(int num1, int num2, String method) {
        int result;
        switch (method) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/" :
                result = num1 / num2;
                break;
            default:
                result = 0;
        }

        return result;
    }
}

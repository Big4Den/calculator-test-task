public class StringParser {
    protected String text;
    StringParser(String text) {
        this.text = text;
    }

    public int parse() throws Exception {
        String[] splitData;
        try {
            splitData = this.text.split("\\s");
            int number1 = Integer.parseInt(Numeric.convertNumber(splitData[0]));
            int number2 = Integer.parseInt(Numeric.convertNumber(splitData[2]));
            String method = splitData[1];

            return this.calculate(number1, number2, method);
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

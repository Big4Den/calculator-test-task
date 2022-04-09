import java.util.Arrays;

public class Validation extends Exception{
    protected String message;
    protected String[] mathOperations = {"+", "-", "*", "/"};
    public Validation(String message) {
        this.message = message;
    }

    public String validate() throws Exception {
        String[] splitString = this.message.split("\\s");
        if (
                splitString.length != 3 ||
                !Numeric.isNumeric(Numeric.convertNumber(splitString[0])) ||
                !Numeric.isNumeric( Numeric.convertNumber(splitString[2]) ) ||
                !Arrays.stream(mathOperations).anyMatch(splitString[1]::equals)
        ) {
            throw new Exception("The format does not satisfy the task");
        } else if ( (Numeric.isNumeric(splitString[0]) &&
                Numeric.isRomanSystem(splitString[2])) ||
                (Numeric.isNumeric(splitString[2]) && Numeric.isRomanSystem(splitString[0]))
        ) {
            throw new Exception("Different number systems are used at the same time");
        } else if (
                Integer.parseInt(Numeric.convertNumber(splitString[0])) > 10 ||
                Integer.parseInt(Numeric.convertNumber(splitString[0])) <= 0 ||
                Integer.parseInt(Numeric.convertNumber(splitString[2])) > 10 ||
                Integer.parseInt(Numeric.convertNumber(splitString[2])) <= 0
        ) {
            throw new Exception("The calculator must accept numbers from 1 to 10 inclusive");
        } else if (
                Numeric.isRomanSystem(splitString[0]) &&
                Numeric.isRomanSystem(splitString[2]) &&
                Integer.parseInt(Numeric.convertNumber(splitString[0])) < Integer.parseInt(Numeric.convertNumber(splitString[2])) &&
                splitString[1].equals("-") ) {
            throw new Exception("There are no negative numbers in the Roman system");
        } else {
            return this.message;
        }
    }
}

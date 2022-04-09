import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        StringParser strParsed = new StringParser(getConsoleString());
        try {
            System.out.println(strParsed.parse());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getConsoleString() {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String result = null;
        try {
            Validation validation = new Validation(console.readLine());
            result = validation.validate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        return result;
    }
}

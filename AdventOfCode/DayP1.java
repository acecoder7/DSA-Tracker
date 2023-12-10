import java.util.Scanner;

public class DayP1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder input = new StringBuilder();

        while (true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("done")) {
                break;
            }
            input.append(line).append("\n");
        }

        int sum = 0;

        sum = mainHelper(input.toString());

        System.out.println("Sum of calibration values: " + sum);
    }

    public static int mainHelper(String input) {
        String[] lines = input.split("\n");
        int sum = 0;

        for (String line : lines) {
            sum += getCalVal(line);
        }

        return sum;
    }

    public static int getCalVal(String line) {
        int firstVal = -1;
        int lastVal = -1;
        int val = 0;

        // Extract the first spelled-out digit
        String firstDigit = extractSpelledOutDigit(line, true);

        // Extract the last spelled-out digit
        String lastDigit = extractSpelledOutDigit(line, false);

        // Convert spelled-out digits to numerical values
        if (firstDigit != null) {
            firstVal = convertSpelledOutDigit(firstDigit);
        }
        if (lastDigit != null) {
            lastVal = convertSpelledOutDigit(lastDigit);
        }

        System.out.println(firstVal + " " + lastVal);

        // Combine to form a two-digit number
        val = (firstVal != -1 ? firstVal : 0) * 10 + (lastVal != -1 ? lastVal : 0);
        return val;
    }

    // Function to extract the first or last spelled-out digit from the line
    private static String extractSpelledOutDigit(String line, boolean isFirst) {
        String regex = isFirst ? "([a-zA-Z]+)|([0-9]+)" : "([0-9]+)|([a-zA-Z]+)";
        String[] matches = line.split(regex);
        for (String match : matches) {
            if (match.length() > 0) {
                return match;
            }
        }
        return null;
    }

    // Function to convert spelled-out digits to numerical values
    private static int convertSpelledOutDigit(String spelledOutDigit) {
        switch (spelledOutDigit.toLowerCase()) {
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            default:
                return -1; // Default to -1 for unrecognized spelled-out digits
        }
    }
}

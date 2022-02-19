import java.util.Scanner;

public class WordWrapper {
    // should break text into lines no longer than maxLineLength
    // should break text on word boundaries by replacing a space with a newline char
    // should output the resulting text
    public static String wrap(String text, int maxLineLength) {
        String wrappedString = "";
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()) {
            String word = scanner.next();
            wrappedString += word + "\n";
        }
        System.out.print(wrappedString);
        return wrappedString;
    }

    public static void main(String[] args) {
        WordWrapper.wrap("this text is wrapped", 1);
    }
}

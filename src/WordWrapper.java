import java.util.LinkedList;
import java.util.Scanner;

public class WordWrapper {
    // Should break text into lines no longer than maxLineLength
    // Should break text on word boundaries, by replacing a space with a newline char (does that mean leave punctuation in?)
    // Should output the resulting text
    public static String wrap(String text, int maxLineLength) {
        StringBuilder wrappedString = new StringBuilder();
        Scanner scanner = new Scanner(text);
        LinkedList<String> queue = new LinkedList<>();

        while (scanner.hasNext()) {
            Integer counter = 0;
            StringBuilder line = new StringBuilder();

            // check if queue has any cached words
            while (!queue.isEmpty()) {
                line.append(queue.removeLast());
                if (queue.size() >= 1) {
                    line.append(" ");
                }
            }

            // put words in a queue, keeping track of char count
            while (counter < maxLineLength) {
                try {
                    String word = scanner.next();
                    counter += word.length();

                    if (counter <= maxLineLength) {
                        queue.addFirst(word);
                    } else {
                        ///
                        /// this could be better
                        ///
                        queue.addFirst(word);
                        line.append("\n").append(queue.removeLast());
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            // append the line to the main string
            if (line.length() > 0) {
                wrappedString.append(line).append("\n");
            }
        }

        // check if queue is empty
        if (!queue.isEmpty()) {
            wrappedString.append(queue.removeLast()).append("\n");
        }

        System.out.print(wrappedString);
        scanner.close();
        return wrappedString.toString();
    }

    public static void main(String[] args) {
        WordWrapper.wrap("this text is wrapped", 8);
    }
}

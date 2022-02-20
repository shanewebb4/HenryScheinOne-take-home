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

            // if queue is empty, get next word
            // increment counter
            // if counter is less than max, get next word
            // increment counter
            // if counter is more than max, remove last from queue
            // if queue is not empty, remove last with a space
            // if queue is empty, break and append to master String
            while (counter < maxLineLength) {
                try {
                    String word = scanner.next();
                    counter += word.length();
                    queue.addFirst(word);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            while (!queue.isEmpty()) {
                line.append(queue.removeLast());
                if (queue.size() >= 1) {
                    line.append(" ");
                }
            }
            wrappedString.append(line).append("\n");
        }

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

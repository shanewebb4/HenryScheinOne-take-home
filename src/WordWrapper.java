import java.util.LinkedList;
import java.util.Scanner;

public class WordWrapper {
    // Should break text into lines no longer than maxLineLength
    // Should break text on word boundaries, by replacing a space with a newline char (does that mean leave punctuation in?)
    // Should output the resulting text
    public static String wrap(String text, int maxLineLength) {
        // TODO: what if a word is larger than maxLineLength?

        StringBuilder wrappedString = new StringBuilder();
        Scanner scanner = new Scanner(text);
        LinkedList<String> queue = new LinkedList<>();
        LinkedList<String> cache = new LinkedList<>();

        while (scanner.hasNext()) {
            Integer counter = 0;
            StringBuilder line = new StringBuilder();

            // check if queue has any cached words
            while (!cache.isEmpty()) {
                String forQueue = cache.removeLast();
                counter += forQueue.length();
                queue.addFirst(forQueue);
            }

            // put words in a queue, keeping track of char count
            while (counter < maxLineLength) {
                try {
                    String word = scanner.next();
                    counter += word.length();
                    // add to queue or add to cache?
                    // depends on counter?
                    if (counter < maxLineLength) {
                        queue.addFirst(word);
                        counter++;
                    } else {
                        cache.addFirst(word);
                    }
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

            // append the line to the main string
            if (line.length() > 0) {
                wrappedString.append(line).append("\n");
            }
        }

        // check if queue is empty
        if (!cache.isEmpty()) {
            wrappedString.append(cache.removeLast()).append("\n");
        }

        System.out.print(wrappedString);
        scanner.close();
        return wrappedString.toString();
    }

    public static void main(String[] args) {
        WordWrapper.wrap("This paragraph contains several sentences. The aim is to provide numerous amounts of large words. Also to test the functionality with punctuation.", 20);
    }
}

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
        LinkedList<String> cache = new LinkedList<>();

        while (scanner.hasNext() || !cache.isEmpty()) {
            Integer counter = 0;
            StringBuilder line = new StringBuilder();

            // check if queue has any cached words
            while (!cache.isEmpty()) {
                String forQueue = cache.removeLast();
                counter += forQueue.length();
                if (counter < maxLineLength) {
                    queue.addFirst(forQueue);
                    counter++;
                }
                else {
                    queue.addFirst(forQueue);
                    break;
                }
            }

            // put words in a queue, keeping track of char count
            while (counter < maxLineLength) {
                try {
                    String word = scanner.next();
                    if (word.length() > maxLineLength) {
                        String[] splits = splitWord(word, maxLineLength);
                        for (String split : splits) {
                            counter += split.length();
                            if (counter < maxLineLength) {
                                queue.addFirst(split);
                                counter++;
                            }
                            else if (counter <= maxLineLength) {
                                queue.addFirst(split);
                            }
                            else {
                                cache.addFirst(split);
                            }
                        }
                    }

                    else {
                        counter += word.length();
                        // add to queue or add to cache?
                        // depends on counter?
                        if (counter < maxLineLength) {
                            queue.addFirst(word);
                            counter++;
                        } else {
                            cache.addFirst(word);
                        }
                    }
                } catch (Exception e) {
                    // System.out.println(e);
                    break;
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

    private static String[] splitWord(String wordToSplit, int maxWordLength) {
        int wordLen = wordToSplit.length();
        int size = (wordToSplit.length() / maxWordLength + 1);
        String[] splitWords = new String[size];
        int j =0;
        for (int i=0; i<size; i++) {
            if (i==size-1){
                splitWords[i] = wordToSplit.substring(j);
                continue;
            }
            splitWords[i] = wordToSplit.substring(j, maxWordLength+j);
            j+=maxWordLength;
        }
        return splitWords;
    }

    public static void main(String[] args) {
         WordWrapper.wrap("Toneenormousandridiculouslylargewordthatisfake", 5);
    }
}

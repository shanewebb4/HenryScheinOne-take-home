import java.util.LinkedList;
import java.util.Scanner;

public class WordWrapper {
    // Should break text into lines no longer than maxLineLength
    // Should break text on word boundaries, by replacing a space with a newline char (does that mean leave punctuation in?)
    // Should output the resulting text
    public static String wrap(String text, int maxLineLength) {
        // setup a scanner to read the text
        // setup two queues for managing the breaks
        StringBuilder wrappedString = new StringBuilder();
        Scanner scanner = new Scanner(text);
        LinkedList<String> queue = new LinkedList<>();
        LinkedList<String> cache = new LinkedList<>();

        while (scanner.hasNext() || !cache.isEmpty()) {
            Integer counter = 0;
            StringBuilder line = new StringBuilder();

            // check if cache has anything to move to queue
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

                    // if word length is > maxLineLength, split that word
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

                    // otherwise add word to queue or cache, depending on char count
                    else {
                        counter += word.length();
                        if (counter < maxLineLength) {
                            queue.addFirst(word);
                            counter++;
                        }
                        else if (counter <= maxLineLength) {
                            queue.addFirst(word);
                        }
                        else {
                            cache.addFirst(word);
                        }
                    }
                } catch (Exception e) {
                    // should only reach here if scanner is at the end of the text
                    break;
                }
            }

            // append the word(s) that have been queued up
            // add a space if there is more than one word
            while (!queue.isEmpty()) {
                line.append(queue.removeLast());
                if (queue.size() >= 1) {
                    line.append(" ");
                }
            }

            // append the line of words to the return value
            if (line.length() > 0) {
                wrappedString.append(line).append("\n");
            }
        }

        // append anything left in the cache
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
         WordWrapper.wrap("Fortuitously, this paragraph accommodates some large letter designations, and small words. The aim is to corroborate the functionality of the wrap function when filled with many words, large and small.", 5);
    }
}

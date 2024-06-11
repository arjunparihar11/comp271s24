import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.InputStream;

/*
NO IMPORT STATEMENTS. NO CALLS TO SYSTEM.anything, except for 
System.out.println or print or printf as needed.
 */ 
public class BookReview {

    /**
     * Establishes a Scanner on a weblink. If the connection can not be made,
     * the method returns a null. That's how we can tell something went wrong
     * and decide what to do next.
     * @param link String with link to website with text to scan
     * @return Scanner connected to the website or null if connection cannot be made
     */
    public static Scanner connectToBook(String link) {
        Scanner bookScanner;
        try {
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream stream = connection.getInputStream();
            bookScanner = new Scanner(stream);
        } catch (Exception e) {
            bookScanner = null;
        }
        return bookScanner;
    } // method connecttoBook

    public static void main(String[] args) {
        // https://gutenberg.org/cache/epub/98/pg98.txt is a link
        // to the text of "Tale of Two Cities" from Project Gutenberg
        String book = "https://gutenberg.org/cache/epub/98/pg98.txt";
        //Print out number of unique words
        //System.out.println("A Tale of Two Cities has " + countUnique(connectToBook(book)) + " unique words.");
        System.out.printf("%nA Tale of Two Cities has %d unique words.%n", countUnique(connectToBook(book)));
    } // method main

    /**
     * Loops through the scanner of the book's txt as long as there is a next word
     * if that word was successfully added via the DyanmicArray's addUnique function
     * the counter will go up.
     * @param scanner Scanner of the book's txt returned from connectToBook function
     * @return int count of the number of unique words from the given scanner
     */
    public static int countUnique(Scanner scanner) {
        int count = 0;//int counter for unique words
        DynamicArray unique = new DynamicArray();//use Dynamic array with built in addUnique function
        while(scanner.hasNext()){//while txt has next word, keep loop going
            if(unique.addUnique(scanner.next()))//addUnique was a boolean that returns true when it functions, so we can use this to count the number of unique words added to the array
                count++;
        }
        return count;
    }//method countUnique
} // class BookReview

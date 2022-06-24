package edu.sdsu.cs.datastructures;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//my text.txt file is in my program folder
public class Driver {

    public static void main(String[] args) throws FileNotFoundException {

        int degree = 4;                                                 //degree for constructor that handles degrees higher than one
        ArrayList<String> text = new ArrayList<>();                     //new list

        Scanner scanner = new Scanner(new File(args[0])).               //scanner for file
                useDelimiter("(\\p{javaWhitespace}|\\.|\\,|\\-|;)+");   //removes white space and taken in part from stack overflow

        while(scanner.hasNext()) {                                  //scanner reads file adds to
            text.add(scanner.next().toLowerCase());                 //adds to list as lower case
        }
        scanner.close();                                            //close scanner

        System.out.println("Text file: " + text);                   //print out sample file text

        //frequency count for degree 1 and method tests
        FrequencyCount fqDegOne = new FrequencyCount(text);
        System.out.println("\nFor Degree 1");
        fqDegOne.head();
        fqDegOne.tail();

        String randomToken1 = fqDegOne.randomToken();
        System.out.println("\nRandom Token: " + randomToken1);
        System.out.println("Frequency Count for Random Token: " + fqDegOne.count(randomToken1));
        System.out.println("Percent of Random Token: " + fqDegOne.percent(randomToken1));

        System.out.println("\nFrequency Count for Input Token: " + fqDegOne.count("the"));
        System.out.println("Percent of Input Token: " + fqDegOne.percent("the"));

        //frequency count for degree > 1 and method tests
        FrequencyCount fqDegHigh = new FrequencyCount(text, degree);
        System.out.println("\nFor Degree Higher than 1");
        fqDegHigh.head();
        fqDegHigh.tail();

        String randomToken2 = fqDegHigh.randomToken();
        System.out.println("\nRandom Token: " + randomToken2);
        System.out.println("Frequency Count for Random Token: " + fqDegHigh.count(randomToken2));
        System.out.println("Percent of Random Token: " + fqDegHigh.percent(randomToken2));

    }
}

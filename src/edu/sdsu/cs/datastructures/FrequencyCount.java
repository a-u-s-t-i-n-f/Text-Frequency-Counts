package edu.sdsu.cs.datastructures;

import java.io.*;
import java.util.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.toList;

public class FrequencyCount {

    private HashMap<String, Integer> map;

    //Frequency count for degree 1
    public FrequencyCount(List<String> text) throws FileNotFoundException {
        map = new HashMap<String, Integer>();
        for(int x = 0; x < text.size(); x++) {
            add(text.get(x));
        }
    }

    //Frequency count for degree > 1
    public FrequencyCount(List<String> text, int degree) throws FileNotFoundException {
        map = new HashMap<String, Integer>();

        for(int i = 0; i < text.size() - degree; i++) {     //loop whole list
            String string = " ";                            //space to separate words
            StringBuilder str = new StringBuilder();        //stringbuilder for degree higher than one
            str.append(text.get(i));                        //append strings

            for(int j = i + 1; j < i + degree; j++) {       //loop for string concatenation
                str.append(string + text.get(j));           //string concatenation

            }
            add(str.toString());                            //add concatenated to string
        }
    }

    //return a list of strings of the most occurring values
    List<String> head() {
        List<Map.Entry<String, Integer>> most20 = map.entrySet().stream()   //stream list
                .sorted(comparing(Map.Entry::getValue, reverseOrder()))     //sorted comparison of top
                .limit(20)                                                  //limit of 20
                .collect(toList());                                         //add to list
        //above method taken in part from Stack Overflow
        System.out.println("Top 20 Most Occurring: " + most20);
        return null;
    }

    //return a list of strings of the least occurring values
    List<String> tail() {
        List<Map.Entry<String, Integer>> least20 = map.entrySet().stream()  //stream list
                .sorted(comparing(Map.Entry::getValue, naturalOrder()))     //sorted comparison of bottom
                .limit(20)                                                  //limit of 20
                .collect(toList());                                         //add to list
        //above method taken in part from Stack Overflow
        System.out.println("Top 20 Least Occurring: " + least20);
        return null;
    }

    String randomToken() {
        List<String> Keys = new ArrayList<>(map.keySet());  //put keys in list
        Random randomIndex = new Random();                  //random Generator
        return Keys.get(randomIndex.nextInt(Keys.size()));  //return random key in the list
    }

    int count(String token) {
        if(token == null) {         //if token is null return 0
            return 0;
        }
        else {                      //else return token
            return map.get(token);
        }
    }

    double percent(String token) {
        double tokenPercent = 0.0;
        if(map.containsKey(token)) {                //if map has the token
            tokenPercent = (double) map.get(token)  //token percentage is calculated
                    / (double) map.size();
        }
        return tokenPercent;                        //return percent
    }

    //inserts token into map and manipulates the count by 1
    int add(String token) {
        if(!map.containsKey(token)) {
            map.put(token, 1);
        }
        else {
            map.put(token, map.get(token) + 1);
        }
        return map.get(token);
    }
}

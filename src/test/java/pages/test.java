package pages;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class test {
    /*
    Requirement:
    -Student is responsible to create a main method and test their method.

    -Write a method that takes an array of String and returns the count of each unique element in the array as a Map

    Test Data:
    ["Apple", "Apple", "Orange", "Apple", "Kiwi"]

    Expected:{Apple=3, Orange=1, Kiwi=1}

     */

    public static Map<String, Integer> countElements(String[] arr){
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String element : arr) {
            if(!map.containsKey(element)) map.put(element, 1);
            else map.put(element, map.get(element)+1);
        }
        return map;
    }
    public static void main(String[] args) {

    }
}

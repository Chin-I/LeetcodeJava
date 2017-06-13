/**
 * Created by Gene on 6/7/17.
 */


import java.io.*;
import java.util.*;
//import java.util.ArrayList;

public class CoderPad {


    public class ListNode{
        int val;
        ListNode next;
        ListNode (int x){
            val = x;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();

        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java 8.");

        for (String string : strings) {
            System.out.println(string);
        }
    }
}



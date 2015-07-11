package com.intro.collection;

import java.util.*;

//Run in this format : java Freq if it is to be it is up to me to delegate
public class FreqTreeMap {
    public static void main(String[] args) {
        Map<String, Integer> m = new TreeMap<String, Integer>();

        // Initialize frequency table from command line
        for (String a : args) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
    }
}
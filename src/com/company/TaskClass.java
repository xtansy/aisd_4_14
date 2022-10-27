package com.company;

import java.util.*;

public class TaskClass {
     static private List<String> doubleStrSplit(String str) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < str.length() - 1; i += 2){
            res.add(str.charAt(i) + String.valueOf(str.charAt(i+1)));
        }

        return res;
    }

    static private List<String> sortStrArr(List<String> list) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (map.containsKey(s)) {
                int value = map.get(s);
                map.put(s, ++value);
            } else {
                map.put(s, 1);
            }
        }

        System.out.println("Default map: " + map);
        // Get entry set of the TreeMap using entrySet
        // method
        Set<Map.Entry<String, Integer> > entrySet
                = map.entrySet();

        // Convert entrySet to Array using toArray method
        Map.Entry<String, Integer>[] entryArray
                = entrySet.toArray(
                new Map.Entry[entrySet.size()]);


        int n = entryArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (entryArray[j].getValue() < entryArray[j + 1].getValue()) {
                    Map.Entry<String, Integer> temp = entryArray[j];
                    entryArray[j] = entryArray[j + 1];
                    entryArray[j + 1] = temp;
                }
            }

        }

        System.out.println("Sorted map: " + Arrays.toString(entryArray));

        for (Map.Entry<String, Integer> stringIntegerEntry : entryArray) {
            result.add(stringIntegerEntry.getKey());
        }

        return result;
    }



    static public List<String> task (String str) {
        List<String> doubleStrArr = TaskClass.doubleStrSplit(str);
        return  TaskClass.sortStrArr(doubleStrArr);
    }
}

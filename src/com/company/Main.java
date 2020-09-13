package com.company;

import java.util.*;

public class Main {
    public static void solution(String str){
        HashMap<Character, StringBuilder> hashChars = new HashMap<Character, StringBuilder>();
        HashMap<Character, Integer> hashIndex = new HashMap<Character, Integer>();

        //Looping for string to prepare data for next operations.
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            char lowerCh = Character.toLowerCase(ch);
            hashIndex.put(lowerCh, i);
            hashChars.put(lowerCh, hashChars.getOrDefault(lowerCh,new StringBuilder()).append(ch));
        }
        // Finding first unique element of string and printing back to user.
        for(char ch : str.toCharArray()){
            char lowerCh = Character.toLowerCase(ch);
            if(hashChars.get(lowerCh).length() == 1){
                System.out.print(lowerCh);
                hashChars.remove(lowerCh);
                hashIndex.remove(lowerCh);
                break;
            }
        }
        //Sorting rest of the string and printing back to user.
        List<Character> keys = new ArrayList<Character>(hashIndex.keySet());
        Collections.sort(keys, (a,b)->{
            Integer countA = hashChars.get(a).length();
            Integer countB = hashChars.get(b).length();
            if(countA.compareTo(countB) != 0){ 
                return countA.compareTo(countB);
            }else{
                return hashIndex.get(a).compareTo(hashIndex.get(b));
            }
        });
        StringBuilder output = new StringBuilder("");
        for(char ch : keys){
            output.append(hashChars.get(ch));
        }
        System.out.println(output);
        return;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string;
        System.out.print("Write some string: ");
        while((string = in.nextLine()) != null){
            solution(string);
            System.out.print("Write some string : ");
        }
    }
}

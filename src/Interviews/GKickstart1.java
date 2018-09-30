package Interviews;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GKickstart1 {

    public static void main(String args[]){

        try {
            Scanner s = new Scanner(new File("a_small_1.txt"));
            int iterations = s.nextInt();

            for (int i = 0; i < iterations; i++){
                s.nextInt();
                s.nextLine();
                System.out.println("Case #" + (i+1) + ": " +
                        anagrams(s.nextLine(), s.nextLine()));
            }


        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public static int anagrams(String string1, String string2){
        int count = 0;
        for (int i = 1; i <= string1.length(); i++){
            count += matches(string1, string2, i);
        }
        return count;
    }


    public static int[] charArray(String baseString, int start, int end){
        int cArray[] = new int[26];
        for (int i = start; i < end; i++){
            cArray[baseString.charAt(i)-65]++;
        }
        return cArray;
    }

    public static int matches(String string1, String string2, int length){
        int c1[] = charArray(string1, 0, length);
        int c2[]= charArray(string2, 0, length);
        int i = length-1;
        int count  = 0;

        for (int s1Index = length-1; s1Index < string1.length(); s1Index++) {
            do {
                if (Arrays.equals(c1, c2)) {
                    count++;
                    break;
                }
                    c2[string2.charAt((i++)-length+1) - 65]--;
                if (i < string2.length()) {
                    c2[string2.charAt(i) - 65]++;
                }
            } while (i < string2.length());

            if (s1Index+1 < string1.length()) {
                i = length-1;
                c1[string1.charAt(s1Index-length+1) - 65]--;
                c1[string1.charAt(s1Index + 1) - 65]++;
                c2 = charArray(string2, 0, length);
            }
        }
        return count;
    }

}

package Interviews;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reverse {

    public static Sorting.Node reverseLinkedList(Sorting.Node head, Sorting.Node prevPtr){
        if (head == null) return null;
        Sorting.Node temp;
        if (head.nextptr != null){
            temp = reverseLinkedList(head.nextptr, head);
        }else{
            temp = head;
        }
        head.nextptr = prevPtr;
        return temp;
    }
    public static void reverseString(String s, int i){
        if (s.length() < 1) System.out.println("Empty string");
        if (i < s.length()-1){
            reverseString(s, i+1);
        }
        System.out.print(s.charAt(i));
    }

    public static void reverseSentence(String s){
        if (s.isEmpty()) System.out.println("empty string");
        int i = s.indexOf(' ');
        if (i > 0 ){
            reverseSentence(s.substring(i+1, s.length()));
            System.out.print(s.substring(0, i) + " ");
        }else {
            System.out.print(s + " ");
        }
    }
    public static void reverseFile(String fileName){
        try {
            String temp = null;
            Scanner s = new Scanner(new File(fileName));
            helper(s);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public static void helper(Scanner s){
        if (s.hasNextLine()){
            String temp = s.nextLine();
            helper(s);
            System.out.println(temp);
        }
    }



    public static void main(String args[]){
//        Sorting.linkedList list = new Sorting.linkedList();
//        list.add(Sorting.Main.generateRandomArray(0));
//        list.printList();
//        Sorting.Node newHead = reverseLinkedList(list.head, null);
//        list.head = newHead;
//        list.printList();

        //reverseString("microsoft", 0);

        //reverseSentence("you are how hi");

        reverseFile("foobar.txt");
    }
}

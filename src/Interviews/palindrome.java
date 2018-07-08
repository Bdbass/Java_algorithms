package Interviews;

public class palindrome {

    //returns second half of the reversed linked list
    static Sorting.Node ReverseHalfLinkedList (Sorting.linkedList list){
        //find half-way point
        Sorting.Node half = Split(list.head);
        //reverse linked list
        return reverse(half);
    }

    //returns the middle of a linked list
    static Sorting.Node Split(Sorting.Node head){
        //using slow and fast pointers
        Sorting.Node slow  = head;
        Sorting.Node fast = slow;
        while (fast != null){
            fast = fast.nextptr;
            if (fast != null){
                fast = fast.nextptr;
                slow = slow.nextptr;
            }
        }
        return slow;
    }
    //Reverse a linked list
    static Sorting.Node reverse(Sorting.Node head){
        //create three pointers
        Sorting.Node p1 = null;
        Sorting.Node p2 = head;
        Sorting.Node p3 = head.nextptr;

        //reverse linked list
        while (p3 != null){
            p2.nextptr = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.nextptr;
        }
        //still need to do one more reverse
        p2.nextptr = p1;

        return p2;
    }


    //returns the longest palindrome
    static String LongestPalindrome(String input){
        //initialize vars
        String longest_p = "";
        int temp_i, temp_j;

        // mXn time complexity to find longest palindrome
        for (int i = 0; i < input.length(); i++){
            // makes it mXn
            for (int j = input.length()-1; j >= 0; j--){
                if (longest_p.length() > j -i) break;
                temp_i = i;
                temp_j = j;

                // look for palindrome
                while (temp_i < input.length() && temp_j >= 0 &&
                        input.charAt(temp_i) == input.charAt(temp_j) &&
                        temp_i <= temp_j){
                    temp_i++; temp_j--;
                }
                //update palindrome if necessary
                if (temp_i >= temp_j && j-i >= longest_p.length()){
                    longest_p = input.substring(i,j+1);
                }

            }
        }
        return longest_p;
    }


    //test method
    public static void main(String args[]) {
        //System.out.println(LongestPalindrome("sdfabocobaasdf"));
        Sorting.linkedList list = new Sorting.linkedList();
        list.add(new int[]{1,2,3,4,5,6,7,8,9,10,11});
        Sorting.Node head = ReverseHalfLinkedList(list);
        Sorting.Node temp = head;
        while (temp != null){
            System.out.print(temp.data + "->");
            temp = temp.nextptr;
        }
    }
}

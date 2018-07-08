package Interviews;

public class palindrome {

    //returns second half of the reversed linked list
    static Sorting.Node ReverseHalfLinkedList (Sorting.Node head){
        //find half-way point
        Sorting.Node half = Split(head);
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
    //fix me
    static Sorting.Node reverse(Sorting.Node head){
        return head;
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
        System.out.println(LongestPalindrome("sdfabocobaasdf"));
    }
}

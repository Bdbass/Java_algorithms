package Sorting;

public class MergeLinkedList {

    // tests to make sure the merge sort works
    public static void main(String args[]) {
        Node head = new Node(25);
        linkedList newList = new linkedList(head);
        int[] array = Main.generateRandomArray(30);
        newList.add(array);
        newList.printList();
        MergeSort(newList);
        newList.printList();
    }

    // driver function
    static void MergeSort(linkedList unsorted){
        Node newHead = Partiton(unsorted.head); // gets the new head of the sorted list
        unsorted.head = newHead; // updates the unsorted list head to the new head
        // updates the unsorted listList tail to the correct tail, now it is sorted
        Node temp = newHead;
        while (temp.nextptr != null){
            temp = temp.nextptr;
        }
        unsorted.tail = temp;
    }

    //returns the middle node of the linked list
    private static Node Middle(Node head){
        Node slow = head;
        Node fast = head;

        // move slow one at a time, move fast two at a time, splits list in half
        while (fast.nextptr !=null){
            fast = fast.nextptr;
            if (fast.nextptr != null){
                fast = fast.nextptr;
                slow = slow.nextptr;
            }
        }
        return slow;
    }

    // splits the linked list in half and then merges it
    private static Node Partiton(Node head){
        if (head != null && head.nextptr != null) {// if it is null, then no need to partition

            Node middle = Middle(head); // the middle node
            Node s2 = middle.nextptr; // start of the second partition is one past the middle
            middle.nextptr = null; // cut off the linked lists from each other

            Node left = Partiton(head); // new start1
            Node right = Partiton(s2); //new start2

            return Merge(left, right);
        }else {
            return head;
        }
    }
    // merges the two linked lists
    private static Node Merge (Node s1, Node s2){
        if (s2 == null) return s1; // base case

        // assign our head pointer to the lower of the two
        Node head;
        if (s1.data < s2.data) {
            head = s1;
            s1 = s1.nextptr;
        }else {
            head = s2;
            s2 = s2.nextptr;
        }

        Node temp = head;
        // combine the two linked lists together
        while (s1 != null && s2 != null){
            if (s1.data < s2.data){
                temp.nextptr = s1;
                s1 = s1.nextptr;
            }else{
                temp.nextptr = s2;
                s2 = s2.nextptr;
            }
            temp = temp.nextptr;
        }
        if (s1 != null) temp.nextptr = s1;
        if (s2 != null) temp.nextptr = s2;

        //return the head of the combined linked list
        return head;
    }

}

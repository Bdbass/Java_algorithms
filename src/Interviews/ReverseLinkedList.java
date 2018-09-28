package Interviews;

public class ReverseLinkedList {

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

    public static void main(String args[]){
        Sorting.linkedList list = new Sorting.linkedList();
        list.add(Sorting.Main.generateRandomArray(0));
        list.printList();
        Sorting.Node newHead = reverseLinkedList(list.head, null);
        list.head = newHead;
        list.printList();
    }
}

package Sorting;

public class linkedList {
    Node head;
    Node tail;
    int size;

    linkedList(){
        head = tail = null;
        size = 0;
    }
    linkedList(Node _head) {
        head = tail = _head;
        size = 1;
    }
    void add(int data){
        tail.nextptr = new Node(data);
        tail = tail.nextptr;
        size++;
    }
    void add(int[] array){
        for (int i: array){
            add(i);
        }
    }
    void printList(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.nextptr;
        }
        System.out.println();
    }
}

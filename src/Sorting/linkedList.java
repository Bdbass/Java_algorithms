package Sorting;

public class linkedList {
    public Node head;
    public Node tail;
    int size;

    public linkedList(){
        head = tail = null;
        size = 0;
    }
    public linkedList(Node _head) {
        head = tail = _head;
        size = 1;
    }
    public void add(int data){
        if (tail == null){
            tail = head = new Node(data);
        }else {
            tail.nextptr = new Node(data);
            tail = tail.nextptr;
        }

        size++;
    }
    public void add(int[] array){
        for (int i: array){
            add(i);
        }
    }
    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.nextptr;
        }
        System.out.println();
    }
}

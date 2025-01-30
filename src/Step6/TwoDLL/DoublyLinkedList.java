package Step6.TwoDLL;
class Node{
    int data;
    Node next;
    Node back;

    Node(int data1, Node next1, Node back1){
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    Node(int data1){
        this.data = data1;
        next = null;
        back = null;
    }
}

public class DoublyLinkedList {
    private static Node convertArr2DLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev =temp;
        }
        return  head;
    }
    private static void print(Node head){
        while (head != null){
            System.out.print(head.data+ " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        int[] arr = {3,4,6,89,64,3};
        Node head = convertArr2DLL(arr);
        print(head);

    }
}
/*

converting an array to the Doubly Linked list
Node head = new Node(arr[0] nullPtr, nullPtr);
Node prev = head;
for(i ==1 ---> n-1){
   Node *temp = new Node(arr[i], nullPtr, prev);
   prev.next = temp;
   prev = temp;
   }
return head;
 */
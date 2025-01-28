package Step6;

class Node{
    int data;
    Node next;

    Node(int data1, Node next){
        this.data = data1;
        this.next = next;
    }

    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}
public class LinkedList {
    private static Node ConvertArr2LL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    private static int LengthOfLL(Node head){
        int cnt = 0;
        Node temp = head;
        while (temp != null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
    private static boolean checkIfPresent(Node head, int val){
        Node temp = head;
        while (temp != null){
            if (temp.data == val) return true;
            temp = temp.next;
        }
        return false;
    }
    private static void print(Node head){
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    private static Node RemoveHead(Node head){
        if (head == null) return head;
        head = head.next;
        return head;
    }
    private static Node RemoveTail(Node head){
        if (head == null || head.next == null) return null;
        Node temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,7};
        Node head = ConvertArr2LL(arr);
        print(head);
        head = RemoveHead(head);
        print(head);
        RemoveTail(head);
        print(head);
    }
}
/*
The T.C. in this will be O(n)
 */
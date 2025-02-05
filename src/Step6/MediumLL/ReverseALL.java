package Step6.MediumLL;

import java.util.*;

public class ReverseALL {
    private static Node convert2Arr(int[] arr){
        Node head = new Node(arr[0]);
        Node move = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            move.next = temp;
            move = temp;
        }
        return head;
    }
    private static void print(Node head){
        while (head != null){
            System.out.print(head.data+ " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
//    This takes O(n) and S.c. O(n)
    private static Node StackBased(Node head){
        Node temp = head;
        Stack<Integer> st = new Stack<>();
        while (temp != null){
            st.push(temp.data);
            temp = temp.next;
        }
        Node temp2 = head;
        while (!st.empty()){
            int var = st.peek();
            temp2.data = var;
            st.pop();
            temp2 = temp2.next;
        }
        return head;
    }
//    O(n)
    private static Node OptimalApproach(Node head){
        Node temp = head;
        Node prev = null;
        while (temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return  prev;
    }
//    The T.C. of this problem is O(n) and S.C. is O(n)
    private static Node Recursive(Node head){
        if (head == null || head.next == null) return head;
        Node newHead = Recursive(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = {2,34,5,7,76,43,16,4,5,77};
        Node head = convert2Arr(arr);
        print(head);
        head = Recursive(head);
        print(head);
    }
}
/*

 */
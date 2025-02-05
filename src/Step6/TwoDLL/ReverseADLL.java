package Step6.TwoDLL;

import java.util.*;

public class ReverseADLL {
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

//    The T.C. of this approach will be the O(2n) and S.C. will be O(n) for the use of stack
    private static Node Naive(Node head){
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while (temp != null){
            st.push(temp.data);
            temp = temp.next;
        }
        Node temp2 = head;
        while (!st.empty()){
            int val = st.peek();
            temp2.data = val;
            st.pop();
            temp2 = temp2.next;
        }
        return  head;
    }
//    The T.C. of this optimal approach will be O(n) and S.C. will be O(1)
    private static Node Optimal(Node head){
        if (head == null || head.next == null) return head;
        Node prev = null;
        Node curr = head;
        while (curr != null){
            prev = curr.back;
            curr.back = curr.next;
            curr.next = prev;
            curr = curr.back;
        }
        return prev.back;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,6,89,64};
        Node head = convertArr2DLL(arr);
        print( head);
        head = Optimal(head);
        print(head);
    }
}
/*
Extreme Naive -
Traverse through the LL and Use the stack DS for storing the values & after that again use the stack DS and put the values back to the DLL

 */
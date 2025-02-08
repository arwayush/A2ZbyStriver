package Step6.MediumLL;

import java.util.Stack;

public class CheckIfTheLinkedListIsPalindrome {
//    this takes the T.C. of the O(2*N) and S.C. of O(n)
    private static boolean HashingApp(Node head){
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while (temp != null){
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null){
            int val = st.pop();
            if (val != temp.data) return false;
            temp = temp.next;
        }
        return true;
    }

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
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,2,1};
        Node head = convert2Arr(arr);
        System.out.println(HashingApp(head));

    }
}
/*
check if the given linked list is palindrome or not
1 -> 2 -> 3 -> 2 -> 1
brute force aproach -
 1. use the stack data structure put the values in the stack
 2. traverse the ll and the stack if the values comes the same it means it is pallindrome
 */
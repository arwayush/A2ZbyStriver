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
//    this will take the T.C. of the O(2*N) and S.C. of O(1)
    public static Node reverseLL(Node head){
        if (head == null || head.next == null) return head;
        Node newHead = reverseLL(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    private static boolean Reverse2Pointer(Node head){
         // pallindrome by the definition
        if (head == null || head.next == null) return true;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newHead = reverseLL(slow.next);
        Node first = head;
        Node second = newHead;
        while (second != null){
            if (first.data != second.data){
                reverseLL(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseLL(newHead);
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
        int[] arr = {1,2,3,4,3,2,1};
        Node head = convert2Arr(arr);
        System.out.println(HashingApp(head));
        System.out.println(Reverse2Pointer(head));

    }
}
/*
check if the given linked list is palindrome or not
1 -> 2 -> 3 -> 2 -> 1
brute force aproach -
 1. use the stack data structure put the values in the stack
 2. traverse the ll and the stack if the values comes the same it means it is pallindrome


 Reverse 2 pointer Approach
 1. first we'll find out the middle of the linked list (mid2) in case of even length
 2. reverse the 2nd half, and compare, if the comparison goes right then return true, else false
 3. after getting the result we'll reverse back the linked list

 */
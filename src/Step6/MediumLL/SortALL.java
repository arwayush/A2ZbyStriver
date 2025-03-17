package Step6.MediumLL;

import java.util.*;

public class SortALL {
    private static Node convert2Arr(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            tail.next = temp;
            tail = temp;
        }
        return head;
    }
    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
//    The T.C. is O(n + nlogn + n) and S.C. IS O(n)
    private static Node Naive(Node head){
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;
        while (temp != null){
            arr.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(arr);
        temp = head;
        int i = 0;
        while (temp != null){
            temp.data = arr.get(i);
            i++;
            temp = temp.next;
        }
        return head;
    }
//    Applying the Merge Sort on the Linked List
    private static Node findMiddle(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast =fast.next.next;
        }
        return slow;
    }
    private static Node mergeTwoLists(Node list1, Node list2){
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (list1 != null && list2 != null){
            if (list1.data < list2.data){
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) temp.next = list1;
        else temp.next = list2;
        return dummy.next;
    }
    private static Node Optimal(Node head){
        if(head == null  || head.next == null) return  head;
        Node middle = findMiddle(head);
        Node right = middle.next;
        middle.next = null;
        Node left = head;


        left = Optimal(left);
        right = Optimal(right);
        return mergeTwoLists(left, right);
    }
    public static void main(String[] args) {
        int arr[] = {3,4,2,1,5};
        Node head = convert2Arr(arr);
        print(head);
        Node newHead = Optimal(head);
        print(newHead);
    }
}

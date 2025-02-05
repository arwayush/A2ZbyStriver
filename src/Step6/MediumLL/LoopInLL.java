package Step6.MediumLL;

import java.util.HashMap;

public class LoopInLL {
    private static Node convert2CyclicArr(int[] arr, int pos){
        Node head = new Node(arr[0]);
        Node move = head;
        Node cycleNode = null;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            move.next = temp;
            move = temp;
            if (i == pos) cycleNode = temp;
        }
        if (pos != -1) move.next = cycleNode;
        return head;
    }
    private static void print(Node head){
        while (head != null){
            System.out.print(head.data+ " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
//    O(N * 2*logN) and S.C. O(n)
    private static boolean HashingApp(Node head){
        HashMap<Node, Integer> mp = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            if (mp.containsKey(temp)) return true;
            mp.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }

    private static boolean TortoiseAndHare(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;  // Move slow one step
            fast = fast.next.next; // Move fast two steps
            if (slow == fast) { // Check if slow and fast pointers meet
                return true;  // Loop detected
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,4};
        int pos = 4;
        Node head = convert2CyclicArr(arr, pos);
        System.out.println(TortoiseAndHare(head));

    }
}
/*
If the slow and the fast pointers are standing at the same position it means there is loop present
 */
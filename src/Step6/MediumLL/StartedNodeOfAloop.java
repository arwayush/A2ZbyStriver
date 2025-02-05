package Step6.MediumLL;

import java.util.HashMap;

public class StartedNodeOfAloop {
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
//    The T.C. of O(n*2) and S.C. O(n)
    private static Node HashMapApp(Node head){
        Node temp = head;
        HashMap<Node, Integer> mp = new HashMap<>();
        while (temp != null){
            if (mp.containsKey(temp)){
                return temp;
            }
            mp.put(temp, 1);
            temp= temp.next;
        }
        return null;
    }

    private static Node TortoiseAndHare(Node head){
        /*
        Step 1 -> Detecting a loop, slow and fast pointers will collide
        Step 2 -> Now fast pointer will be at the collision point and slow pointer will be at starting node
        Step 3 -> Need to find the recolliding point of the Linked list and that will be our starting point of LL
         */
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){ //putting the fast at the collision point and putting the slow at the head
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; //starting point
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,4};
        int pos = 4;
        Node head = convert2CyclicArr(arr, pos);
        Node ans = TortoiseAndHare(head);
        System.out.println(ans.data);
    }
}

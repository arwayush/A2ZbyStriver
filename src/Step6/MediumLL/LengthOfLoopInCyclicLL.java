package Step6.MediumLL;

import java.util.HashMap;

public class LengthOfLoopInCyclicLL {
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
//   The T.C. of this approach will be O(n) & S.C. is O(n)
    private static int HashingConc(Node head){
        HashMap<Node, Integer> mp = new HashMap<>();
        Node temp = head;
        int timer = 0;
        while (temp != null){
            if (mp.containsKey(temp)){
                int val = mp.get(temp);
                return timer-val;
            }
            mp.put(temp, timer);
            temp = temp.next;
            timer++;
        }
        return 0;
    }

    protected static int findLength(Node slow, Node fast) {
        int cnt = 1;
        fast = fast.next;
        while (slow != fast){
            cnt++;
            fast = fast.next;
        }
        return cnt;
    }
    private static int TortoiseAndHare(Node head){
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast != null){
            slow = slow.next;
            fast =fast.next.next;
            if (slow == fast){
                return findLength(slow, fast);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,4};
        int pos = 4;
        Node head = convert2CyclicArr(arr, pos);
        int ans = TortoiseAndHare(head);
        System.out.println(ans);
    }
}

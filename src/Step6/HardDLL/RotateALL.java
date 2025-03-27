package Step6.HardDLL;

public class RotateALL {
    private static Node convert2Arr(int[] arr) {
        Node head = new Node(arr[0]);
        Node move = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            move.next = temp;
            move = temp;
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
    private static Node BruteForceRotated(Node head, int k){
       if (head == null || head.next == null) return head;
        for (int i = 0; i < k; i++) {
            Node temp = head;
            while (temp.next.next != null) temp = temp.next;
            Node end = temp.next;
            temp.next = null;
            end.next = head;
            head = end;
        }
        return head;
    }
    private static Node findNthNode(Node temp, int k){
        int cnt  = 1;
        while (temp != null){
            if (cnt == k) return temp;
            cnt++;
            temp = temp.next;
        }
        return temp;
    }
//    O(2n) ans S.C. is O(1)
    private static Node OptimallyRotated(Node head, int k){
        if (head == null || k == 0) return head;
        Node tail = head;
        int len = 1;
        while (tail.next != null){
            tail = tail.next;
            len += 1;
        }
        if (k % len == 0) return head;
        k = k % len;
        //attach the tail to the head;
        tail.next = head;
        Node newNode = findNthNode(head, len-k);
        head = newNode.next;
        newNode.next = null;
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int k = 3;
        Node head = convert2Arr(arr);
        head = OptimallyRotated(head, k);
        print(head);

    }
}

/*
Optimal Approach
1. find the length of the LL and k, if (k % len == 0) no need to do anything
2. if (k % len != 0) then,
tail.next == head
3. find the element and make its next to null


 */
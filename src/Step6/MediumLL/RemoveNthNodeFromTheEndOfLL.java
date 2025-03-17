package Step6.MediumLL;

public class RemoveNthNodeFromTheEndOfLL {
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
//    Brute Force Approach
    private static Node RemoveNthNode(int n, Node head){
        if (head == null) return null;
        int count = 0;
        Node temp = head;
        while (temp != null){
            count++;
            temp =temp.next;
        }
        if (count == n){
            Node newHead = head.next;
            head = null;
            return newHead;
        }
        int res = count - n;
        temp = head;
        while (temp != null){
            res--;
            if (res == 0) break;
            temp = temp.next;
        }
        Node delNode = temp.next;
        temp.next = temp.next.next;
        delNode = null;
        return head;
    }
//    Optimal Approach
    private static Node RemoveNthNodeOptimal(int n, Node head){
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //if the fast becomes the null, the nth node from the end is head
        if (fast == null) return head.next;
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //delete the nth node from the end
        Node delNode = slow.next;
        slow.next = slow.next.next;
        delNode = null;
        return head;

    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node head = convert2Arr(arr); // Assign head correctly
        print(head);
        int n = 3;
        Node newHead = RemoveNthNodeOptimal(n, head);
        print(newHead);
    }
}

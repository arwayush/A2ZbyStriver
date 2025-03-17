package Step6.MediumLL;

public class DeleteMiddleOfLL {
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
//    the t.c. is O(N + N/2)  and s.c. is O(1)
    private static Node Brute(Node head){
        int cnt = 0;
        Node temp = head;
        while (temp != null){
            cnt++;
            temp = temp.next;
        }
        int res = cnt/2;
        temp = head;
        while (temp != null){
            res--;
            if (res == 0){
                temp.next = temp.next.next;
                break;
            }
            temp =temp.next;
        }
        return head;
    }
//    The T.C. is O(N/2) AND S.C. O(1)
    private static Node TortoiseAndHare(Node head){
        if (head == null || head.next == null) return null;
        Node slow = head, fast = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast =fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,5,8,4,6,7};
        Node head = convert2Arr(arr);
        print(head);
        Node newHead = TortoiseAndHare(head);
        print(newHead);
    }
}

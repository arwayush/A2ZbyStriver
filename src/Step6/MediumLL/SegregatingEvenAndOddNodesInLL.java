package Step6.MediumLL;
public class SegregatingEvenAndOddNodesInLL {
    private static Node head, tail;

    private static Node convert2Arr(int[] arr) {
        if (arr.length == 0) return null;
        head = new Node(arr[0]);
        tail = head;
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
    private static void InsertAtLast(int value) {
        Node newnode = new Node(value);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
    }
    private static Node SegregateOddEven() {
        Node oddHead = new Node(-1), oddTail = oddHead;
        Node evenHead = new Node(-1), evenTail = evenHead;
        Node curr = head, temp;

        while (curr != null) {
            temp = curr;
            curr = curr.next;
            temp.next = null;

            if (temp.data % 2 == 0) {
                evenTail.next = temp;
                evenTail = temp;
            } else {
                oddTail.next = temp;
                oddTail = temp;
            }
        }

        // Connecting even list to odd list
        evenTail.next = oddHead.next;
        return evenHead.next;
    }
    private static Node SegregateOddEvenBetter(){
        if (head == null || head.next == null) return head;
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;

        while (even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next.next;

        }
        odd.next = evenHead;
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        head = convert2Arr(arr); // Assign head correctly
        print(head);
        Node newHead = SegregateOddEven();
        System.out.println("LL after the segregation is: ");
        print(newHead);
    }
}

package Step6.OneDLL;
class Node {
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class DeletionOfKthElementOfLL {
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

    private static Node deletionOfKElement(Node head, int k){
        if (head == null) return null; //if no elements
        if (k == 1){    // if only one element
            Node temp = head;
            head = head.next;
            return head;
        }
        // if we want to remove the kth element
        int cnt = 0;
        Node temp = head;
        Node prev = null;
        while (temp != null){
            cnt++;
            if (cnt == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    private static Node deletionOfSpecificElement(Node head, int el){
        if (head == null) return null; //if no elements
        if (head.data == el){    // if only one element
            return head.next;
        }
        // if we want to remove the kth element
        Node temp = head;
        Node prev = null;
        while (temp != null){
            if (temp.data == el){
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {12, 4, 6, 8, 5, 34};
        Node head = convert2Arr(arr);
        print(head);
        deletionOfSpecificElement(head, 34);
        print(head);
    }
}

package Step6.OneDLL;
public class InsertionInLL {
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

    private static Node insertAtHead(Node head, int val){
        return new Node(val, head);
    }
    private static Node insertAtTail(Node head, int val){
       if (head == null) return new Node(val);
       Node temp = head;
       while (temp.next != null) {
           temp = temp.next;
       }
       Node newNode = new Node(val);
       temp.next = newNode;
       return  head;
    }
    private static Node insertAtPosition(Node head, int el, int k) {
        if (k <= 0) return head; // Invalid position

        // If inserting at the head position
        if (k == 1) {
            Node newNode = new Node(el);
            newNode.next = head;
            return newNode;
        }

        Node temp = head;
        int cnt = 1;

        // Traverse to the (k-1)th node
        while (temp != null && cnt < k - 1) {
            temp = temp.next;
            cnt++;
        }

        // If `k` is out of bounds (greater than the size + 1)
        if (temp == null) return head;

        // Insert the new node
        Node newNode = new Node(el);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }
    private static Node insertElementBeforeValue(Node head, int el, int val){
        if (head == null) return null;
        if (head.data == val) return new Node(el, head);
        Node temp = head;
        // Traverse to find `val`
        while (temp.next != null && temp.next.data != val) {
            temp = temp.next;
        }

        // If `val` is found, insert `el` before `val`
        if (temp.next != null) {
            Node newNode = new Node(el, temp.next);
            temp.next = newNode;
        }

        return head;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,6,76,4,3,6};
        Node head = convert2Arr(arr);
        print(head);
        head = insertElementBeforeValue(head, 100, 76);
        print(head);

    }
}

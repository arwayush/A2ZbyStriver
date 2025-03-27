package Step6.MediumDLL;
class Node {
    int data;
    Node prev;
    Node next;

    // Constructor
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class DeleteAllOccurencesOfAkeyInDLL {
    public static Node convertTo2DLL(int[] arr) {
        if (arr.length == 0) return null; // If empty array, return null

        Node head = new Node(arr[0]);
        Node curr = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
        }

        // Ensuring DLL starts and ends with null
        head.prev = null;
        curr.next = null;

        return head;
    }
    public static void printForward(Node head) {
        System.out.print("null <-> ");
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
//    The T.C. is O(n) and S.c. O(1)
// Function to delete all occurrences of a key in the DLL
    public static Node Deletion(Node head, int key) {
    Node temp = head;

    while (temp != null) {
        if (temp.data == key) {
            if (temp == head) {
                head = head.next;  // Move head forward
                if (head != null) head.prev = null; // Update new head's prev
            }

            Node nextNode = temp.next;
            Node prevNode = temp.prev;

            if (prevNode != null) prevNode.next = nextNode;
            if (nextNode != null) nextNode.prev = prevNode;

            temp = nextNode; // Move to the next node
        } else {
            temp = temp.next;
        }
    }
    return head;
}


    public static void main(String[] args) {
        int[] arr = {4,5,6,6,4,3,4,7,6};
        Node head = convertTo2DLL(arr);
        printForward(head);
        Node newHead = Deletion(head, 6);
        printForward(newHead);
    }
}

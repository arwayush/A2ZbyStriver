package Step6.HardDLL;

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLLInGroupOfSizeK {
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

    private static Node getKthNode(Node temp, int k) {
        while (temp != null && k > 1) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    private static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;  // Return new head of reversed portion
    }

    private static Node reversal(Node head, int k) {
        Node temp = head;
        Node prevLast = null;
        Node newHead = null;

        while (temp != null) {
            Node kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            Node nextNode = kthNode.next;
            kthNode.next = null;
            Node reversedHead = reverseLinkedList(temp);

            if (newHead == null) {
                newHead = reversedHead;  // Set the new head after the first reversal
            } else {
                prevLast.next = reversedHead;  // Connect previous group
            }

            prevLast = temp;  // Set prevLast to last node of reversed group
            temp = nextNode;
        }
        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 45, 6, 8, 54, 10};
        Node head = convert2Arr(arr);
        System.out.println("Original List:");
        print(head);

        Node newHead = reversal(head, 3);
        System.out.println("Reversed List in Groups of 3:");
        print(newHead);
    }
}

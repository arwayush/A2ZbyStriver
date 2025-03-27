package Step6.MediumDLL;

public class RemoveDuplicatesFromSortedDLL {
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
//    The T.C. is O(n)
    private static Node Removed(Node head){
        Node temp = head;
        while (temp != null && temp.next != null){
            Node nextNode = temp.next;
            while (nextNode != null && nextNode.data == temp.data){
                Node duplicate = nextNode;
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if (nextNode != null) nextNode.prev = temp;
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,3,3,4};
        Node head = convertTo2DLL(arr);
        Node newNode = Removed(head);
        printForward(newNode);

    }
}

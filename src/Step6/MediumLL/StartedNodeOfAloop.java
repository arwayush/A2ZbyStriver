package Step6.MediumLL;

public class StartedNodeOfAloop {
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

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,4};
        int pos = 4;
        Node head = convert2CyclicArr(arr, pos);
        print(head);
    }
}

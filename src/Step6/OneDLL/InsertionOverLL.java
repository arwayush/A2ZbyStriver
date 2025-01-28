package Step6.OneDLL;

public class InsertionOverLL {
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
    private static int Traversal(Node head){
        int cnt = 0;
        Node temp = head;
        while (temp != null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
    private static boolean checkPresent(Node head, int key){
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {2,45,100,78,46,5,43,2,4,67,87};
        Node head = convert2Arr(arr);
        System.out.println("The Total Number of elements are: " +Traversal(head));
        int key = 101;
        System.out.println("is the element present in the LL: " +checkPresent(head, key));

    }
}

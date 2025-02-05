package Step6.MediumLL;
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

public class MiddleNodeOfLL {
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
//   The t.c. of this app is O(n+ n/2) and S.C. is O(1)
    private static Node Brute(Node head){
        Node temp = head;
        int cnt = 0;
        while (temp != null){
            cnt++;
            temp = temp.next;
        }
        int midNode = (cnt/2) +1;
        temp = head;
        while (temp != null){
            midNode = midNode - 1;
            if (midNode == 0) break;
            temp = temp.next;
        }
        return temp;
    }
//   The tortoise and hare algo and takes the O(n/2) and S.C. is  O(1)
    private static Node TortoiseAndHareAlgo(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,46,75,100,43,345,67};
        Node head = convert2Arr(arr);
        Node ans = TortoiseAndHareAlgo(head);
        System.out.println("The Middle Node Calculated from Brute force app is: " +ans.data);
    }
}

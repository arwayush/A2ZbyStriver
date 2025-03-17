package Step6.MediumLL;

public class SortALLWith012 {
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
//    The T.C. is  O(2n), and S.C. is O(1)
    private static Node Naive(Node head){
     int cnt0 = 0, cnt1 = 0, cnt2 = 0;
     Node temp = head;
     while (temp != null){
         if (temp.data == 0) cnt0++;
         else if (temp.data == 1) cnt1++;
         else cnt2++;
         temp = temp.next;
     }
     temp = head;
     while (temp != null) {
         if (cnt0 != 0) {
             temp.data = 0;
             cnt0--;
         }
         else if (cnt1 != 0) {
             temp.data = 1;
             cnt1--;
         }else{
             temp.data = 2;
             cnt2--;
         }
         temp =temp.next;
     }
     return head;

    }

    private static Node Optimal(Node head){
        if (head == null || head.next == null) return head;
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node temp = head;

        while (temp != null){
            if (temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        zero.next = (oneHead.next != null) ? (oneHead.next) : (twoHead.next);
        one.next = twoHead.next;
        two.next = null;

        Node newHead = zeroHead.next;
        return newHead;
    }


    public static void main(String[] args) {
        int[] arr = {2,1,2,1,0,0,0,0,1,2,1,1};
        Node head = convert2Arr( arr);
        print(head);
        Node newHead = Optimal(head);
        print(newHead);

    }
}

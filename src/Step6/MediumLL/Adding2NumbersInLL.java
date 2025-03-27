package Step6.MediumLL;

import Step3.Medium.NextPermutation;

public class Adding2NumbersInLL {
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
    private static Node Add2Nums(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        Node temp1 = head1;
        Node temp2 = head2;
        int carry = 0;

        while (temp1 != null || temp2 != null) {
            int sum = carry;
            if (temp1 != null) {
                sum += temp1.data;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                sum += temp2.data;
                temp2 = temp2.next;
            }

            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
        }

        // If there's a carry left, add an extra node
        if (carry > 0) {
            curr.next = new Node(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int arr1[] = {2,4,6};
        int arr2[] = {3,8,7};
        Node head1 = convert2Arr(arr1);
        Node head2 = convert2Arr(arr2);
        Node newNode = Add2Nums(head1, head2);
        print(newNode);

    }
}

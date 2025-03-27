package Step6.MediumDLL;

import java.util.ArrayList;

public class FindPairsWithGivenSumInDLL {
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
//   The T.C. is O(n^2) and S.c. is O(1)
    public static void pairs(Node head, int sum){
        Node temp1 = head;
        ArrayList<ArrayList<Integer>> twoDArrayList = new ArrayList<>();

        while (temp1 != null) {
            Node temp2 = temp1.next;
            while (temp2 != null && temp1.data + temp2.data <= sum) {
                if (temp1.data + temp2.data == sum) {
                    ArrayList<Integer> ds = new ArrayList<>();
                    ds.add(temp1.data); // Add first element
                    ds.add(temp2.data); // Add second element
                    twoDArrayList.add(ds);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }

        System.out.println(twoDArrayList);
    }

    protected static Node findTail(Node head){
        Node tail = head;
        while (tail.next != null)
            tail = tail.next;
        return tail;

    }
//    The T.C. is O(2N) and S.c. is O(1)
    public static void OptimalPairs(Node head, int sum){
        Node left = head;
        Node right = findTail(head);  //O(N)
        ArrayList<ArrayList<Integer>> twoDPairs =  new ArrayList<>();
        while (left.data < right.data){ //O(N)
            ArrayList<Integer> ds = new ArrayList<>();
            if (left.data + right.data == sum){
                ds.add(left.data);
                ds.add(right.data);
                twoDPairs.add(ds);
                left = left.next;
                right = right.prev;
            } else if (left.data + right.data < sum) {
                left = left.next;
            }else {
                right = right.prev;
            }
        }
        System.out.println(twoDPairs);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; // for the sorted array always
        Node head = convertTo2DLL(arr);
        OptimalPairs(head, 5);
    }
}

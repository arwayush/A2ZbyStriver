package Step6.MediumLL;

public class Adding1ToLL {
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
    private static Node Reversed(Node head){
        Node temp = head;
        Node prev = null;
        while (temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return  prev;
    }

//   The overall T.C. is O(3n) and S.C. is o(1)
//    reverse -> add -> reverse again -> return
    private static Node AddingOne(Node head){
        head = Reversed(head); //O(n)
        Node temp = head;
        int carry = 1;
        while (temp != null){  //O(n)
            temp.data = temp.data + carry;
            if (temp.data < 10){
                carry = 0;
                break;
            }else{
                temp.data = 0;
                carry = 1;
            }
            //traverse to the next node
            temp = temp.next;
        }
        if (carry == 1){
            Node newNode = new Node(1);
            head = Reversed(head);
            newNode.next = head;
            return newNode;
        }
        head = Reversed(head);    // O(n)
        return head;
    }

    private static int Recursed(Node temp){
        if (temp == null)
            return 1;
        int carry = Recursed(temp.next);
        temp.data = temp.data + carry;
        if (temp.data < 10)
            return 0;
        temp.data = 0;
            return 1;
    }
    private static Node AddingOneRecursion(Node head){
        int carry = Recursed(head);
        if (carry == 1){
            Node NewNode = new Node(1);
            NewNode.next = head;
            return NewNode;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {9, 9,9};
        Node head = convert2Arr(arr);
        Node reverse = AddingOneRecursion(head);
        print(reverse);
    }
}
 /*
 I need to go backwards, because i need to go back in order to add 1
 step - 1 Reverse the LL
 put the carry as 1, as we are adding the 1
 add the carry to the 1st number of the reverse LL if the number is in the 2 digits then take the 1st number as carry
 do this untill the carry do not become 0
  */
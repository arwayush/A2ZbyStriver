package Step6.MediumLL;

import java.util.HashSet;

public class IntersectionOfYLL {
    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    static Node insertNode(Node head,int val) {
        Node newNode = new Node(val);

        if(head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;
        while(temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }
    static Node intersectionPresent(Node head1, Node head2){
        HashSet<Node> st = new HashSet<>();
        while (head1 != null){
            st.add(head1);
            head1 = head1.next;
        }
        while (head2 != null){
            if (st.contains(head2)) return head2;
            head2 = head2.next;
        }
        return null;
    }


    public static void main(String[] args) {
        Node head = null;
        head=insertNode(head,1);
        head=insertNode(head,3);
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,4);
        Node head1 = head;
        head = head.next.next.next;
        Node headSec = null;
        headSec=insertNode(headSec,3);
        Node head2 = headSec;
        headSec.next = head;
        //printing of the lists
        System.out.print("List1: "); print(head1);
        System.out.print("List2: "); print(head2);
        //checking if intersection is present
        Node answerNode = intersectionPresent(head1,head2);
        if(answerNode == null)
            System.out.println("No intersection\n");
        else
            System.out.println("The intersection point is "+answerNode.data);

    }
}

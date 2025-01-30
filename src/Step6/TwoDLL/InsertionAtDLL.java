package Step6.TwoDLL;

public class InsertionAtDLL {
    private static Node convertArr2DLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev =temp;
        }
        return  head;
    }
    private static void print(Node head){
        while (head != null){
            System.out.print(head.data+ " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
//    This is the code for the deletion of the Node
     private static Node deleteHead(Node head){
        //edge case
         if (head == null || head.next == null){
             return null;
         }
         Node prev = head;
         head = head.next;

         head.back = null;
         prev.next = null;

         return head;
     }
     private static Node deleteTail(Node head){
        //edge caes
         if (head == null || head.next == null) return  null;
         Node temp = head;
         while (temp != null || temp.next != null){
             temp = temp.next;

         }
     }
    public static void main(String[] args) {
        int[] arr = {3,4,6,89,64};
        Node head = convertArr2DLL(arr);
        head = deleteTail(head);
        print(head);
    }
}

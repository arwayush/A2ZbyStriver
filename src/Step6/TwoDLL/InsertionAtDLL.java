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
         Node tail = head;
         while (tail.next != null){
             tail = tail.next;
         }
        Node prev = tail.back;
         prev.next = null;
         tail.back = null;
         return head;
     }
     private static Node deleteKthElement(Node head, int k){
      if (head == null) return null;
      int cnt = 0;
      Node kNode = head;
      while (kNode != null){
          cnt++;
          if (cnt == k) break;
          kNode = kNode.next;
      }
      Node prev = kNode.back;
      Node front = kNode.next;

      if (prev == null && front == null) return null;
      else if (prev ==null) {
          return deleteHead(head);
      }else if (front == null){
          return deleteTail(head);
      }
      prev.next = front;
      prev.back = prev;

      kNode.next = null;
      kNode.back = null;
      return head;
     }


//     Inserting before the head
     private static Node insertBeforeHead(Node head, int val){
        Node newHead = new Node(val, head, null);
        head.back = newHead;
        return newHead;
     }
     private static Node insertBeforeTail(Node head, int val){
        if (head.next == null) return insertBeforeHead(head, val);
        Node tail = head;
        while (tail.next != null){
            tail = tail.next;
        }
        Node prev = tail.back;
        Node newNode = new Node(val, tail, prev);
        prev.next = newNode;
        tail.back = newNode;
        return head;
     }
     private static Node insertBeforeKthElement(Node head, int val, int k){
        if (k == 1) return insertBeforeHead(head, val);
        Node temp = head;
        int cnt = 0;
        while (temp!= null){
            cnt++;
            if (cnt == k)break;
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newNode = new Node(val, temp, prev);
        prev.next = newNode;
        temp.back = newNode;
        return  head;
     }
     private static void insertBeforeAGivenNode(Node node, int val){
        Node prev = node.back;
        Node newNode = new Node(val, node, prev);
        prev.next = newNode;
        node.back = newNode;
     }
    public static void main(String[] args) {
        int[] arr = {3,4,6,89,64};
        Node head = convertArr2DLL(arr);
        insertBeforeAGivenNode(head.next, 100);
        print(head);
    }
}


/*
The practical example of DLL is the Browser that we use
 */
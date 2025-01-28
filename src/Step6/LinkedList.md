Linked list is a data Structures, in which elements are stored in the heap memory
The numbers are not in the contiguous memory locations
can store string, char, int, double
Size of the LL can be increased at any moment


head of the LL is stored at m1 location and next is at m2

head -> m1 -> next -> m2 -> next -> m3 -> Tail
To put the new element el5, simply define a new element and put the tail -> next -> m5


# where the ll is used
1. It is used in Stack and Queue
2. In real life we always use in browser, open tab and search -> tuf -> a2z -> article 
and now to go back article -> a2z -> tuf -> google search



In C++
struct Node {
  public:
  int data;
  Node* next;
 
 public:
 Node(int data1, Node* next1){
  data = data1;
  next = next1
 }

  public;
  Node(int data1){
  data = data1;
  next = nullptr;
  }

}

int main(){
  vector<Int> arr = {1,2,4,6};
  Node*y = new Node(arr[0], nullptr);
  cout << y -> data;
}




In JAVA

class Node {
  int data;
  Node next;

  Node(int data1, Node next1){
    this.data = data1;
    this.next = next;
  }
  
  Node(int data1){
    this.data = data1;
    this.next = null;
  } 
}

public class LL{
  psvm(){
  int[] arr = {2,3,5,7};
  Node y = new Node(arr[0]);
  sout(y.data);
}


# Memory & Space during the storage 
- It depends on the system 
32 bit sys                               64 bit sys
- int : 4bytes                          int : 4bytes
- * pointer : 4 bytes                  *pointer : 8 bytes
Total : 8 bytes                       Total : 12bytes


# Array to LL in c++ and java


Head of the LL is the first point of the LL

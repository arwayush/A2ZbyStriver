package Step6.HardDLL;

public class CloningTheLL {
}
/*
1. Insert the copy nodes in between
2. connect random pointers
3. connect the next pointers


1. temp = head
while(temp != null){
  copyNode = new Node(temp.data);
  copyNode.next = temp.next;
  temp.next = copyNode;
  temp = temp.next.next;

 2. connecting random pointers
  temp = head;
  while(Temp != null){
  copyNode = temp.next;
  if(){
       copyNode.random = temp.random.next;
    }else{
       temp = temp.next.next;
    }
    }

3. connect the next pointers
dNode = -1;
res = dNode
temp = head;
while(temp != null){
  res.next = temp.next;
  temp.next = temp.next.next;

  res = res.next;
  temp = temp.next;
  }
  return dNode.next;
 */

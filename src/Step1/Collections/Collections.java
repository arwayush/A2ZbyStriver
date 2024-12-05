package Step1.Collections;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(23);
        list.add(45);

    }
}



/* Some comments on the topics, which we are going to learn*/
/*
JAVA Collections framework provides set of interfaces and classes to implement various data structures and algo
- These interfaces includes several methods to perform different ops and collections


Collection interface
1. List   2. set   3. queue   4. sortedSet   5. Deque
There includes the various methods that can perform different ops on the object
- int size() :- Returns the number of element in the collection
- boolean isEmpty() :- Return true if the collection contains no element
- boolean contains(Object o) :- returns true if contain the object "o"
- boolean add(E, e) :- Adds the specified element to the collection, & returns true if collection changed as a result
- boolean remove(Object o) :- removes the single instance of element from the collection, if present
- containsAll(Collection<> c) :-  returns true if collection contains all the elements of the specified collection
- boolean addAll(Collection<> c):-  adds all the elments from the specified collection to the collection
- boolean removeAll(Collection<> c) :- removes all the elements in the collection
- boolean retainAll(Collection<> c) :- removes all the elements from the collection that are not present in the specified collection
- void clear() :- removes all elements from the collecton
- Object[] toArray() :- returns an array containing all elements in the collection

       List (Interface)
       ||    implements
ArrayList                   LinkedList    Stack     Vector
- get(int index)
- set (int index)
- add(int index, E element)
- remove(int index)



 */
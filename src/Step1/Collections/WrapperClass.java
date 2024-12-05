package Step1.Collections;

import java.util.*;

public class WrapperClass {
    public static void main(String[] args) {
//        Dog<String> d1 = new Dog<>("sfasd");
//        Dog<String> d2 = new Dog<>("sdf"); //using generics we are giving here strings
//        Dog<Integer>d3 = new Dog<>(33);//using generics we are giving here integer
        Dog<String, String>d34 = new Dog<>("Ayush", "Paliwal");
        Dog<String, Integer> ddd = new Dog<>("Ayush", 56);


    }
}

class Dog<E, V>{
    E id;
    public Dog(E id, V name){
        this.id = id;

    }
}


/*
Wrapper Class -> a wrapper class in java is a class whose object wraps or contains primitive data types
- when we create an object to a wrapper class, it contains a field and in this field we can store primitive data types

char - Character
byte - Byte
short - Short
int - Integer
long - Long
float - Float
double - Double
boolean - Boolean


what is the need of wrapper classes ?
- The classes in java.util package only objects and hence wrapper classes are used
- data structures in the collection framework such as ArrayList, and Vector, store only objects not primitive types
- an object is needed to support synchronization
due to all of the above these reasons, we use the wrapper class


AUTOBOXING - automatic conversion of primitive types to object of wrapper classes
Eg:- conversion of INT -> INTEGER, long -> Long, double -> Double
Integer obj = 12 //autoboxing, used most commonly
Integer obj2 = Integer.valueOf(23);
Integer obj3 = new Integer(122);


UNBOXING - automatic converting an object of a wrapper class to its corresponding primitive type
Eg:- Conversion of Integer -> int, Long -> long, Double -> double
int age = obj (wrapper class)


GENERICS:- using generics it is possible to create classes that work with different data types.
An entity such as class, interface, or method that operates on a parameterized type is a generic entity

similar to the generic class we can also create a method that can be used with any type  of data, such as genrics method
Generics Method :- public <T> void genericMethod(T data){.....}




 */

package Step1.Collections;
import java.util.*;
public class Generic {
    public static void main(String[] args) {
        printData("Hello");
        printData(234);
    }
    static <E> void printData(E data){
        System.out.println(data);
    }

    Generic obj = new Generic();

    <E> void doubleData( E data){
        System.out.println(data);
    }
}

/*
In order to print anything we need to put the  <E> after the word static of the function

Bounded generics types
 */
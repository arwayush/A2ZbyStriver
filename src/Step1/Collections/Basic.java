package Step1.Collections;
import java.util.*;
public class Basic {
    public static void main(String[] args) {
        int[] ar = new int[5];
        try{

            System.out.println(ar[0]);

        }catch (Exception e) {
            System.out.println("outer exceptions done");
        }finally {
            System.out.println("I will always come");
        }
        System.out.println("By Guyz");
    }
}


/*
JAVA Exceptions :- it is an unexpected event that occurs during program execution.
it affects the flow of the program instructions which cause the program to terminate abruptly
Reasons for the exception
1. invalid user Input
2. device failure
3. loss of network connection
4. physical limitations (out of disk memory)
5. code errors
6. opening an unavailable file

Java Runtime exception :- happens due to programming error also known as unchecked exceptions
- these exceptions are not checked at compile time but runtime
- Null pointer exception
- ArrayOutOfBoundException
- ArithematicException


Java IOException exception :- they are checked at the compile time and the programmer is responsible to handle
 -  file not found exception
 - trying to read the past end of the line
 - also called the compile time exception



try-catch block can be used to handle the exceptions and prevents the abnormal termination of the program
- in the try block we put the code on which we have doubt that this will fail
- in the catch block we puts to which exception we are dealing with
- in the curly braces we give instructions what to do

finally - Block which will run if exception aaye yaa naa aaye
It is good practice to use the finally block to include important cleanup code like closing file or connection
There are some cases when a finally bloack does not execute:
- use of System.exit()
- an exception occurs in a finally block
- the death of a thread


Java throw and throws
we use the throws keyword in the method to declare the type of exceptions that might occur with it
eg:- public static void findFile() throws IOException{} -> This will show that the findFile function will throw the IOException


throw -> used explicitly to throw the exception
 */

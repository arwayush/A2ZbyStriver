package Step1.Collections;

import java.util.Scanner;

public class CustomException {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the age:");

        try{
            int age = sc.nextInt();
            if(age > 100){
                throw new MyException();
            }
        }catch (Exception e){
            System.out.println("Error ho gayi due to Exception");
        }
    }
}


class MyException extends Exception{

}
package Step1.patterns;

public class pattern20 {
    public static void main(String[] args) {
        int n= 5;
        int space = 2*n-2;
        for (int i = 1; i <= 2*n-1; i++) {
            int stars = i;
            if(i > n) stars = 2*n-i;

            //stars
            for (int j = 1; j <=stars; j++) {
                System.out.print("*");
            }
            //spaces
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }

            //stars
            for (int j = 1; j <=stars; j++) {
                System.out.print("*");
            }
            System.out.println();
            if(i < n) space -= 2;
            else space += 2;
        }
    }
}


/*
 *        *
 **      **
 ***    ***
 ****  ****
 ***********
 ****  ****
 ***    ***
 **      **
 *        *

 */
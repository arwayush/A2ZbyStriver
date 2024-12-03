package Step1.patterns;

public class pattern12 {
    public static void main(String[] args) {
        int n=5;
        int space = 2* (n-1);
        for (int i = 1; i <=n; i++) {
            //numbers
            for (int j = 1; j <=i; j++) {
                System.out.print(j);
            }
            //space
            for (int j = 1; j <=space; j++) {
                System.out.print(" ");
            }
            //numbers
            for (int j = i; j >=1; j--) {
                System.out.print(j);
            }
            System.out.println();
            space -= 2;
        }
    }
}
/*
1         1       1 6 1
12      21       2 4 2
123   321       3 2 3
12344321       4 0 4

outer loop will run 'n' times,
// number - space - number

 */
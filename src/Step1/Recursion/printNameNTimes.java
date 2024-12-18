package Step1.Recursion;

public class printNameNTimes {
    private static void func(int i, int n){
        if(i > n) return;  // base condition
        System.out.println("Arwayush");
        func(i+1, n);
    }
    private static void printNto1(int i, int n){
        if(i > n) return;
        System.out.println(i);
        printNto1(i+1, n);
    }
    public static void main(String[] args) {
        int n = 6;
        func(1, n);
        printNto1(1,n);
    }
}

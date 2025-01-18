package Step4.BSOnAnswers;

public class AllocateMinimumNumberOfPages {
    public static int func(int[] arr, int pages){
        int n = arr.length;
        int student = 1, pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if(pagesStudent + arr[i] <= pages){
                pagesStudent += arr[i];
            }else {
                student++;
                pagesStudent = arr[i];
            }
        }
        return student;
    }

//    The T.C. of this will be O(sum - max + 1)*n & S.C. will be O(1)
    private static int Brute(int[] arr, int m){
        int n =arr.length;
        if(m > n) return -1; //edge case
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : arr){
            maxi = Math.max(maxi,i);
            sum += i;
        }
        for (int i = maxi; i <= sum ; i++) {
            int countStudents = func(arr, i);
            if(countStudents == m){
                return i;
            }
        }
        return maxi;
    }

    private static int BS(int[] arr, int m){
        int n =arr.length;
        if(m > n) return -1; //edge case
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : arr){
            maxi = Math.max(maxi,i);
            sum += i;
        }
        int low = maxi, high = sum;
        while (low <= high){
            int mid = (low + high) / 2;
           int stud = func(arr, mid);
           if(stud > m){
               low = mid + 1;
           }else {
               high = mid - 1;
           }
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[] = {25, 46, 28, 49, 24};
        int m = 4;
        int ans = Brute(arr, m);
        System.out.println(ans);
        int ans2 = BS(arr, m);
        System.out.println(ans2);
    }
}
/*
student 1 -> 12+34+67
student 2 -> 90 i.e. minimum books received by him


25, 46, 28, 49, 24
25 | 46 | 28 | 49, 24  → Maximum no. of pages a student receive = 73
25 | 46 | 28, 49 | 24  → Maximum no. of pages a student receive = 77
25 | 46, 28 | 49 | 24  → Maximum no. of pages a student receive = 74
25, 46 | 28 | 49 | 24  → Maximum no. of pages a student receive = 71 -> minimum is the answer

-- Naive Approach --



 */
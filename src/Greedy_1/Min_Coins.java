package Greedy_1;

public class Min_Coins {

    public static int findMin(int n) {   
        int count = 0; 
        int[] denomination = {1, 2, 5, 10};       
        for (int i = denomination.length - 1; i >= 0; i--) {
            while (n >= denomination[i]) {
                n -= denomination[i];
                count++;
            }
        }
        return count; 
    }

    public static void main(String[] args) {
        int n = 39;
        System.out.println(findMin(n));
    }
}
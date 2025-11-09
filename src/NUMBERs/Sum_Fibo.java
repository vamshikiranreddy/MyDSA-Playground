package NUMBERs;
import java.util.*;
public class Sum_Fibo {
	public static int fibonacci(int N) {
		if(N<=1) return N;
		return fibonacci(N-1)+fibonacci(N-2); 
	}
	/*
	 * for series
	public static int Print(int start,int end){
	     int fib ;
	     int  i=0;
	     while((fib= fibonacci(i))<=end){
	        if(fib>=start){
	        Sysout(fib+" ");
	     }
	}
	*/ 
	public static int Sum(int N) {
		if(N == 0) return 1;
		int sum = 0;
		int fib;
		System.out.println("The Fibonacci Numbers In The Series ");
		for(int i =0;i<N;i++) {
			fib = fibonacci(i);
			System.out.print(fib +" ");
			sum += fib;
		}
		System.out.println();
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("Enter The Number");
		int N = in.nextInt();
		int sum = Sum(N);
		System.out.println("The Sum " + sum);
		in.close();
	}

}

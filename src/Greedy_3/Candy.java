package Greedy_3;

public class Candy {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(minCandy(arr));
	}

	private static int minCandy(int[] ratings) {
		int n = ratings.length;
		int sum = 1;
		int i = 1;
		while(i < n) {
			if(ratings[i] == ratings[i-1]) {
				sum++;
				i++;
				continue;
			}
			int peak = 1;
			while(i < n && ratings[i] > ratings[i-1]) {
				peak++;
				sum += peak;
				i++;
			}
			int down = 1;
			while(i < n && ratings[i] < ratings[i-1]) {
				sum += down;
				down++;
				i++;
			}
			if(down > peak) sum += (down - peak);
		}
		return sum;
	}

}

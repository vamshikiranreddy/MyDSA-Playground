package Greedy_1;

import java.util.*;

public class Fractional_KnapSack {
	static class Item {
		int value;
		int weight;

		Item(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}
	}

	public static  void main(String[] args) {
		int[] val = { 60, 100, 120 };
		int[] wt = { 10, 20, 30 };
		int capacity = 50;
		double MaxValue = fractionalKnapsack(val, wt, capacity);
		System.out.println("The Max Value Is "+MaxValue);
	}

	private static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
		Item array[] = new Item[wt.length];
		for (int i = 0; i < wt.length; i++) {
			array[i] = new Item(val[i], wt[i]);
		}
		Arrays.sort(array, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
		int currWeight = 0;
		int totalValue = 0;
		for (int i = 0; i < array.length; i++) {
			if (currWeight + array[i].weight <= capacity) {
				totalValue += array[i].value;
				currWeight += array[i].weight;
			} else {
				int remaingWeight = capacity - currWeight;
				totalValue += (double) array[i].value / array[i].weight * remaingWeight;
				break;
			}
		}
		return totalValue;
	}

}

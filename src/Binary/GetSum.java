package Binary;

public class GetSum {
	public static void main(String[] args) {
		int a = 5;
		int b = 7;

		int sum = getSumNegetive(a, b);
		System.out.println("Sum using XOR = " + sum);
		int result = getSum(a, b);
		System.out.println("Sum by Conversion = " + result);
	}

	private static int getSum(int a, int b) {
		String binaryA = Integer.toBinaryString(a);
		String binaryB = Integer.toBinaryString(b);

		int i = binaryA.length() - 1;
		int j = binaryB.length() - 1;
		int carry = 0;

		StringBuilder sb = new StringBuilder();

		while (i >= 0 || j >= 0 || carry == 1) {
			int sum = carry;

			if (i >= 0) {
				sum += binaryA.charAt(i--) - '0';
			}

			if (j >= 0) {
				sum += binaryB.charAt(j--) - '0';
			}

			sb.append(sum % 2);
			carry = sum / 2;
		}

		String res = sb.reverse().toString();

		return Integer.parseInt(res, 2);
	}

	private static int getSumNegetive(int a, int b) {
		while (b != 0) {
			int carry = (a & b) << 1;
			a = a ^ b;
			b = carry;
		}
		return a;
	}

}

package Pattren;

public class AllPatterns {

    public static void main(String[] args) {
        int n = 5;
        rightAngledTriangle(n);
        invertedRightAngledTriangle(n);
        pyramidPattern(n);
        diamondPattern(n);
        numberTriangle(n);
        floydsTriangle(n);
        alphabetTriangle(n);
        pascalsTriangle(n);
        butterflyPattern(n);
        hollowPyramid(n);
        Hollow_Square(n);
    }

    static void rightAngledTriangle(int n) {
        System.out.println("Right-Angled Triangle:");
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void invertedRightAngledTriangle(int n) {
        System.out.println("\nInverted Right-Angled Triangle:");
        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pyramidPattern(int n) {
        System.out.println("\nPyramid Pattern:");
        for(int i = 1; i <= n; i++) {
            for(int space = 1; space <= n - i; space++) System.out.print("  ");
            for(int star = 1; star <= 2 * i - 1; star++) System.out.print("* ");
            System.out.println();
        }
    }

    static void diamondPattern(int n) {
        System.out.println("\nDiamond Pattern:");
        for(int i = 1; i <= n; i++) {
            for(int j = i; j < n; j++) System.out.print(" ");
            for(int j = 1; j <= 2*i-1; j++) System.out.print("*");
            System.out.println();
        }
        for(int i = n-1; i >= 1; i--) {
            for(int j = n; j > i; j--) System.out.print(" ");
            for(int j = 1; j <= 2*i-1; j++) System.out.print("*");
            System.out.println();
        }
    }

    static void numberTriangle(int n) {
        System.out.println("\nNumber Triangle:");
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void floydsTriangle(int n) {
        System.out.println("\nFloyd's Triangle:");
        int num = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }

    static void alphabetTriangle(int n) {
        System.out.println("\nAlphabet Triangle:");
        for(int i = 1; i <= n; i++) {
            char ch = 'A';
            for(int j = 1; j <= i; j++) {
                System.out.print(ch++ + " ");
            }
            System.out.println();
        }
    }

    static void pascalsTriangle(int n) {
        System.out.println("\nPascal's Triangle:");
        for(int i = 0; i < n; i++) {
            int number = 1;
            System.out.printf("%" + (n - i) * 2 + "s", "");
            for(int j = 0; j <= i; j++) {
                System.out.printf("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    static void butterflyPattern(int n) {
        System.out.println("\nButterfly Pattern:");
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) System.out.print("*");
            for(int j = 1; j <= 2*(n-i); j++) System.out.print(" ");
            for(int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= i; j++) System.out.print("*");
            for(int j = 1; j <= 2*(n-i); j++) System.out.print(" ");
            for(int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }

    static void hollowPyramid(int n) {
        System.out.println("\nHollow Pyramid:");
        
        for(int i = 1; i <= n; i++) {
            for(int j = i; j < n; j++) System.out.print(" ");
            for(int j = 1; j <= 2*i-1; j++) {
                if(j == 1 || j == 2*i-1 || i == n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    static void Hollow_Square(int n) {
    	System.out.println("Hollow Square");
    	for(int i = 1;i<=n;i++) {
    		for(int j = 1;j<=n;j++) {
    			if(i == 1 || i == n || j == 1 || j == n) {
    				System.out.print("* ");
    			}else {
    				System.out.print("  ");
    			}
    		}
    		System.out.println();
    	}
    }
}


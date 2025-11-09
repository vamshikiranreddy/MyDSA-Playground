package Greedy_1;

public class Lemonade_Change {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else { // bill == 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    // Driver code
    public static void main(String[] args) {
        Lemonade_Change sol = new Lemonade_Change();
        int[] bills1 = {5, 5, 5, 10, 20};
        int[] bills2 = {5, 5, 10, 10, 20};

        System.out.println(sol.lemonadeChange(bills1)); // true
        System.out.println(sol.lemonadeChange(bills2)); // false
    }
}

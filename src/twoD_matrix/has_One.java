package twoD_matrix;
import java.util.*;
class Has_one{
    public static int Parking(int [][] matrix){
        int max_count = 0;
        int max_index = -1;
        boolean hasOne = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0;i<m;i++){
            int count = 0;
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == 1) {
                    count++;
                    hasOne = true;
                }
                if(count>max_count){
                    max_count = count;
                    max_index = i;
                }
                
            }
        }
        return hasOne ? max_index+1 : max_index;
    }
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int C = in.nextInt();
        int matrix [][] = new int [R][C];
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                matrix [i][j] = in.nextInt();
            }
        }
        int max = Parking(matrix);
        System.out.println(max);
        in.close();
        
    }
}

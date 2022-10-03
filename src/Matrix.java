import java.util.Scanner;

public class Matrix {
    public static int[][] multiplication(int[][] arr1, int[][] arr2){

        if (arr1[0].length != arr2.length){
            System.out.println("Invalid number of entered rows or columns");
            return new int[1][1];
        }

        int[][] ans = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < ans.length; i++){
            for (int z = 0; z < ans[0].length; z++){
                for (int k = 0; k < arr1[0].length; k++){
                    ans[i][z] += arr1[i][k] * arr2[k][z];
                }
            }
        }
        return ans;
    }

    public static int[][] enterArray(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of matrix rows");
        int rows = input.nextInt();

        System.out.println("Enter the number of matrix columns");
        int columns = input.nextInt();

        if (rows < 1 || columns < 1){
            System.out.println("Invalid input data");
            System.exit(0);
        }

        System.out.println("Enter values separated by spaces, separating lines with an enter");
        int[][] array = new int[rows][columns];
        input.nextLine();
        String[] str = new String[rows];
        for (int i = 0; i < rows; i++){
            str[i] = input.nextLine();
        }

        for (int i = 0; i < rows; i++){
            if (str[i].split(" ").length != columns){
                System.out.println("Invalid input data");
                System.exit(0);
            }
        }

        for (int i = 0; i < rows; i++){
            for (int z = 0; z < columns; z++){
                array[i][z] = Integer.parseInt(str[i].split(" ")[z]);
            }
        }
        return array;
    }

    public static void main(String[] args) {

        int[][] first = enterArray();
        int[][] second = enterArray();

        int[][] ans = multiplication(first,second);

        System.out.println("Multiplication result:");
        for (int[] arr : ans){
            for (int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

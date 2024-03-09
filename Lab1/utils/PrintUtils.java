package utils;

public class PrintUtils {
    public static void printMatrix(String name, double[][] matrix) {
        synchronized (System.in) {
            System.out.println(name);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void printVector(String name, double[] vector) {
        synchronized (System.in) {
            System.out.println(name);
            for (int i = 0; i < vector.length; i++) {
                System.out.print(vector[i] + " ");
            }
            System.out.println();
        }
    }
}

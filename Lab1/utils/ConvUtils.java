package utils;

public class ConvUtils {
    public static String matrixToStr(double[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    sb.append(" ");
                }
            }
            if (i < matrix.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String vectorToStr(double[] vector) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vector.length; i++) {
            sb.append(vector[i]);
            if (i < vector.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static double[][] strToMatrix(String str, int n) {
        String[] numbers = str.split(" ");
        double[][] matrix = new double[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = Double.parseDouble(numbers[j + (i * n)]);
            }
        }
        return matrix;
    }

    public static double[] strToVector(String str, int n) {
        String[] numbers = str.split(" ");
        double[] vector = new double[n];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = Double.parseDouble(numbers[i]);
        }
        return vector;
    }
}

package utils;

import java.util.Arrays;
import java.util.Random;

public class MathUtils {
    public static double[][] matrix(int n) {
        double[][] matrix = new double[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextDouble() * 9 + 1;
            }
        }
        return matrix;
    }

    public static double[] vector(int n) {
        double[] vector = new double[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            vector[i] = random.nextDouble() * 9 + 1;
        }
        return vector;
    }

    public static double[][] multiplyMatrixByMatrix(double[][] m1, double[][] m2) {
        int x = m1.length;
        int y = m2[0].length;
        double[][] res = new double[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    public static double[] multiplyVectorByMatrix(double[] v, double[][] m) {
        int x = v.length;
        int y = m[0].length;
        double[] res = new double[y];
        for (int i = 0; i < y; i++) {
            int sum = 0;
            for (int j = 0; j < x; j++) {
                sum += v[j] * m[j][i];
            }
            res[i] = sum;
        }
        return res;
    }

    public static double[][] addMatrices(double[][] m1, double[][] m2) {
        int x = m1.length;
        int y = m2[0].length;
        double[][] res = new double[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                res[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return res;
    }

    public static double[][] substractMatrices(double[][] m1, double[][] m2) {
        int x = m1.length;
        int y = m2[0].length;
        double[][] res = new double[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                res[i][j] = m1[i][j] - m2[i][j];
            }
        }
        return res;
    }

    public static double[] addVectors(double[] v1, double[] v2) {
        int x = v1.length;
        double[] res = new double[x];
        for (int i = 0; i < x; i++) {
            res[i] = v1[i] + v2[i];
        }
        return res;
    }

    public static double[] sortVector(double[] v) {
        Arrays.sort(v);
        return v;
    }

    public static double[][] partialMatrixMultiplication(double[][] m1, double[][] m2, int start, int end) {
        int x = m1.length;
        double[][] res = new double[x][end - start];
        for (int i = 0; i < x; i++) {
            for (int j = start; j < end; j++) {
                for (int k = 0; k < x; k++) {
                    res[i][j-start] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    public static double[][] partialMatrixSubstraction(double[][] m1, double[][] m2, int start, int end) {
        int x = m1.length;
        double[][] res = new double[x][end - start];
        for (int i = 0; i < x; i++) {
            for (int j = start; j < end; j++) {
                res[i][j-start] = m1[i][j] - m2[i][j];
            }
        }
        return res;
    }

    public static double[] partialVectorMultiplication(double[] v, double[][] m, int start, int end) {
        int x = v.length;
        double[] res = new double[end - start];
        for (int i = start; i < end; i++) {
            int sum = 0;
            for (int j = 0; j < x; j++) {
                sum += v[j] * m[j][i];
            }
            res[i-start] = sum;
        }
        return res;
    }
}

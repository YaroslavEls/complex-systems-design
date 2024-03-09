package v1;

import utils.ConvUtils;
import utils.MathUtils;

public class Data {
    static int N = 6;
    static int H = N / 2;

    static double[][] MB;
    static double[][] MO;
    static double[][] MS;
    static double[][] MG;

    static double[] O;
    static double[] B;
    static double[] S;

    public static String[] structFromScratch() {
        MB = MathUtils.matrix(N);
        MO = MathUtils.matrix(N);
        MS = MathUtils.matrix(N);
        O = MathUtils.vector(N);
        B = MathUtils.vector(N);

        String strMB = ConvUtils.matrixToStr(Data.MB);
        String strMO = ConvUtils.matrixToStr(Data.MO);
        String strMS = ConvUtils.matrixToStr(Data.MS);
        String strO = ConvUtils.vectorToStr(Data.O);
        String strB = ConvUtils.vectorToStr(Data.B);

        String[] strData = {strMB, strMO, strMS, strO, strB};
        return strData;
    }

    public static void structFromInput(String input) {
        String[] data = input.split("\n");
        MB = ConvUtils.strToMatrix(data[0], N);
        MO = ConvUtils.strToMatrix(data[1], N);
        MS = ConvUtils.strToMatrix(data[2], N);
        O = ConvUtils.strToVector(data[3], N);
        B = ConvUtils.strToVector(data[4], N);
    }
}

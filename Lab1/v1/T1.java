package v1;

import java.io.IOException;

import utils.ConvUtils;
import utils.FileUtils;
import utils.MathUtils;
import utils.PrintUtils;

public class T1 extends Thread {
    public void run() {
        double[][] tmp1 = MathUtils.multiplyMatrixByMatrix(Data.MB, Data.MO);
        double[][] tmp2 = MathUtils.substractMatrices(Data.MB, Data.MO);
        double[][] tmp3 = MathUtils.multiplyMatrixByMatrix(Data.MS, tmp2);
        Data.MG = MathUtils.addMatrices(tmp1, tmp3);

        String MGstr = ConvUtils.matrixToStr(Data.MG);
        try {
            FileUtils.writeOutputFile(MGstr, "output/Matrix_MG_v1");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintUtils.printMatrix("Matrix MG (v1):", Data.MG);
    }
}

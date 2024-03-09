package v1;

import java.io.IOException;

import utils.ConvUtils;
import utils.FileUtils;
import utils.MathUtils;
import utils.PrintUtils;

public class T2 extends Thread {
    public void run() {
        double[] tmp1 = MathUtils.multiplyVectorByMatrix(Data.O, Data.MO);
        double[] tmp2 = MathUtils.multiplyVectorByMatrix(Data.B, Data.MB);
        double[] tmp3 = MathUtils.addVectors(tmp1, tmp2);
        Data.S = MathUtils.sortVector(tmp3);

        String Sstr = ConvUtils.vectorToStr(Data.S);
        try {
            FileUtils.writeOutputFile(Sstr, "output/Vector_S_v1");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintUtils.printVector("Vector S (v1):", Data.S);
    }
}

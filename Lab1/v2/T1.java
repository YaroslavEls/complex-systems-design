package v2;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

import utils.ConvUtils;
import utils.FileUtils;
import utils.MathUtils;
import utils.PrintUtils;

public class T1 extends Thread {
    private final Lock lock1;
    private final Lock lock2;
    private final CountDownLatch latch;

    public T1(Lock lock1, Lock lock2, CountDownLatch latch) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.latch = latch;
    }

    public void run() {
        double[][] tmp1 = MathUtils.partialMatrixMultiply(Data.MB, Data.MO, 0, Data.H);
        double[][] tmp2 = MathUtils.partialMatrixSubstract(Data.MB, Data.MO, 0, Data.H);
        double[][] tmp3 = MathUtils.multiplyMatrixByMatrix(Data.MS, tmp2);
        double[][] MGh = MathUtils.addMatrices(tmp1, tmp3);

        lock1.lock();
        try {
            for (int i = 0; i < Data.N; i++) {
                for (int j = 0; j < Data.H; j++) {
                    Data.MG[i][j] = MGh[i][j];
                }
            } 
        } finally {
            lock1.unlock();
        }

        double[] tmp4 = MathUtils.partialVectorMultiply(Data.O, Data. MO, 0, Data.H);
        double[] tmp5 = MathUtils.partialVectorMultiply(Data.B, Data. MB, 0, Data.H);
        double[] Sh = MathUtils.addVectors(tmp4, tmp5);

        lock2.lock();
        try {
            for (int i = 0; i < Data.H; i++) {
                Data.S[i] = Sh[i];
            } 
        } finally {
            lock2.unlock();
        }

        latch.countDown();

        String MGstr = ConvUtils.matrixToStr(Data.MG);
        try {
            FileUtils.writeOutputFile(MGstr, "output/Matrix_MG_v2");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintUtils.printMatrix("Matrix MG (v2):", Data.MG);
    }
}

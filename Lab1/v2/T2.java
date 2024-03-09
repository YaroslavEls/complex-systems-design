package v2;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

import utils.ConvUtils;
import utils.FileUtils;
import utils.MathUtils;
import utils.PrintUtils;

public class T2 extends Thread {
    private final Lock lock1;
    private final Lock lock2;
    private final CountDownLatch latch;

    public T2(Lock lock1, Lock lock2, CountDownLatch latch) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.latch = latch;
    }

    public void run() {
        double[][] tmp1 = MathUtils.partialMatrixMultiply(Data.MB, Data.MO, Data.H, Data.N);
        double[][] tmp2 = MathUtils.partialMatrixSubstract(Data.MB, Data.MO, Data.H, Data.N);
        double[][] tmp3 = MathUtils.multiplyMatrixByMatrix(Data.MS, tmp2);
        double[][] MGh = MathUtils.addMatrices(tmp1, tmp3);

        lock1.lock();
        try {
            for (int i = 0; i < Data.N; i++) {
                for (int j = Data.H; j < Data.N; j++) {
                    Data.MG[i][j] = MGh[i][j-Data.H];
                }
            } 
        } finally {
            lock1.unlock();
        }

        double[] tmp4 = MathUtils.partialVectorMultiply(Data.O, Data. MO, Data.H, Data.N);
        double[] tmp5 = MathUtils.partialVectorMultiply(Data.B, Data. MB, Data.H, Data.N);
        double[] Sh = MathUtils.addVectors(tmp4, tmp5);

        lock2.lock();
        try {
            for (int i = Data.H; i < Data.N; i++) {
                Data.S[i] = Sh[i-Data.H];
            } 
        } finally {
            lock2.unlock();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Data.S = MathUtils.sortVector(Data.S);

        String Sstr = ConvUtils.vectorToStr(Data.S);
        try {
            FileUtils.writeOutputFile(Sstr, "output/Vector_S_v2");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintUtils.printVector("Vector S (v2):", Data.S);
    }
}

package v2;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import utils.FileUtils;

public class Lab1 {
    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException, IOException {
        if (!FileUtils.file.exists()) {
            String[] strData = Data.structFromScratch();
            FileUtils.writeInputFile(strData);
        } else {
            String strInput = FileUtils.readInputFile();
            Data.structFromInput(strInput);
        }

        Thread thread1 = new T1(lock1, lock2, latch);
        Thread thread2 = new T2(lock1, lock2, latch);
        
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

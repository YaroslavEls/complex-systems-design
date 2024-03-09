package v1;

import java.io.IOException;

import utils.FileUtils;

public class Lab1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (!FileUtils.file.exists()) {
            String[] strData = Data.structFromScratch();
            FileUtils.writeInputFile(strData);
        } else {
            String strInput = FileUtils.readInputFile();
            Data.structFromInput(strInput);
        }

        Thread thread1 = new T1();
        Thread thread2 = new T2();
        
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

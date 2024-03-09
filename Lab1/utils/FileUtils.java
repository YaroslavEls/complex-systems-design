package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    public static String filePath = "input";
    public static File file = new File(filePath);

    public static void writeInputFile(String[] data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (int i = 0; i < data.length; i++) {
            writer.write(data[i]);
            if (i < data.length - 1) {
                writer.write("\n");
            }
        }
        writer.close();
    }

    public static void writeOutputFile(String output, String file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(output);
        writer.close();
    }

    public static String readInputFile() {
        String result = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result += line + "\n";
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }
}

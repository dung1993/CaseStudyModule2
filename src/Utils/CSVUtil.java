package src.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    public static <T> void write(String path, List<T> items){
        try {
            PrintWriter printWriter =new PrintWriter(path);
            for (T item: items) {
                printWriter.println(item.toString());
            }
            printWriter.flush();
            printWriter.close();
        }catch (FileNotFoundException e){
            throw new IllegalArgumentException(path + "no data.");

        }
    }

    public static List<String> read(String path) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine())!= null && !line.trim().isEmpty()){
                lines.add(line);
            }
        }catch (FileNotFoundException e){
            System.out.println(path + " No data");
        }catch (IOException e){
            System.out.println(path + " No data");
        }
        return lines;
    }
}

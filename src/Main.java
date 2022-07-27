import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = "";

        File[] files = listFiles("Resources");
        for (File file: files) {
            System.out.println(file.getName());
        }

        if(line == ""){
            return;
        }

        while (true) {
            System.out.println("Please input a message:");
            try {
                if ((line = reader.readLine()) == null){
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (line.equalsIgnoreCase("exit")) {
                System.out.println("bye bye!");
                return;
            } writing(line);
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static File[] listFiles(String dirName){
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dira, String name) {
                //return dir.isFile();
               return  new File(dira+"/"+name).isFile();
              //  System.out.println(dira.getName() + name);
               // return true;
            }
        });
    }

    public static File[] finder(String dirName, String search){
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String filename) {
                dir.isFile();
                return filename.endsWith(search) || filename.startsWith(search);
            }
        });
    }



    public static void writing(String directory){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("Resources_by_input/test.txt"));

            File [] fileName = finder(directory, "");

            for (File file : fileName) {
                writer.write((file.getName().concat("\n")));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        finally {
           assert writer != null;
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
}
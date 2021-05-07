import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class ListOfFiles {
    public static void main(String args[]) throws IOException {
        File directoryPath = new File("");
        File filesList[] = directoryPath.listFiles();
        System.out.println("List of files and directories in the specified directory:");
        Scanner sc = null;
        for(File file : filesList) {
            System.out.println("File name: "+file.getName());
            System.out.println("File path: "+file.getAbsolutePath());
            sc= new Scanner(file);
            String input;
            StringBuffer sb = new StringBuffer();
            while (sc.hasNextLine()) {
                input = sc.nextLine();
                sb.append(input+" ");
            }
            System.out.println("Contents of the file: "+sb.toString());
            System.out.println(" ");
        }
    }
}
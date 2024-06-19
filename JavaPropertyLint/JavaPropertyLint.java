import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * JavaPropertyLint
 * 
 * This Java CLI application takes a file path as an argument and attempts to load the file 
 * using java.util.Properties. If the file is a valid Java properties file, the application 
 * exits with status code 0. Otherwise, it prints the first error it finds to standard output
 * and exits with status code 1.
 * 
 * Usage:
 * java -jar JavaPropertyLint.jar <properties-file>
 *
 */
public class JavaPropertyLint {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java JavaPropertyLint <properties-file>");
            System.exit(1);
        }

        String filePath = args[0];
        Properties properties = new Properties();

        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            properties.load(inputStream);
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error loading properties file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}

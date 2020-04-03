package reader;

import java.io.InputStream;
import java.util.Scanner;

public class InfoReader {
    public String readString(InputStream input){
        Scanner scanner = new Scanner(input);
        String line = scanner.nextLine();
        line = line.trim();
        return line;
    }
}

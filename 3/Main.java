import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("matches2.txt");
        Scanner leser = new Scanner(file);
        String linje;
        String[] temp = new String[2];
        int sum = 0;

        while (leser.hasNextLine()) {
            linje = leser.nextLine();
            temp = linje.split(",");
            sum += Integer.parseInt(temp[0]) * Integer.parseInt(temp[1]);
        }

        System.out.println(sum);
    }
}
            
        
        
        

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
        int sum2 = 0;
        while (leser.hasNextLine()) {
            linje = leser.nextLine();
            temp = linje.split(",");
            sum += Integer.parseInt(temp[0]) * Integer.parseInt(temp[1]);
        }

        System.out.println("Sum1: " + sum);

        File file2 = new File("matches3.txt");
        Scanner leser2 = new Scanner(file2);
        linje = "";
        boolean mul = true;

        while (leser2.hasNextLine()) {
            linje = leser2.nextLine();
            if (linje.equals("don't")) {
                mul = false;
            } else if (linje.equals("do")) {
                mul = true;
            } else {
                if (mul) {
                    temp = linje.split(",");
                    sum2 += Integer.parseInt(temp[0]) * Integer.parseInt(temp[1]);
                }
            }
        }

        System.out.println("sum2: " + sum2);
    }
}
            
        
        
        

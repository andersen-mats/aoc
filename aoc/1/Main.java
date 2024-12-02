import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("data.txt");
        Scanner leser = new Scanner(file);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        int i = 0;
        while (leser.hasNextLine()) {
            String data = leser.nextLine();
            String[] temp = new String[2];
            temp = data.split("   ");
            left.add(i, Integer.valueOf(temp[0]));
            right.add(i, Integer.valueOf(temp[1]));
            i++;
        }
        
        Collections.sort(left);
        Collections.sort(right);

        int sum = 0;
        for (int n = 0; n < left.size(); n++) {
            sum += Math.abs(left.get(n) - right.get(n));
        }

        System.out.println(sum);
    }
}

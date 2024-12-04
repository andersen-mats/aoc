import java.util.HashMap;
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

        Scanner leser2 = new Scanner(file);
        ArrayList<Integer> left2 = new ArrayList<>();
        HashMap<Integer, Integer> ordbok = new HashMap<>();
        int sum2 = 0;

        while(leser2.hasNextLine()) {
            String[] temp2 = leser2.nextLine().split("   ");
            int r = Integer.parseInt(temp2[1]);
            left2.add(Integer.parseInt(temp2[0]));
            if (ordbok.containsKey(r)) {
                int temp3 = ordbok.get(r);
                temp3++;
                ordbok.put(r, temp3);
            } else {
                ordbok.put(r, 1);
            }
        }

        for (int n : left2) {
            if (ordbok.containsKey(n)) {
                sum2 += n * ordbok.get(n);
            }
        }

        System.out.println(sum2);
    }
}

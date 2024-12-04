import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("data.txt");
        Scanner leser = new Scanner(file);
        int[][] lines = new int[1000][];
        String[] temp;
        int l = 0;
        int tot = 0;

        while (leser.hasNextLine()) {
            temp = leser.nextLine().split(" ");
            int[] temp2 = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                temp2[i] = Integer.parseInt(temp[i]);
                lines[l] = temp2;
            }
            l++;
        }

        for (int i = 0; i < lines.length; i++) {
            if (Safe.check(lines[i])) {
                tot++;
            }
        }
        System.out.println("First half: " + tot);

        tot = 0;

        for (int i = 0; i < lines.length; i++) {
            if (Safe.check(lines[i])) {
                tot++;
            } else {
                for (int k = 0; k < lines[i].length; k++) {
                    ArrayList<Integer> templ = new ArrayList<>();
                    int[] tempa = new int[lines[i].length - 1];
                    for (int j = 0; j < lines[i].length; j++) {
                        if (j==k) {
                            continue;
                        }
                        templ.add(lines[i][j]);
                    }

                    for (int n = 0; n < templ.size(); n++) {
                        tempa[n] = templ.get(n);
                    }

                    if (Safe.check(tempa)) {
                        tot++;
                        break;
                    }
                }
            }
        }
        System.out.println("Second half: " + tot);
    }
}
                                            

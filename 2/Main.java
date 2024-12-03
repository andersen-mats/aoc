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
            int n = 0;
            int m = 1;

            if (lines[i][n] < lines[i][m]) {
                while (lines[i][n] < lines[i][m] && (1 <= (lines[i][m] - lines[i][n]) && 3 >= (lines[i][m] - lines[i][n]))) {
                    if (m == lines[i].length - 1) {
                        tot++;
                        break;
                    }
                    n++;
                    m++;
                }

            } else if (lines[i][n] > lines[i][m]) {
                while (lines[i][n] > lines[i][m] && ((1 <= lines[i][n] - lines[i][m]) && 3 >= (lines[i][n] - lines[i][m]))) {
                    if (m == lines[i].length - 1) {
                        tot++;
                        break;
                    }
                    n++;
                    m++;
                }
            }
        }
        System.out.println(tot);
    }
}
                                            

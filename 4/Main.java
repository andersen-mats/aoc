import java.io.File;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("data.txt");
        Scanner scanner = new Scanner(file);
        String line;
        char[][] grid = new char[140][];
        char[] word = {'X', 'M', 'A', 'S'};
        int tot = 0;
        
        int l = 0;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            line = line.replace("\n", "").replace("\r", "");
            int length = 0;
            for (int i = 0; i < line.length(); i++) {
                length++;
            }

            char[] temp = new char[length];
            for (int i = 0; i < line.length(); i++) {
                temp[i] = line.charAt(i);
            }

            grid[l] = temp;
            l++;
        }

        // left to right horizontally
        for (char[] y : grid) {
            int i = 0;
            for (char x : y) {
                if (x == word[i]) {
                    i++;
                    if (i == 4) {
                        i = 0;
                        tot++;
                    }
                } else {
                    i = 0;
                }
            }
        }

        // right to left horizontally
        for (char[] y : grid) {
            int i = 0;
            for (int j = y.length - 1; j > 0; j--) {
                if (y[j] == word[i]) {
                    i++;
                    if (i == 4) {
                        i = 0;
                        tot ++;
                    }
                } else {
                    i = 0;
                }
            }
        }

        // downwards
        for (int n = 0; n < grid[0].length; n++) {
            int i = 0;
            for (int m = 0; m < grid.length; m++) {
                if (grid[n][m] == word[i]) {
                    i++;
                    if (i == 4) {
                        i = 0;
                        tot++;
                    }
                } else {
                    i = 0;
                }
            }
        }
        
        // upwards
        for (int n = 0; n < grid[0].length; n++) {
            int i = 0;
            for (int m = grid.length - 1; m > 0; m--) {
                if (grid[n][m] == word[i]) {
                    i++;
                    if (i == 4) {
                        i = 0;
                        tot++;
                    }
                } else {
                    i = 0;
                }
            }
        }

        // diag down from left to rigth
        int i = 0;
        int x = 0;
        while (x < grid.length) {
            for (int y = 0; y < grid.length; y = y + 1 + x) {
                if (grid[y][y] == word[i]) {
                    i++;
                    if (i == 4) {
                        i = 0;
                        tot++;
                    }
                } else {
                    i = 0;
                }
            }
            x++;
        }

        // diag down from right to left
        i = 0;
        x = 0;
        while (x < grid.length) {
            for (int y = grid.length - 1; y > 0; y = y - 1 - x) {
                if (grid[y][y] == word[i]) {
                    i++;
                    if (i == 4) {
                        i = 0;
                        tot++;
                    }
                } else {
                    i = 0;
                }
            }
            x++;
        }

        // diag up from left to right
        i = 0;
        x = 0;
        while (x < grid.length) {
            for (int y = 0; y < grid.length; y = y + 1 + x) {
                if (grid[139 - y][y] == word[i]) {
                    i++;
                    if (i == 4) {
                        i = 0;
                        tot++;
                    }
                } else {
                    i = 0;
                }
            }
            x++;
        }


        // diag up from right to left
        i = 0;
        x = 0;
        while (x < grid.length) {
            for (int y = 0; y > 0; y = y - 1 - x) {
                if (grid[139 - y][y] == word[i]) {
                    i++;
                    if (i == 4) {
                        i = 0;
                        tot++;
                    }
                } else {
                    i = 0;
                }
            }
            x++;
        }
        
        System.out.println(tot);
    }
}

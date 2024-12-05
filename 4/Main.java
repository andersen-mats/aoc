import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("data.txt");
        Scanner scanner = new Scanner(file);
        char[] word = {'X', 'M', 'A', 'S'};
        int tot = 0;

        ArrayList<char[]> tmpArrayList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            tmpArrayList.add(scanner.nextLine().toCharArray());
        }
        scanner.close();

        int rows = tmpArrayList.size();
        int cols = tmpArrayList.get(0).length;
        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            grid[i] = tmpArrayList.get(i);
        }

        tot += searchHor(grid, word);
        tot += searchHor(reverse(grid), word);
        tot += searchVert(grid, word);
        tot += searchVert(flip(grid), word);
        tot += searchDiagRight(grid, word);
        tot += searchDiagLeft(grid, word);
        tot += searchDiagRight(reverse(flip(grid)), word);
        tot += searchDiagLeft(reverse(flip(grid)), word);

        System.out.println(tot);
    }

    static char[][] reverse(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        char[][] ret = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ret[i][j] = grid[i][cols - j - 1];
            }
        }
        return ret;
    }

    static char[][] flip(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        char[][] ret = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            ret[i] = grid[rows - i - 1];
        }
        return ret;
    }

    static int searchDiagRight(char[][] grid, char[] word) {
        int rows = grid.length;
        int cols = grid[0].length;
        int wordLength = word.length;
        int count = 0;

        for (int col = 0; col <= cols - wordLength; col++) {
            int match = 0;
            for (int i = 0; i < Math.min(rows, cols - col); i++) {
                if (grid[i][col + i] == word[match]) {
                    match++;
                    if (match == wordLength) {
                        count++;
                        match = 0;
                    }
                } else {
                    match = 0;
                }
            }
        }

        for (int row = 1; row <= rows - wordLength; row++) {
            int match = 0;
            for (int i = 0; i < Math.min(rows - row, cols); i++) {
                if (grid[row + i][i] == word[match]) {
                    match++;
                    if (match == wordLength) {
                        count++;
                        match = 0;
                    }
                } else {
                    match = 0;
                }
            }
        }

        return count;
    }

    static int searchDiagLeft(char[][] grid, char[] word) {
        int rows = grid.length;
        int cols = grid[0].length;
        int wordLength = word.length;
        int count = 0;

        for (int col = wordLength - 1; col < cols; col++) {
            int match = 0;
            for (int i = 0; i < Math.min(rows, col + 1); i++) {
                if (grid[i][col - i] == word[match]) {
                    match++;
                    if (match == wordLength) {
                        count++;
                        match = 0; 
                    }
                } else {
                    match = 0;
                }
            }
        }

        for (int row = 1; row <= rows - wordLength; row++) {
            int match = 0;
            for (int i = 0; i < Math.min(rows - row, cols); i++) {
                if (grid[row + i][cols - i - 1] == word[match]) {
                    match++;
                    if (match == wordLength) {
                        count++;
                        match = 0;
                    }
                } else {
                    match = 0;
                }
            }
        }

        return count;
    }

    static int searchVert(char[][] grid, char[] word) {
        int rows = grid.length;
        int cols = grid[0].length;
        int wordLength = word.length;
        int count = 0;

        for (int col = 0; col < cols; col++) {
            int match = 0;
            for (int row = 0; row < rows; row++) {
                if (grid[row][col] == word[match]) {
                    match++;
                    if (match == wordLength) {
                        count++;
                        match = 0;
                    }
                } else {
                    match = 0;
                }
            }
        }
        return count;
    }

    static int searchHor(char[][] grid, char[] word) {
        int rows = grid.length;
        int cols = grid[0].length;
        int wordLength = word.length;
        int count = 0;

        for (int row = 0; row < rows; row++) {
            int match = 0;
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == word[match]) {
                    match++;
                    if (match == wordLength) {
                        count++;
                        match = 0;
                    }
                } else {
                    match = 0;
                }
            }
        }
        return count;
    }
}

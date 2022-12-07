public class Field {

    private static final int GRID_SIZE = 3;

    private static final char X = 'X';

    private static final char Y = 'O';

    private static boolean isWin_X = false;

    private static boolean isWin_O = false;

    private static int emptyCells = 9;

    private static boolean isOVer = false;

    private static char[][] grid = new char[GRID_SIZE][GRID_SIZE];


    private static void createField() {
        grid = new char[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = ' ';
            }
        }
        printField();
    }

    private static void printField() {
        System.out.println("---------");
        for (char[] chars : grid) {
            System.out.print("| ");
            for (char ch : chars) {
                System.out.print(ch + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static void analyzeGame() {
        printField();
        checkHorizontalLines();
        checkVerticalLines();
        checkDiagonalLines1();
        checkDiagonalLine2();
        checkResult();
    }

    private static void checkHorizontalLines() {
        for (char[] chars : grid) {
            int result = 0;
            for (int j = 0; j < grid.length; j++) {
                result += chars[j];
            }
            if (result == 264) {
                isWin_X = true;
            } else if (result == 237) {
                isWin_O = true;
            }
        }
    }

    private static void checkVerticalLines() {
        for (int i = 0; i < grid.length; i++) {
            int result = 0;
            for (char[] chars : grid) {
                result += chars[i];
            }
            if (result == 264) {
                isWin_X = true;
            } else if (result == 237) {
                isWin_O = true;
            }
        }
    }

    private static void checkDiagonalLines1() {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            result += grid[i][i];
            if (result == 264) {
                isWin_X = true;
            } else if (result == 237) {
                isWin_O = true;
            }
        }
    }

    private static void checkDiagonalLine2() {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            result += grid[i][grid.length - i - 1];
        }
        if (result == 264) {
            isWin_X = true;
        } else if (result == 237) {
            isWin_O = true;
        }
    }

    private static void checkResult() {
        if (isWin_X) {
            System.out.println("X wins");
            isOVer = true;
        } else if (isWin_O) {
            System.out.println("O wins");
            isOVer = true;
        } else if (emptyCells == 0) {
            System.out.println("Draw");
            isOVer = true;
        }
    }

    private static void makeAMove(char playerMark) {
        while (true) {
            int[] numbers = InputHandler.input();
            if (grid[numbers[0]][numbers[1]] == ' ') {
                grid[numbers[0]][numbers[1]] = playerMark;
                emptyCells--;
                break;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }
    }

    public static void playGame() {
        createField();
        while (true) {
            makeAMove(X);
            analyzeGame();
            if (isOVer) {
                break;
            }
            makeAMove(Y);
            analyzeGame();
            if (isOVer) {
                break;
            }
        }
    }
}

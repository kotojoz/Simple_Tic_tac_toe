import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static int[] input() {
        int[] numbers = new int[2];
        while (true) {
            try {
                String[] command = scanner.nextLine().split(" ");
                int column = Integer.parseInt(command[0]) - 1;
                if (column < 0 || column > 2) {
                    throw new RuntimeException("Coordinates should be from 1 to 3!");
                }
                int row = Integer.parseInt(command[1]) - 1;
                if (row < 0 || row > 2) {
                    throw new RuntimeException("Coordinates should be from 1 to 3!");
                }
                numbers[0] = column;
                numbers[1] = row;
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

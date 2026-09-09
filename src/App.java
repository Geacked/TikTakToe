import java.util.Scanner;

public class App {
    static char[][] field = new char[3][3];

    public static void main(String[] args) {
        initField();
        Field();
        Player();
    }

    public static void initField() {
        char number = '1';
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = number;
                number++;
            }
        }
    }

    public static void Field() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Checks if the chosen position is NOT occupied by 'X' or 'O'
    public static boolean isFieldFree(int input) {
        int count = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (count == input - 1) {
                    if (field[i][j] != 'X' && field[i][j] != 'O') {
                        return true; // Field is free
                    } else {
                        return false; // Field is occupied
                    }
                }
                count++;
            }
        }
        return false;
    }

    public static void Player() {
        Scanner sc = new Scanner(System.in);
        int p1, p2;

        while (true) {
            // --- PLAYER 1 (X) ---
            System.out.print("Input a number (1-9) for \"X\": ");
            p1 = sc.nextInt();

            while (!isFieldFree(p1)) {
                System.out.println("That field is already taken!");
                System.out.print("Please choose another field (1-9): ");
                p1 = sc.nextInt();
            }

            int count = 0;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (count == p1 - 1) {
                        field[i][j] = 'X';
                    }
                    count++;
                }
            }
            Field();

            if (Detection('X')) {
                System.out.println("Player 1 (X) wins!");
                break;
            }

            // --- PLAYER 2 (O) ---
            System.out.print("Input a number (1-9) for \"O\": ");
            p2 = sc.nextInt();

            while (!isFieldFree(p2)) {
                System.out.println("That field is already taken!");
                System.out.print("Please choose another field (1-9): ");
                p2 = sc.nextInt();
            }

            count = 0;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (count == p2 - 1) {
                        field[i][j] = 'O';
                    }
                    count++;
                }
            }
            Field();

            if (Detection('O')) {
                System.out.println("Player 2 (O) wins!");
                break;
            }
        }
    }

    public static boolean Detection(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == symbol && field[i][1] == symbol && field[i][2] == symbol)
                return true;
            if (field[0][i] == symbol && field[1][i] == symbol && field[2][i] == symbol)
                return true;
        }
        if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol)
            return true;
        if (field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol)
            return true;

        return false;
    }
}
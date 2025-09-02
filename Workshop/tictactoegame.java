import java.util.*;

public class TicTacToeGame {
    private char[] board = new char[10]; // index 0 ignored
    private char playerLetter, computerLetter;
    private boolean playerTurn;

    // UC1: Initialize board with empty spaces
    public void createBoard() {
        for (int i = 1; i < 10; i++) {
            board[i] = ' ';
        }
    }

    // UC2: Choose Letter
    public void chooseLetter(Scanner sc) {
        System.out.print("Choose X or O: ");
        playerLetter = sc.next().toUpperCase().charAt(0);
        computerLetter = (playerLetter == 'X') ? 'O' : 'X';
    }

    // UC3: Show Board
    public void showBoard() {
        System.out.println("\n " + board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---+---+---");
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---+---+---");
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9] + "\n");
    }

    // UC4 + UC5: Check free space & make move
    public boolean isSpaceFree(int index) {
        return board[index] == ' ';
    }

    public void makeMove(int index, char letter) {
        if (isSpaceFree(index)) {
            board[index] = letter;
        }
    }

    // UC6: Toss
    public void toss() {
        Random rand = new Random();
        playerTurn = rand.nextBoolean();
        System.out.println(playerTurn ? "Player plays first!" : "Computer plays first!");
    }

    // UC7: Check winner
    public boolean isWinner(char letter) {
        return (board[1] == letter && board[2] == letter && board[3] == letter) ||
               (board[4] == letter && board[5] == letter && board[6] == letter) ||
               (board[7] == letter && board[8] == letter && board[9] == letter) ||
               (board[1] == letter && board[4] == letter && board[7] == letter) ||
               (board[2] == letter && board[5] == letter && board[8] == letter) ||
               (board[3] == letter && board[6] == letter && board[9] == letter) ||
               (board[1] == letter && board[5] == letter && board[9] == letter) ||
               (board[3] == letter && board[5] == letter && board[7] == letter);
    }

    public boolean isBoardFull() {
        for (int i = 1; i < 10; i++) {
            if (board[i] == ' ') return false;
        }
        return true;
    }

    // UC8 → UC11: Computer Move Strategy
    public int getComputerMove() {
        // 1. Win if possible
        for (int i = 1; i < 10; i++) {
            if (isSpaceFree(i)) {
                board[i] = computerLetter;
                if (isWinner(computerLetter)) { board[i] = ' '; return i; }
                board[i] = ' ';
            }
        }
        // 2. Block player if winning
        for (int i = 1; i < 10; i++) {
            if (isSpaceFree(i)) {
                board[i] = playerLetter;
                if (isWinner(playerLetter)) { board[i] = ' '; return i; }
                board[i] = ' ';
            }
        }
        // 3. Take corner
        int[] corners = {1,3,7,9};
        for (int c : corners) if (isSpaceFree(c)) return c;
        // 4. Take center
        if (isSpaceFree(5)) return 5;
        // 5. Take side
        int[] sides = {2,4,6,8};
        for (int s : sides) if (isSpaceFree(s)) return s;

        return -1; // should not happen
    }

    // UC12: Play Game Loop
    public void play(Scanner sc) {
        createBoard();
        chooseLetter(sc);
        toss();

        while (true) {
            showBoard();

            if (playerTurn) {
                System.out.print("Enter your move (1-9): ");
                int move = sc.nextInt();
                if (move >= 1 && move <= 9 && isSpaceFree(move)) {
                    makeMove(move, playerLetter);
                    if (isWinner(playerLetter)) { showBoard(); System.out.println("Player Wins!"); break; }
                    playerTurn = false;
                } else {
                    System.out.println("Invalid move, try again.");
                }
            } else {
                int move = getComputerMove();
                makeMove(move, computerLetter);
                System.out.println("Computer chose: " + move);
                if (isWinner(computerLetter)) { showBoard(); System.out.println("Computer Wins!"); break; }
                playerTurn = true;
            }

            if (isBoardFull()) {
                showBoard();
                System.out.println("It's a Tie!");
                break;
            }
        }
    }

    // UC13: Replay Option
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            TicTacToeGame game = new TicTacToeGame();
            game.play(sc);
            System.out.print("Play again? (y/n): ");
            if (!sc.next().equalsIgnoreCase("y")) break;
        }
        sc.close();
    }
}

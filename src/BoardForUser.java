/**
 * Created by Delia on 05.01.2016.
 */
public class BoardForUser {
    Game newGame = new Game();
    private char[][] battleBoardForUser;

    private void createBattleBoardForUser(){
        battleBoardForUser = new char[Board.LENGTH][Board.LENGTH];
        for (int i = 0; i < Board.LENGTH; i++) {
            for (int j = 0; j < Board.LENGTH; j++) {
                battleBoardForUser[j][i] = '~';
            }
        }
    }

    public void printBattleBoardForUser() {
        createBattleBoardForUser();
        System.out.println(newGame.getUsername());
        char[] t2hestik = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'};
        for (int k = 0; k <= Board.LENGTH - 1; k++) {
            if (k == 0) {
                System.out.print("    " + t2hestik[k] + " ");
            } else {
                System.out.print(" " + t2hestik[k] + " ");
            }
        }
        for (int i = 0; i < Board.LENGTH; i++) {
            System.out.println();
            if (i == Board.LENGTH - 1) {
                System.out.print((i + 1) + " ");
            } else {
                System.out.print(" " + (i + 1) + " ");
            }
            for (int j = 0; j < Board.LENGTH; j++) {
                System.out.print(" " + battleBoardForUser[j][i] + " ");
            }
        }
        System.out.println();
    }
}

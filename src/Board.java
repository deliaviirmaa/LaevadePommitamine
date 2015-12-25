/**
 * Created by Delia on 07.12.2015.
 */
public class Board {

    public String username;
    static final int LENGHT = 10;
    private char[][] battleBoard;

    public char[][] getBattleBoard() {
        return battleBoard;
    }


    public void buildBattleBoard() {
        battleBoard = new char[LENGHT][LENGHT];
               for (int i = 0; i < LENGHT; i++) {
            for (int j = 0; j < LENGHT; j++) {
                battleBoard[j][i] = '*';
            }
        }
    }
    public void printBattleBoard() {

        char[] t2hestik = new char[]{' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'};
        for (int k = 0; k <= LENGHT - 1; k++) {
            if (k == 0) {
                System.out.print("   " + t2hestik[k] + " ");
            } else {
                System.out.print(" " + t2hestik[k] + " ");
            }
        }
        for (int i = 0; i < LENGHT; i++) {
            System.out.println();
            System.out.print(i + " ");
            for (int j = 0; j < LENGHT; j++) {
                System.out.print(" " + battleBoard[j][i] + " ");
            }
        }
        System.out.println();
    }


}

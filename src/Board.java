import java.util.Random;

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
        placeShips();
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

    private void placeShips() {
        placeShip(4);
        placeShip(3);
        placeShip(3);
        placeShip(2);
        placeShip(2);
        placeShip(2);
        placeShip(1);
        placeShip(1);
        placeShip(1);
        placeShip(1);
    }

    private void placeShip(int lenght) {
        ShipStartPoint shipStartPoint = giveRandomStartPoint();
        markShipOnBoard(shipStartPoint, lenght);
    }

    private ShipStartPoint giveRandomStartPoint(){
        Random random = new Random();
        ShipStartPoint startPoint = new ShipStartPoint();
        startPoint.setCoordinateX(random.nextInt(LENGHT));
        startPoint.setCoordinateY(random.nextInt(LENGHT));
        startPoint.setDirection(Direction.values()[random.nextInt(4)]);
        return startPoint;

    }
    private void markShipOnBoard(ShipStartPoint startPoint, int LENGHT){
       int y = startPoint.getCoordinateY();
        int x = startPoint.getCoordinateX();
        battleBoard[y][x] = 'X';
    }

}




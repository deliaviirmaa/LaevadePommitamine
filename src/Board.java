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

// X-horisontaal (i) kui on ainult see, siis pringib ühe rea
    // y-vertikaal (j) kui on see ka, siis hakkab sellele ühele reale alla asju printima

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
        printBattleBoard();
        placeShip(3);
        printBattleBoard();
        placeShip(3);
        printBattleBoard();
        placeShip(2);
        printBattleBoard();
        placeShip(2);
        printBattleBoard();
        placeShip(2);
        printBattleBoard();
        placeShip(1);
        printBattleBoard();
        placeShip(1);
        printBattleBoard();
        placeShip(1);
        printBattleBoard();
        placeShip(1);
        printBattleBoard();
    }

    private void placeShip(int lenght) {
        ShipStartPoint shipStartPoint = giveRandomStartPoint(lenght);
        System.out.println("starpoint:"+shipStartPoint.getCoordinateX()+ shipStartPoint.getCoordinateY()+ shipStartPoint.getDirection());
        markShipOnBoard(shipStartPoint, lenght);
    }

    private ShipStartPoint giveRandomStartPoint(int lenght) {
        Random random = new Random();
        ShipStartPoint startPoint = new ShipStartPoint();
        startPoint.setCoordinateX(random.nextInt(LENGHT));
        startPoint.setCoordinateY(random.nextInt(LENGHT));
        startPoint.setDirection(Direction.values()[random.nextInt(4)]);
        if (isEnoughFreeSpace(startPoint, lenght) && noShipThere(startPoint, lenght)) {
            return startPoint;
        }

        return giveRandomStartPoint(lenght);
    }

    // kui läheb üles, muudab y-t horisontaalselt jooksevad x-id (parem-vasak x')
    private void markShipOnBoard(ShipStartPoint startPoint, int length) {
        int y = startPoint.getCoordinateY();
        int x = startPoint.getCoordinateX();
        battleBoard[x][y] = 'X';


        if (length == 1) {
            return;
        }

        if (startPoint.getDirection() == Direction.UP && y > 0 && y < LENGHT) {

            startPoint.setCoordinateY(y - 1);
            markShipOnBoard(startPoint, length - 1);
        }
        if (startPoint.getDirection() == Direction.DOWN && y > 0 && y < LENGHT) {
            startPoint.setCoordinateY(y + 1);
            markShipOnBoard(startPoint, length - 1);
        }
        if (startPoint.getDirection() == Direction.LEFT && x > 0 && x < LENGHT) {
            startPoint.setCoordinateX(x - 1);
            markShipOnBoard(startPoint, length - 1);
        }
        if (startPoint.getDirection() == Direction.RIGHT && x > 0 && x < LENGHT) {
            startPoint.setCoordinateX(x + 1);
            markShipOnBoard(startPoint, length - 1);
        }
    }

    //!!! vaja üle mõelda (suundades x ja y muutunud)
    private boolean isEnoughFreeSpace(ShipStartPoint startPoint, int leght) {
        // vahetada kohad, et ei tuleks nullPointException
        if (startPoint.getDirection().equals(Direction.RIGHT)) {
            if (LENGHT - startPoint.getCoordinateY() >= leght) {
                return true;
            }
        }
        if (startPoint.getDirection().equals(Direction.LEFT)) {
            if (startPoint.getCoordinateX()+1 >= leght) {
                return true;
            }
        }
        if (startPoint.getDirection().equals(Direction.UP)) {
            if (startPoint.getCoordinateY()+1 >= leght) {
                return true;
            }
        }
        if (startPoint.getDirection().equals(Direction.DOWN)) {
            if (LENGHT - startPoint.getCoordinateY() >= leght) {
                return true;
            }
        }

        return false;
    }

    private boolean noShipThere(ShipStartPoint startPoint, int length) {
        for (int i = 0; i < length; i++) {
            if (!pointFree(startPoint)) {
                return false;
            }
            startPoint = movePointInDirection(startPoint);
        }
        return true;
    }
// lisada kontrolli, kas ta asub mänguväljal

    private boolean pointFree(ShipStartPoint startPoint) {
        if (battleBoard[startPoint.getCoordinateX()][startPoint.getCoordinateY()] == 'X') {
            return false;
        }
        // ülemise kontroll
        if (startPoint.getCoordinateX() - 1 >= 0 && battleBoard[startPoint.getCoordinateX() - 1][startPoint.getCoordinateY()] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateX() + 1 <= 9 && battleBoard[startPoint.getCoordinateX() + 1][startPoint.getCoordinateY()] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateY() - 1 >= 0 && battleBoard[startPoint.getCoordinateX()][startPoint.getCoordinateY() - 1] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateY() + 1 <= 9 && battleBoard[startPoint.getCoordinateX()][startPoint.getCoordinateY() + 1] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateX() + 1 <= 9 && startPoint.getCoordinateY() - 1 >= 0 && battleBoard[startPoint.getCoordinateX() + 1][startPoint.getCoordinateY() - 1] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateX() + 1 <= 9 && startPoint.getCoordinateY() + 1 <= 9 && battleBoard[startPoint.getCoordinateX() + 1][startPoint.getCoordinateY() + 1] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateX() - 1 >= 0 && startPoint.getCoordinateY() - 1 >= 0 && battleBoard[startPoint.getCoordinateX() - 1][startPoint.getCoordinateY() - 1] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateX() - 1 >= 0 && startPoint.getCoordinateY() + 1 <= 9 && battleBoard[startPoint.getCoordinateX() - 1][startPoint.getCoordinateY() + 1] == 'X') {
            return false;
        }

        return true;

    }

    // tagastab shipstartpointi
    /*
    private void movePointInDirection(ShipStartPoint startPoint) {
        if (startPoint.getDirection().equals(Direction.RIGHT)) {
            startPoint.setCoordinateY(startPoint.getCoordinateY() + 1);
        }
        if (startPoint.getDirection().equals(Direction.LEFT)) {
            startPoint.setCoordinateY(startPoint.getCoordinateY() + 1);
        }
        if (startPoint.getDirection().equals(Direction.DOWN)) {
            startPoint.setCoordinateX(startPoint.getCoordinateX() + 1);
        }
        if (startPoint.getDirection().equals(Direction.UP)) {
            startPoint.setCoordinateX(startPoint.getCoordinateX() + 1);
        }
    }
    */
    private ShipStartPoint movePointInDirection(ShipStartPoint startPoint) {
        if (startPoint.getDirection().equals(Direction.RIGHT)) {
            return new ShipStartPoint(startPoint.getCoordinateX() + 1,
                    startPoint.getCoordinateY(), Direction.RIGHT);
        }
        if (startPoint.getDirection().equals(Direction.LEFT)) {
            return new ShipStartPoint(startPoint.getCoordinateX() - 1,
                    startPoint.getCoordinateY(), Direction.LEFT);
        }
        if (startPoint.getDirection().equals(Direction.DOWN)) {
            return new ShipStartPoint(startPoint.getCoordinateX(),
                    startPoint.getCoordinateY() + 1, Direction.DOWN);
        }
        if (startPoint.getDirection().equals(Direction.UP)) {
            return new ShipStartPoint(startPoint.getCoordinateX(), startPoint.getCoordinateY()
                    - 1, Direction.UP);
        }
        throw new RuntimeException("Impossilbe");
    }

}




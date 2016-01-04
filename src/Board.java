import java.util.Random;

/**
 * Created by Delia on 07.12.2015.
 */
public class Board {

    public static double[][] getBattleBoard;
    public String username;
    static final int LENGTH = 10;
    private char[][] battleBoard;


    Validator validator = new Validator();

// X-horisontaal (i) kui on ainult see, siis pringib ühe rea
    // y-vertikaal (j) kui on see ka, siis hakkab sellele ühele reale alla asju printima

    /**
     * See meetod loob mänguvälja (kahemõõtmeline maatriks, mille pikkus on varem toodud LENGTH
     */
    public void buildBattleBoard() {
        battleBoard = new char[LENGTH][LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                battleBoard[j][i] = '*';
            }
        }
        placeShips();
    }

    /**
     * See meetod pringib mänguväljale tähed ja numbrid.
     */
    public void printBattleBoard() {

        char[] t2hestik = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'};
        for (int k = 0; k <= LENGTH - 1; k++) {
            if (k == 0) {
                System.out.print("    " + t2hestik[k] + " ");
            } else {
                System.out.print(" " + t2hestik[k] + " ");
            }
        }
        for (int i = 0; i < LENGTH; i++) {
            System.out.println();
            if (i==LENGTH-1){
                System.out.print((i+1)+" ");
            } else {
                System.out.print(" "+(i + 1) + " ");
            }
            for (int j = 0; j < LENGTH; j++) {
                System.out.print(" " + battleBoard[j][i] + " ");
            }
        }
        System.out.println();
    }

    /**
     * See meetod asetab laevad mänguväljale
     */
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

    /**
     * See meetod otsib kindla pikkusega laeva jaoks kohta, kuhu ta paigutada.
     * @param ShipLength
     */
    private void placeShip(int ShipLength) {
        ShipStartPoint shipStartPoint = giveRandomStartPoint(ShipLength);
        System.out.println("starpoint:"+shipStartPoint.getCoordinateX()+ shipStartPoint.getCoordinateY()+ shipStartPoint.getDirection());
        markShipOnBoard(shipStartPoint, ShipLength);
    }

    /**
     * See meetod annab laevale suvalise alguspunkti (ja need meetodid, mis seal sees on, kontrollivad, kas see punkt sobib).
     * Kui ei sobi, siis kutsub ise ennast uuesti välja.
     * @param ShipLength
     * @return
     */
    private ShipStartPoint giveRandomStartPoint(int ShipLength) {
        Random random = new Random();
        ShipStartPoint startPoint = new ShipStartPoint();
        startPoint.setCoordinateX(random.nextInt(LENGTH));
        startPoint.setCoordinateY(random.nextInt(LENGTH));
        startPoint.setDirection(Direction.values()[random.nextInt(4)]);
        if (validator.isEnoughFreeSpace(startPoint, ShipLength) && validator.noShipThere(startPoint, ShipLength, battleBoard)) {
            return startPoint;
        }

        return giveRandomStartPoint(ShipLength);
    }

    // kui läheb üles, muudab y-t horisontaalselt jooksevad x-id (parem-vasak x')

    /**
     * See meetod märgib laeva väljakule ja näitab ära suuna, kuhu poole joonistada.
     * @param startPoint
     * @param shipLength
     */
    private void markShipOnBoard(ShipStartPoint startPoint, int shipLength) {
        int y = startPoint.getCoordinateY();
        int x = startPoint.getCoordinateX();
        battleBoard[x][y] = 'X';


        if (shipLength == 1) {
            return;
        }

        if (startPoint.getDirection() == Direction.UP ) {

            startPoint.setCoordinateY(y - 1);
            markShipOnBoard(startPoint, shipLength - 1);
        }
        if (startPoint.getDirection() == Direction.DOWN ) {
            startPoint.setCoordinateY(y + 1);
            markShipOnBoard(startPoint, shipLength - 1);
        }
        if (startPoint.getDirection() == Direction.LEFT ) {
            startPoint.setCoordinateX(x - 1);
            markShipOnBoard(startPoint, shipLength - 1);
        }
        if (startPoint.getDirection() == Direction.RIGHT) {
            startPoint.setCoordinateX(x + 1);
            markShipOnBoard(startPoint, shipLength - 1);
        }
    }




}


// klass board validater ( valideermismeetodid sinna), sellelele teha testid, annan boardi ette
// siin klassis kutsun välja ja annan battleboardi kaasa
// muudan protectedeks
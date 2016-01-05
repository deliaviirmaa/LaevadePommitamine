import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Delia on 03.01.2016.
 */

// kui on mittestaatilised meetodid, siis tuleb objekt luua, kui on static, siis saab klassiga välja kutsuda
public class ValidatorTest extends TestCase {
    private char[][] giveBattleBoard() {
        char[][] battleBoard;
        battleBoard = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                battleBoard[j][i] = '*';
            }
        }
        battleBoard[2][2] = 'X';
        battleBoard[3][2] = 'X';
        battleBoard[4][2] = 'X';
        battleBoard[5][2] = 'X';
        battleBoard[5][5] = 'X';
        battleBoard[5][6] = 'X';
        battleBoard[5][7] = 'X';

        return battleBoard;

    }

    public void testGetBattleBoard() throws Exception {
        assertEquals(true, true);
    }

    @Test
    public void testIsEnoughFreeSpaceDirectionUp() throws Exception {
        ShipStartPoint newStartPoint = new ShipStartPoint();
        Validator validator = new Validator();
        char[][] battleBoard = giveBattleBoard();

        printBattleBoard(battleBoard);
        newStartPoint.setCoordinateX(5);
        newStartPoint.setCoordinateY(1);
        newStartPoint.setDirection(Direction.UP);
        assertEquals(false, validator.isEnoughFreeSpace(newStartPoint, 3));
    }

    @Test
    public void testIsEnoughFreeSpaceDirectionUpTrue() throws Exception {
        ShipStartPoint newStartPoint = new ShipStartPoint();
        Validator validator = new Validator();
        char[][] battleBoard = giveBattleBoard();

        printBattleBoard(battleBoard);
        newStartPoint.setCoordinateX(5);
        newStartPoint.setCoordinateY(1);
        newStartPoint.setDirection(Direction.UP);
        assertEquals(true, validator.isEnoughFreeSpace(newStartPoint, 2));
    }

    @Test
    public void testIsEnoughFreeSpaceDirectionDown() throws Exception {
        ShipStartPoint newStartPoint = new ShipStartPoint();
        Validator validator = new Validator();
        char[][] battleBoard = giveBattleBoard();

        printBattleBoard(battleBoard);
        newStartPoint.setCoordinateX(1);
        newStartPoint.setCoordinateY(8);
        newStartPoint.setDirection(Direction.DOWN);
        assertEquals(false, validator.isEnoughFreeSpace(newStartPoint, 3));
    }

    @Test
    public void testIsEnoughFreeSpaceDirectionDownTrue() throws Exception {
        ShipStartPoint newStartPoint = new ShipStartPoint();
        Validator validator = new Validator();
        char[][] battleBoard = giveBattleBoard();

        printBattleBoard(battleBoard);
        newStartPoint.setCoordinateX(3);
        newStartPoint.setCoordinateY(6);
        newStartPoint.setDirection(Direction.DOWN);
        assertEquals(true, validator.isEnoughFreeSpace(newStartPoint, 3));
    }

    @Test
    public void testIsEnoughFreeSpaceDirectionLeft() throws Exception {
        ShipStartPoint newStartPoint = new ShipStartPoint();
        Validator validator = new Validator();
        char[][] battleBoard = giveBattleBoard();

        printBattleBoard(battleBoard);
        newStartPoint.setCoordinateX(0);
        newStartPoint.setCoordinateY(5);
        newStartPoint.setDirection(Direction.LEFT);
        assertEquals(false, validator.isEnoughFreeSpace(newStartPoint, 2));
    }

    @Test
    public void testIsEnoughFreeSpaceDirectionLeftTrue() throws Exception {
        ShipStartPoint newStartPoint = new ShipStartPoint();
        Validator validator = new Validator();
        char[][] battleBoard = giveBattleBoard();

        printBattleBoard(battleBoard);
        newStartPoint.setCoordinateX(0);
        newStartPoint.setCoordinateY(5);
        newStartPoint.setDirection(Direction.LEFT);
        assertEquals(true, validator.isEnoughFreeSpace(newStartPoint, 1));
    }

    @Test
    public void testIsEnoughFreeSpaceDirectionRight() throws Exception {
        ShipStartPoint newStartPoint = new ShipStartPoint();
        Validator validator = new Validator();
        char[][] battleBoard = giveBattleBoard();

        printBattleBoard(battleBoard);
        newStartPoint.setCoordinateX(8);
        newStartPoint.setCoordinateY(3);
        newStartPoint.setDirection(Direction.RIGHT);
        assertEquals(false, validator.isEnoughFreeSpace(newStartPoint, 3));
    }

    @Test
    public void testIsEnoughFreeSpaceDirectionRightTrue() throws Exception {
        ShipStartPoint newStartPoint = new ShipStartPoint();
        Validator validator = new Validator();
        char[][] battleBoard = giveBattleBoard();

        printBattleBoard(battleBoard);
        newStartPoint.setCoordinateX(8);
        newStartPoint.setCoordinateY(3);
        newStartPoint.setDirection(Direction.LEFT);
        assertEquals(true, validator.isEnoughFreeSpace(newStartPoint, 2));
    }
    @Test
    public void testNoShipThereRight() throws Exception {
        ShipStartPoint newStartPoint = new ShipStartPoint();
        Validator validator = new Validator();
        char[][] battleBoard = giveBattleBoard();

        printBattleBoard(battleBoard);
        newStartPoint.setCoordinateX(3);
        newStartPoint.setCoordinateY(6);
        newStartPoint.setDirection(Direction.RIGHT);
        assertEquals(false, validator.noShipThere(newStartPoint, 3, battleBoard));
    }

    @Test
    public void testNoShipThereTrueLeft() throws Exception {
        ShipStartPoint newStartPoint = new ShipStartPoint();
        Validator validator = new Validator();
        char[][] battleBoard = giveBattleBoard();

        printBattleBoard(battleBoard);
        newStartPoint.setCoordinateX(3);
        newStartPoint.setCoordinateY(6);
        newStartPoint.setDirection(Direction.LEFT);
        assertEquals(true, validator.noShipThere(newStartPoint, 2, battleBoard));
    }
    @Test
    public void testNoShipThereUp() throws Exception {
        ShipStartPoint newStartPoint = new ShipStartPoint();
        Validator validator = new Validator();
        char[][] battleBoard = giveBattleBoard();

        printBattleBoard(battleBoard);
        newStartPoint.setCoordinateX(3);
        newStartPoint.setCoordinateY(3);
        newStartPoint.setDirection(Direction.UP);
        assertEquals(false, validator.noShipThere(newStartPoint, 3, battleBoard));
    }

    @Test
    public void testNoShipThereDown() throws Exception {
        ShipStartPoint newStartPoint = new ShipStartPoint();
        Validator validator = new Validator();
        char[][] battleBoard = giveBattleBoard();

        printBattleBoard(battleBoard);
        newStartPoint.setCoordinateX(0);
        newStartPoint.setCoordinateY(3);
        newStartPoint.setDirection(Direction.DOWN);
        assertEquals(true, validator.noShipThere(newStartPoint, 2, battleBoard));
    }
    @Test
    public void testPointFree() throws Exception {
        ShipStartPoint newStartPoint = new ShipStartPoint();
        Validator validator = new Validator();
        char[][] battleBoard = giveBattleBoard();

        printBattleBoard(battleBoard);
        newStartPoint.setCoordinateX(3);
        newStartPoint.setCoordinateY(3);
        newStartPoint.setDirection(Direction.DOWN);
        assertEquals(false, validator.pointFree(newStartPoint, battleBoard));
    }
    @Test
    public void testPointFreeTrue() throws Exception {
        ShipStartPoint newStartPoint = new ShipStartPoint();
        Validator validator = new Validator();
        char[][] battleBoard = giveBattleBoard();

        printBattleBoard(battleBoard);
        newStartPoint.setCoordinateX(7);
        newStartPoint.setCoordinateY(4);
        newStartPoint.setDirection(Direction.DOWN);
        assertEquals(true, validator.pointFree(newStartPoint, battleBoard));
    }

    private void printBattleBoard(char[][] battleBoard) {

        char[] t2hestik = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'};
        for (int k = 0; k <= 10 - 1; k++) {
            if (k == 0) {
                System.out.print("    " + t2hestik[k] + " ");
            } else {
                System.out.print(" " + t2hestik[k] + " ");
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
            if (i == 10 - 1) {
                System.out.print((i + 1) + " ");
            } else {
                System.out.print(" " + (i + 1) + " ");
            }
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + battleBoard[j][i] + " ");
            }
        }
        System.out.println();
    }



}
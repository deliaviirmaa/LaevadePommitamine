/**
 * Created by Delia on 04.01.2016.
 */
public class Validator {
    /**
     * See meetod kontrollib, kas on piisavalt vaba ruumi(kas laev jääb mänguvälja piiridesse) laeva paigutamiseks.
     *
     * @param startPoint
     * @param shipLength
     * @return
     */

    public static boolean isEnoughFreeSpace(ShipStartPoint startPoint, int shipLength) {
        // vahetada kohad, et ei tuleks nullPointException
        if (startPoint.getDirection().equals(Direction.RIGHT)) {
            if (Board.LENGTH - startPoint.getCoordinateX() >= shipLength) {
                return true;
            }
        }
        if (startPoint.getDirection().equals(Direction.LEFT)) {
            if (startPoint.getCoordinateX() + 1 >= shipLength) {
                return true;
            }
        }
        if (startPoint.getDirection().equals(Direction.UP)) {
            if (startPoint.getCoordinateY() + 1 >= shipLength) {
                return true;
            }
        }
        if (startPoint.getDirection().equals(Direction.DOWN)) {
            if (Board.LENGTH - startPoint.getCoordinateY() >= shipLength) {
                return true;
            }
        }

        return false;
    }

    /**
     * See meetod vaatab, kas seal pole juba laeva ees, kuhu uus laeva soovitakse paigutada.
     *
     * @param startPoint
     * @param shipLength
     * @return
     */
    public boolean noShipThere(ShipStartPoint startPoint, int shipLength, char[][] battleBoard) {
        for (int i = 0; i < shipLength; i++) {
            if (!pointFree(startPoint, battleBoard)) {
                return false;
            }
            startPoint = movePointInDirection(startPoint);
        }
        return true;
    }

    /**
     * See meetod kontrollib, kas konkreetne koht on vaba.
     *
     * @param startPoint
     * @return
     */
    public boolean pointFree(ShipStartPoint startPoint, char[][] battleBoard) {
        if (battleBoard[startPoint.getCoordinateX()][startPoint.getCoordinateY()] == 'X') {
            return false;
        }
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

    /**
     * See meetod liigub mööda laeva pikkust valitud suunas, et saaks teostada kontrolli, kas seal juba oli mõni laev.
     *
     * @param startPoint
     * @return
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
        throw new RuntimeException("Impossible");
    }

}

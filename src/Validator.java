/**
 * Created by Delia on 04.01.2016.
 */
public class Validator {
    /**
     * See meetod kontrollib, kas on piisavalt vaba ruumi, et laeva saaks kuhugi(sinna, kuhu suvaline punkt genereeriti) paigutada.
     * @param startPoint
     * @param shipLength
     * @return
     */
    Board battleBoard = new Board();
    public static boolean isEnoughFreeSpace(ShipStartPoint startPoint, int shipLength) {
        // vahetada kohad, et ei tuleks nullPointException
        if (startPoint.getDirection().equals(Direction.RIGHT)) {
            if (Board.LENGTH - startPoint.getCoordinateX() >= shipLength) {
                return true;
            }
        }
        if (startPoint.getDirection().equals(Direction.LEFT)) {
            if (startPoint.getCoordinateX()+1 >= shipLength) {
                return true;
            }
        }
        if (startPoint.getDirection().equals(Direction.UP)) {
            if (startPoint.getCoordinateY()+1 >= shipLength) {
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
     * @param startPoint
     * @param shipLength
     * @return
     */
    public static boolean noShipThere(ShipStartPoint startPoint, int shipLength) {
        for (int i = 0; i < shipLength; i++) {
            if (!pointFree(startPoint)) {
                return false;
            }
            startPoint = Board.movePointInDirection(startPoint);
        }
        return true;
    }

    /**
     * See meetod kontrollib, kas konkreetne koht on vaba.
     * @param startPoint
     * @return
     */
    public static boolean pointFree(ShipStartPoint startPoint ) {
        if (Board.getBattleBoard[startPoint.getCoordinateX()][startPoint.getCoordinateY()] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateX() - 1 >= 0 && Board.getBattleBoard[startPoint.getCoordinateX() - 1][startPoint.getCoordinateY()] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateX() + 1 <= 9 && Board.getBattleBoard[startPoint.getCoordinateX() + 1][startPoint.getCoordinateY()] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateY() - 1 >= 0 && Board.getBattleBoard[startPoint.getCoordinateX()][startPoint.getCoordinateY() - 1] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateY() + 1 <= 9 && Board.getBattleBoard[startPoint.getCoordinateX()][startPoint.getCoordinateY() + 1] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateX() + 1 <= 9 && startPoint.getCoordinateY() - 1 >= 0 && Board.getBattleBoard[startPoint.getCoordinateX() + 1][startPoint.getCoordinateY() - 1] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateX() + 1 <= 9 && startPoint.getCoordinateY() + 1 <= 9 && Board.getBattleBoard[startPoint.getCoordinateX() + 1][startPoint.getCoordinateY() + 1] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateX() - 1 >= 0 && startPoint.getCoordinateY() - 1 >= 0 && Board.getBattleBoard[startPoint.getCoordinateX() - 1][startPoint.getCoordinateY() - 1] == 'X') {
            return false;
        }
        if (startPoint.getCoordinateX() - 1 >= 0 && startPoint.getCoordinateY() + 1 <= 9 && Board.getBattleBoard[startPoint.getCoordinateX() - 1][startPoint.getCoordinateY() + 1] == 'X') {
            return false;
        }

        return true;

    }
}

/**
 * Created by Delia on 22.12.2015.
 */
public class ShipStartPoint {
    private int coordinateX;
    private int coordinateY;
    private Direction direction;

    /**
     * See on get meetod koordinaat x saamiseks.
     * @return
     */
    public int getCoordinateX() {
        return coordinateX;
    }

    /**
     * See on set meetod koordinaat x-i muutmiseks.
     * @param coordinateX
     */
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    /**
     * See on get meetod koordinaat y-i saamiseks (näiteks kuskilt mujal klassis olles).
     * @return
     */
    public int getCoordinateY() {
        return coordinateY;
    }

    /**
     * See on set meetod koorinaat y-i muutmiseks.
     * @param coordinateY
     */
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    /**
     * see on get meetod suuna saamiseks.
     * @return
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * See on set meetod suuna muutmiseks.
     * @param direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * See on tühi konstruktor.
     */
    public ShipStartPoint() {
    }

    /**
     * See on konstruktor laeva alguspunktile.
     * @param x
     * @param y
     * @param direction
     */
    public ShipStartPoint(int x, int y, Direction direction) {
        coordinateX = x;
        coordinateY = y;
        this.direction = direction;
    }
}

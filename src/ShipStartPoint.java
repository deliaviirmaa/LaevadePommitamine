/**
 * Created by Delia on 22.12.2015.
 */
public class ShipStartPoint {
    private int coordinateX;
    private int coordinateY;
    private Direction direction;

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public ShipStartPoint() {
    }

    public ShipStartPoint(int x, int y, Direction direction) {
        coordinateX = x;
        coordinateY = y;
        this.direction = direction;
    }


}

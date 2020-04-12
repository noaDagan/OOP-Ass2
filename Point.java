/**
 * The point class make a point with x and y value.
 */
public class Point {
    //Members
     public double x;
     public double y;

    /**
     * constructor build the point with x and y value.
     * @param x value of point
     * @param y value of point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance function calculate the distance between two point.
     * @param other A point parameter in the line
     * @return The distance of this point to the other point
     */
    public double distance(Point other) {
        double distanceX = this.x - other.getX();
        double distanceY = this.y - other.getY();
        // Calculate the distance between to point and do sqrt
        return Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
    }

    /**
     * The function check if the values of two point are equals.
     * @param other a point in the line
     * @return true is the points are equal and false otherwise
     */
    public boolean equals(Point other) {
        // x and y are not equals
        if (!(this.x == other.x) && (this.y == other.y)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     *
     * @return The x value of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     *
     * @return The y value of this point
     */
    public double getY() {
        return this.y;
    }
}

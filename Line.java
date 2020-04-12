/**
 * The line class make a line between two point start and end.
 * also check if the line have intersection point,if the line are equals and calculate the middle point
 */
public class Line {
    //Members
    private Point start;
    private Point end;

    /**
     * constructors build the start and end point of the line.
     * @param x1 double x Value first point
     * @param y1 double y Value first point
     * @param x2 double x Value second point
     * @param y2 double y value second point
     */
    public Line(double x1, double y1, double x2, double y2) {
        // The function check which point in the start or end
        if (x1 < x2) {
            this.start = new Point(x1, y1);
            this.end = new Point(x2, y2);
        } else {
            this.end = new Point(x1, y1);
            this.start = new Point(x2, y2);
        }
    }

    /**

     * @param start the first value point of the line
     * @param end the last value point of the line
     */
    public Line(Point start, Point end) {
        this(start.getX(), start.getY(), end.getX(), end.getY());
    }

    /**
     * @return The function return the distance of the line between start and end point
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * The function cslculate the middle point between start and end.
     * @return The middle point of the line
     */
    public Point middle() {
        // Members
        double middleX;
        double middleY;
        Point middlePoint;
        // Calculate the middle point with x and y
        middleX = (start.getX() + end.getX()) / 2;
        middleY = (start.getY() + end.getY()) / 2;
        // make a new middle point
        middlePoint = new Point(middleX, middleY);
        return middlePoint;
    }

    /**
     * point start.
     * @return Returns the start point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * point end.
     * @return Returns the end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * The function check the intersection point with other line.
     * @param other parameter type line
     * @return Returns true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        // Check if the intersectionWith function find a intersect point
        if (this.intersectionWith(other) == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * The function find the intersection point between the lines.
     * @param other line peramater
     * @return the intersection point if the lines intersect, and null otherwise
     */
    public Point intersectionWith(Line other) {
        // Members
        double b1;
        double b2;
        double m1;
        double m2;
        double intersectX;
        double intersectY;
        Point intersect;
        // Caculate the function by the point - y = mx + b
        // Calculate the lncline and a point in the function.
        m1 = (other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX());
        m2 = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        b1 = other.start.getY() - m1 * other.start.getX();
        b2 = this.start.getY() - m2 * this.start.getX();
        //The line equals or parallel
        if (m1 == m2) {
            return null;
        }
        // calculate the intersect point
        intersectX = (b2 - b1) / (m1 - m2);
        intersectY = (m1 * intersectX) + b1;
        // make a new point
        intersect = new Point(intersectX, intersectY);
        // check if the point in the boundery
        if (((intersectX > other.start.getX()) && (intersectX < other.end.getX()))
                && ((intersectX > this.start.getX()) && (intersectX < this.end.getX()))) {
            return intersect;
        } else {
            return null;
        }
    }

    /**
     * The function check if the line are equals.
     * @param other parameter line
     * @return True is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        if ((this.start.equals(other.start)) && (this.end.equals(other.end))) {
            return true;
        } else {
            return false;
        }
    }
}



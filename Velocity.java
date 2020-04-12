 /**
  * Velocity specifies the change in position on the `x` and the `y` axes.
  */
 public class Velocity {
    //Members
     public double dx;
     public double dy;
     /**
      * constructor build the velocity by dx and dy.
      * @param dx a double
      * @param dy a double
      */
     public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
     /**
      * The function Take a point with position (x,y) and return a new point.
      * with position (x+dx, y+dy) - the next step
      * @param p a point with (x,y) value
      * @return new point that the ball need mive (next step)
      */
    public Point applyToPoint(Point p) {
        double newX = p.getX() + this.dx;
        double newY = p.getY() + this.dy;
        Point newPoint = new Point(newX, newY);
        return newPoint;
    }

     /**
      * The function calculate the dx and dy by the speed and distance.
      * @param angle a double type to calculate the velocity
      * @param speed a double type to calculate the velocity
      * @return the calocity by anle and speed
      */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.cos(Math.toRadians(angle));
        double dy = speed * Math.sin(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }
}
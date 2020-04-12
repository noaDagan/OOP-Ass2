// import.
import biuoop.DrawSurface;

/**
 * The class ball crate a ball.
 */
public class Ball {
    //Members
    public double x;
    public double y;
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private static final int BOUNDARY_X  = 800;
    private static final int BOUNDARY_Y = 600;

    /**
     * constructor Ball build a ball with center value,radius and color.
     * @param center value of the center circle
     * @param r the radius od the circle
     * @param color the color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        // initialize the velocity with (0,0)
        this.velocity = new Velocity(0, 0);
        this.center = new Point(center.getX(), center.getY());
        this.r = r;
        this.color = color;
    }

    /**
     * constructor Ball build a  ball with (x,y) point ,radius and color.
     * @param x value of point
     * @param y value of point
     * @param r the value radius of point
     * @param color the color value of point
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        // initialize the velocity with (0,0)
        this.velocity = new Velocity(0, 0);
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }
    /**
     * accessors to return the center value.
     * @return this integer center of circle
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * accessors to return the center value.
     * @return this integer center of circle
     */
    public int getY() {
        return (int) this.center.getY();
    }
    /**
     * accessors to return the radius.
     * @return this radius of the circle
     */
    public int getSize() {
        return this.r;
    }

    /**
     * accessors to return the color.
     * @return this color of circle
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * The function change ball velocity.
     * @param v a velocity parameter
     */
    public void setVelocity(Velocity v) {
        this.velocity.dx = v.dx;
        this.velocity.dy = v.dy;
    }

    /**
     * The function change ball velocity by speed and distance.
     * @param dx type double
     * @param dy type double
     */
    public void setVelocity(double dx, double dy) {
        this.velocity.dx = dx;
        this.velocity.dy = dy;
    }

    /**
     * @return The velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }
    /**
     * The function return the next step of the ball.
     * if the ball hits in the border of the screen change the angle direction
     */
    public void moveOneStep() {
        this.center = this.getVelocity().applyToPoint(this.center);
        // Use in function with the parameter in the size of screen
        moveOneStep(0, 0, BOUNDARY_X, BOUNDARY_Y);
    }

    /**
     * The function return the next step of the ball.
     * If the ball hits the border of the screen change the angle of her direction
     * The function check if the ball go outside from the border
     * @param boundaryLeftX int type save the boundary x left of the screen
     * @param boundaryLeftY int type save the boundary y left of the screen
     * @param boundaryRightX int type save the boundary x right of the screen
     * @param boundaryRightY int type save the boundary y right of the screen
     */
    public void moveOneStep(int boundaryLeftX, int boundaryLeftY, int boundaryRightX, int boundaryRightY) {
        this.center = this.getVelocity().applyToPoint(this.center);
        // Check if the ball hits the border of the screen in all side
        if (this.center.getX() > (boundaryRightX - this.r)) {
            this.center.x -= this.velocity.dx;
            this.velocity.dx = -this.velocity.dx;
        } else if (this.center.getX() < boundaryLeftX + this.r) {
            this.velocity.dx = -this.velocity.dx;
            this.center.x += this.velocity.dx;
        }
        if (this.center.getY() > (boundaryRightY - this.r)) {
            this.center.y -= this.velocity.dy;
            this.velocity.dy = -this.velocity.dy;
        } else if (this.center.getY() < boundaryLeftY + this.r) {
            this.velocity.dy = -this.velocity.dy;
            this.center.y += this.velocity.dy;
        }
    }

    /**
     * Draw the ball on the given DrawSurface.
     * @param surface the type of the screen
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        // crate the ball by x , y and radius
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }
}



// import.
import biuoop.GUI;
import biuoop.DrawSurface;

/**
 * This class make a ball in the frame.
 * if the ball hits in the frame change the angle direction
 */
public class BouncingBallAnimation {
    // Boundary X and Y of the frame
    private static final int BOUNDARY_X  = 800;
    private static final int BOUNDARY_Y = 600;

    /**
     * Main function make the ball move inside a frame with another ball function.
     * @param args The line command input
     */
    public static void main(String[] args) {
        GUI gui = new GUI("title", BOUNDARY_X, BOUNDARY_Y);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        // Create a new black Ball
        Ball ball = new Ball(30, 30, 30, java.awt.Color.BLACK);
        // make the velocity to the ball (2,2)
        ball.setVelocity(2, 2);
        // loop infinite
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            // Draw the ball
            ball.drawOn(d);
            gui.show(d);
            // wait for 50 milliseconds.
            sleeper.sleepFor(50);
        }
    }
}

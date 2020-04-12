import biuoop.GUI;
import biuoop.DrawSurface;
import java.awt.*;
import java.util.Random;

/**
 * The MultipleFramesBouncingBallsAnimation create two frames with another ball.
 */
public class MultipleFramesBouncingBallsAnimation {
    // Members
    private static final int BOUNDARY_X = 800;
    private static final int BOUNDARY_Y = 600;
    private static final int BOUNAERY_FIRST_LEFT = 50;
    private static final int BOUNAERY_FIRST_RIGHT = 500;
    private static final int BOUNDARY_SECOND_LEFT = 450;
    private static final int BOUNDARY_SECOND_RIGHT = 600;

    /**
     * Main function create two different frame.
     * the first half ball move in the first frame and the second half ball move in the second frame
     * @param args the line command input
     */
    public static void main(String[] args) {
        // calculate the lengths args
        int len = args.length - 1;
        // ballArray save all the ball
        Ball[]ballArray = new Ball[len];
        double dx;
        double dy;
        int centerX;
        int centerY;
        // create a random-number generator
        Random rand = new Random();
        GUI gui = new GUI("MultipleFramesBouncingBalls", BOUNDARY_X, BOUNDARY_Y);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        // loop run over  all the ball and create all ball in his frame
        for (int i = 1; i <= len; i++) {
            int ballSize = Integer.parseInt(args[i]);
            // crate a function to calculate the speed respectively to his size
            // biggest ball more slower
            dx = 100 / ballSize;
            dy = 10;
            // check if the size bigger than 50
            if (ballSize > 50) {
                dx = 1;
            }
            //The first half
            if (i <= len / 2) {
                centerX = rand.nextInt(
                        BOUNAERY_FIRST_RIGHT - 2 * ballSize - BOUNAERY_FIRST_LEFT) + ballSize + BOUNAERY_FIRST_LEFT;
                centerY = rand.nextInt(
                        BOUNAERY_FIRST_RIGHT - 2 * ballSize - BOUNAERY_FIRST_LEFT) + ballSize + BOUNAERY_FIRST_LEFT;
                ballArray[i - 1] = new Ball(centerX, centerY, ballSize, java.awt.Color.BLACK);
            } else { // the second  half
                centerX = rand.nextInt(
                        BOUNDARY_SECOND_RIGHT - 2 * ballSize - BOUNDARY_SECOND_LEFT) + ballSize + BOUNDARY_SECOND_LEFT;
                centerY = rand.nextInt(
                        BOUNDARY_SECOND_RIGHT - 2 * ballSize - BOUNDARY_SECOND_LEFT) + ballSize + BOUNDARY_SECOND_LEFT;
                ballArray[i - 1] = new Ball(centerX, centerY, ballSize, java.awt.Color.BLACK);
            } // crate new velocity
            Velocity velocity = new Velocity(dx, dy);
            ballArray[i - 1].setVelocity(velocity.dx, velocity.dy);
        } // loop infinite
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            d.setColor(Color.GRAY);
            d.fillRectangle(BOUNAERY_FIRST_LEFT, BOUNAERY_FIRST_LEFT, BOUNAERY_FIRST_RIGHT - BOUNAERY_FIRST_LEFT,
                    BOUNAERY_FIRST_RIGHT - BOUNAERY_FIRST_LEFT);
            d.setColor(Color.YELLOW);
            d.fillRectangle(
                    BOUNDARY_SECOND_LEFT, BOUNDARY_SECOND_LEFT, BOUNDARY_SECOND_RIGHT - BOUNDARY_SECOND_LEFT,
                    BOUNDARY_SECOND_RIGHT - BOUNDARY_SECOND_LEFT);
            d.setColor(Color.BLACK);
            for (int i = 1; i <= len; i++) {
                if (i <= len / 2) { // use ball moveOneStep function in the frame
                    ballArray[i - 1].moveOneStep(BOUNAERY_FIRST_LEFT,
                            BOUNAERY_FIRST_LEFT, BOUNAERY_FIRST_RIGHT, BOUNAERY_FIRST_RIGHT);
                } else { // use ball moveOneStep function in the frame
                    ballArray[i - 1].moveOneStep(
                            BOUNDARY_SECOND_LEFT, BOUNDARY_SECOND_LEFT, BOUNDARY_SECOND_RIGHT, BOUNDARY_SECOND_RIGHT);
                }
                ballArray[i - 1].drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}




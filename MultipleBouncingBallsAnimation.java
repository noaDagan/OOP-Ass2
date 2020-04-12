import biuoop.GUI;
import biuoop.DrawSurface;
import java.util.Random;

/**
 * The class MultipleBouncingBallsAnimation create a Balls move on the screen.
 * The main function save all the balls in array
 */
public class MultipleBouncingBallsAnimation {
    private static final int BOUNDARY_X = 800;
    private static final int BOUNDARY_Y = 600;

    /**
     * @param args the command line input
     */
    public static void main(String[] args) {
        int len = args.length;
        double dx;
        double dy;
        Random rand = new Random(); // create a random-number generator
        Ball[]ballArray = new Ball[len];
        GUI gui = new GUI("MultipleBouncingBalls", BOUNDARY_X, BOUNDARY_Y);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        for (int i = 1; i < len; i++) {
            int ballSize = Integer.parseInt(args[i]);
            dx = 100 / ballSize;
            dy = 10;
            // check if the size bigger than 50
            if (ballSize > 50) {
                dx = 1;
            }
            int centerX = rand.nextInt(BOUNDARY_X - 2 * ballSize) + ballSize;
            int centerY = rand.nextInt(BOUNDARY_Y - 2 * ballSize) + ballSize;
            ballArray[i - 1] = new Ball(centerX, centerY, ballSize, java.awt.Color.BLACK);
            Velocity velocity = new Velocity(dx, dy);
            ballArray[i - 1].setVelocity(velocity.dx, velocity.dy);
        }
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            for (int i = 1; i < len; i++) {
                ballArray[i - 1].moveOneStep();
                ballArray[i - 1].drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}

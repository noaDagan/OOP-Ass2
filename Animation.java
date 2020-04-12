import biuoop.GUI;
import biuoop.DrawSurface;

/**
 * The animation class run the ball.
 */
public class Animation {
    /**
     * main function.
     * @param args the command line input
     */
    public static void main(String[]args) {
        GUI gui = new GUI("title", 800, 600);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        Ball ball = new Ball(30, 30, 30, java.awt.Color.BLACK);
        ball.setVelocity(2, 2);
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}


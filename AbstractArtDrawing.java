import biuoop.GUI;
import biuoop.DrawSurface;
import java.util.Random;
import java.awt.Color;

/**
 * The AbstractArtDrawing class crate 10 lines , with intersection point and middle point.
 * The function main draw all the line on the screen
 */
public class AbstractArtDrawing {
    // Members
    private static final int MAX_SIZE = 10;
    // Make a new array to save all the line
    private Line[]lineArr = new Line[MAX_SIZE];

    /**
     * The function printTask making a 10 lines.
     * The function find the middle point and the intersection point
     */
    public void printTask() {
        // Members
        int x;
        int y;
        int a;
        int b;
        Point intersect;
        Point middle;
        // create a random-number generator
        Random rand = new Random();
        // Create a window with the title "AbstractArtDrawing "
        // which is 800 pixels wide and 60 pixels high.
        GUI gui = new GUI("AbstractArtDrawing", 800, 600);
        DrawSurface d = gui.getDrawSurface();
        // loop run 10 times and make 10 lines
        for (int i = 0; i < 10; i++) {
            int x1 = rand.nextInt(800) + 1; // get integer in range 1-800
            int y1 = rand.nextInt(600) + 1; // get integer in range 1-600
            int x2 = rand.nextInt(800) + 1; // get integer in range 1-800
            int y2 = rand.nextInt(600) + 1; // get integer in range 1-600
            // Making a new line type and save in the lineArr array
            Line lineToPrint = new Line(x1, y1, x2, y2);
            lineArr[i] = lineToPrint;
            // Make the line in Black in the point bound
            d.setColor(Color.BLACK);
            d.drawLine(x1, y1, x2, y2);
            // Find the middle point and save in the (int)members
            middle = lineArr[i].middle();
            x = (int) middle.getX();
            y = (int) middle.getY();
            d.setColor(Color.BLUE);
            d.fillCircle(x, y, 3);
            // Loop run over all the line and check if the lines have intersection point and print it in red
            for (int j = i - 1; j >= 0; j--) {
                intersect = lineArr[i].intersectionWith(lineArr[j]);
                if (intersect != null) {
                    a = (int) intersect.getX();
                    b = (int) intersect.getY();
                    d.setColor(Color.RED);
                    d.fillCircle(a, b, 3);
                }
            }
        }
        gui.show(d);
    }

    /**
     * The main function make a drawing type and print the line and point by printTask function.
     *
     * @param args the command line
     */
    public static void main(String[] args) {
        AbstractArtDrawing drawing = new AbstractArtDrawing();
        drawing.printTask();
    }
}
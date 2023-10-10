package u01_theBasics;

public class s04_FirstAnimation {

    public static void main(String[] args) {
        StdDraw.setScale(0, 100);
        StdDraw.enableDoubleBuffering(); //Calling this method stops things from being drawn immediately after a draw method is called. This allows you to call many different draw methods without anything being drawn on the screen; when you call StdDraw.show(), everything will be drawn at once.

        /*
            60mph * 2hrs = 120 miles
            60mph * 1.5hrs = 90 miles

            You've already driven 20 miles, then you keep on driving for 2 hours at 60mph. How far have you driven
            20 miles + 60mph * 2hrs = 140 miles

            ---

            A rectangle starts at 20 px, then travels at 10 px/sec and keeps traveling forever.
            20 px + 10px/sec * ... = total distance traveled

            If a rectangle is following this path and is at 20px the first frame, where will the rectangle be in the next frame?

            20px + 10px/sec (1/60)
         */

        double xPos = 50; // px
        double yPos = 50; // px
        double xVel = 10; // px/sec

        double timeElapsed = 0.017; //0.017 seconds-- this is how long each frame of our animation appears.
        while (true) {
            xPos = xPos + xVel * timeElapsed;

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(xPos, yPos, 10,20);
            System.out.println(xPos);

            StdDraw.show(); //Because we have called StdDraw.enableDoubleBuffering(), everything that you draw up until this point will be loaded into java's memory but not actually drawn. Calling StdDraw.draw() then draws everything at once that is loaded into java's memory.
            StdDraw.pause((int) (timeElapsed * 1000)); //You must pass to the pause method the number of milliseconds to pause for; so we multiply by 1000 because our timeElapsed variable is in seconds, not milliseconds.
            StdDraw.clear(); //This clears everything drawn on the screen. You must redraw the image you wish to display for each frame of an animation
        }
    }
}
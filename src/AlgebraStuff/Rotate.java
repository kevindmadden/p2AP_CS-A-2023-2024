package AlgebraStuff;

import java.text.DecimalFormat;

public class Rotate {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        StdDraw.setScale(-2, 2);
        StdDraw.enableDoubleBuffering(); //Calling this method stops things from being drawn immediately after a draw method is called. This allows you to call many different draw methods without anything being drawn on the screen; when you call StdDraw.show(), everything will be drawn at once.



        boolean isMousePressedPrevFrame = false;

        double theta = 0;
        double fractionOfPi = .01;
        int counter = 0;

        double timeElapsed = 0.017; //0.017 seconds-- this is how long each frame of our animation appears.
        while (true) {
            if(!StdDraw.isMousePressed() && isMousePressedPrevFrame){
                counter++;
                theta = Math.PI*fractionOfPi*counter;
            }



            double x1 = Math.cos(Math.PI/2.0+theta);
            double y1 = Math.sin(Math.PI/2.0+theta);

            double x2 = Math.cos(5*Math.PI/4.0+theta);
            double y2 = Math.sin(5*Math.PI/4.0+theta);

            double x3 = Math.cos(7*Math.PI/4.0+theta);
            double y3 = Math.sin(7*Math.PI/4.0+theta);

            StdDraw.text(.5,1.5, "(cos(π/2+"+df.format(fractionOfPi*counter)+"π), sin(π/2+" +df.format(fractionOfPi*counter)+"π)");
            StdDraw.text(.5,1.3, "("+Math.cos(Math.PI/2.0 + fractionOfPi*counter*Math.PI));
            //StdDraw.text(-1.5,1.5, "("+df.format(x1/Math.PI)+"π, "+df.format(y1/Math.PI)+"π)");

            StdDraw.setPenRadius(.01);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.line(x1,y1,x2,y2);
            StdDraw.line(x2,y2,x3,y3);
            StdDraw.line(x3,y3,x1,y1);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledCircle(x1,y1,.05);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledCircle(x2,y2,.05);
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.filledCircle(x3,y3,.05);

            StdDraw.setPenRadius(.002);
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.circle(0,0,1);

            isMousePressedPrevFrame = StdDraw.isMousePressed();
            StdDraw.show(); //Because we have called StdDraw.enableDoubleBuffering(), everything that you draw up until this point will be loaded into java's memory but not actually drawn. Calling StdDraw.draw() then draws everything at once that is loaded into java's memory.
            StdDraw.pause((int)(timeElapsed*1000)); //You must pass to the pause method the number of milliseconds to pause for; so we multiply by 1000 because our timeElapsed variable is in seconds, not milliseconds.
            StdDraw.clear(); //This clears everything drawn on the screen. You must redraw the image you wish to display for each frame of an animation
        }
    }



}
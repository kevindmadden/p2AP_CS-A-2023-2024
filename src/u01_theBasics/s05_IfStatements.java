package u01_theBasics;

public class s05_IfStatements {

    // Comparative Operators:
    // == != < > <= >=

    public static void main(String[] args) {
        StdDraw.setScale(0, 100);
        StdDraw.enableDoubleBuffering(); //Calling this method stops things from being drawn immediately after a draw method is called. This allows you to call many different draw methods without anything being drawn on the screen; when you call StdDraw.show(), everything will be drawn at once.

        double xPos = 50; // px
        double yPos = 50; // px
        double xVel = 18; // px/sec

        double timeElapsed = 0.017;
        while (true) {
            xPos = xPos + xVel * timeElapsed;

            if(xPos > 100){
                xVel = -1*xVel;
            }

            if(xPos > 90){
                StdDraw.setPenColor(StdDraw.YELLOW);
                StdDraw.filledRectangle(xPos, yPos, 20,10);
            }else{
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledRectangle(xPos, yPos, 10,20);
            }


            StdDraw.show();
            StdDraw.pause((int) (timeElapsed * 1000));
            StdDraw.clear();
        }
    }
}
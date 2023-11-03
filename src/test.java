public class test {




    public static void main(String[] args) {
        StdDraw.setScale(0, 100);
        StdDraw.enableDoubleBuffering(); //Calling this method stops things from being drawn immediately after a draw method is called. This allows you to call many different draw methods without anything being drawn on the screen; when you call StdDraw.show(), everything will be drawn at once.

        boolean wasMousePressedInPrevFrame = false;
        double xPos = 50; // px
        double yPos = 50; // px
        double xVel = 40; // px/sec
        double yVel = 40;
        double radius = 10;
        boolean switchmood = false;

        double timeElapsed = 0.017; //0.017 seconds-- this is how long each frame of our animation appears.
        while (true) {
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(0,0,100,100);
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.filledRectangle(0,0,100,25);

            boolean wasMouseReleased = wasMousePressedInPrevFrame && !StdDraw.isMousePressed();
            if(wasMouseReleased)
            {
                switchmood = !switchmood;
            }

            xPos = xPos + xVel * timeElapsed;
            if (xPos > 90) {
                xVel = -1 * xVel;
            }
            if (xPos < 10) {
                xVel = -1 * xVel;
            }
            yPos = yPos + yVel * timeElapsed;
            if (yPos > 90) {
                yVel = -1 * yVel;
            }
            if (yPos < 50) {
                yVel = 1 * yVel;
            }
            if (yPos < 10) {
                yVel = -1 * yVel;
            }
            boolean isPointInCircle = isPointInCircle(StdDraw.mouseX(), StdDraw.mouseY(), xPos, yPos, radius);
            if(isPointInCircle){
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.circle(xPos, yPos, radius);
                StdDraw.circle(xPos, yPos, radius+1);
                StdDraw.circle(xPos, yPos, radius+2);
            }

            if(switchmood){
                Angry(xPos, yPos);
            }
            else{
                Smiley(xPos, yPos);
            }


            wasMousePressedInPrevFrame = StdDraw.isMousePressed();
            StdDraw.show(); //Because we have called StdDraw.enableDoubleBuffering(), everything that you draw up until this point will be loaded into java's memory but not actually drawn. Calling StdDraw.draw() then draws everything at once that is loaded into java's memory.
            StdDraw.pause((int) (timeElapsed * 1000)); //You must pass to the pause method the number of milliseconds to pause for; so we multiply by 1000 because our timeElapsed variable is in seconds, not milliseconds.
            StdDraw.clear(); //This clears everything drawn on the screen. You must redraw the image you wish to display for each frame of an animation
        }
    }

    public static boolean isPointInRectangle(double xPoint, double yPoint, double xRect, double yRect, double halfWidth, double halfHeight){
        boolean isBetweenRightAndLeftEdge = xPoint > (xRect-halfWidth) && xPoint< (xRect+halfWidth);
        //boolean isBetweenTopAndBottomEdge = yPoint > (yRect-halfHeight) && yPoint < (yRect+halfHeight); //either true or false
        double bottomEdgeOfRect = yRect-halfHeight;
        boolean isPointAboveBottomEdge = yPoint > bottomEdgeOfRect;
        double topEdgeOfRectangle = yRect + halfHeight;
        boolean isPointBelowTopEdge = yPoint < topEdgeOfRectangle;
        boolean isBetweenTopAndBottomEdge = isPointAboveBottomEdge && isPointBelowTopEdge;

        if(isBetweenRightAndLeftEdge && isBetweenTopAndBottomEdge){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isPointInCircle(double xPoint, double yPoint, double xCircle, double yCircle, double radius){
        double distance = Math.sqrt( Math.pow(xPoint-xCircle, 2) + Math.pow(yPoint-yCircle, 2) );
        boolean isDistanceLessThanRadius = distance < radius;
        return isDistanceLessThanRadius;
    }
    public static void Smiley(double x, double y) {
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledCircle(x, y, 10); // Head
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(x - 4, y + 3, 1); // Left eye
        StdDraw.filledCircle(x + 4, y + 3, 1); // Right eye
        StdDraw.arc(x, y - 3, 4, 180, 0); // Smile
    }
    public static void Angry(double x, double y) {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(x, y, 10); // Head
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(x - 4, y + 3, 1); // Left eye
        StdDraw.filledCircle(x + 4, y + 3, 1); // Right eye
        StdDraw.arc(x, y - 3, 4, 0, 180); // Smile
    }
}

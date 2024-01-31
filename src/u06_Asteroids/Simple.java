package u06_Asteroids;

import java.awt.event.KeyEvent;

public class Simple {

    public static void main(String[] args) {
        double x1 = 50;
        double y1 = 50;
        double r = 10;
        double x2 = x1+r;
        double y2 = y1;
        double theta = 0;

        StdDraw.setScale(0, 100);
        StdDraw.enableDoubleBuffering(); //Calling this method stops things from being drawn immediately after a draw method is called. This allows you to call many different draw methods without anything being drawn on the screen; when you call StdDraw.show(), everything will be drawn at once.

        double timeElapsed = 0.017; //0.017 seconds-- this is how long each frame of our animation appears.
        while (true) {

            if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
                theta+=5;
                System.out.println(theta);
            }
            x2 = x1 + r*Math.sin(Math.toRadians(theta));
            y2 = y1 + r*Math.cos(Math.toRadians(theta));

            StdDraw.line(x1,y1,x2,y2);

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
}
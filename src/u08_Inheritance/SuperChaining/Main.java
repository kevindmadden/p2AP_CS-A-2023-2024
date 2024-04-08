package u08_Inheritance.SuperChaining;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        StdDraw.setScale(0, 100);
        StdDraw.enableDoubleBuffering(); //Calling this method stops things from being drawn immediately after a draw method is called. This allows you to call many different draw methods without anything being drawn on the screen; when you call StdDraw.show(), everything will be drawn at once.


        Rectangle r1= new Rectangle(10,5, 20, 20, StdDraw.CYAN, StdDraw.BLUE);
        Rectangle r2= new Rectangle();

        Square s1 = new Square(4,90, 90, StdDraw.YELLOW, StdDraw.GREEN);

        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(r1);
        rectangles.add(r2);
        rectangles.add(s1);



        double timeElapsed = 0.017; //0.017 seconds-- this is how long each frame of our animation appears.
        while (true) {

            for(Rectangle rectangle: rectangles){
              rectangle.draw();
            }

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
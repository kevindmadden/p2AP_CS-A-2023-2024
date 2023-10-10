package u01_theBasics;

public class s06_IsPointInRect {

    //Runestone sections:
    // && - AND

    public static void main(String[] args) {
        StdDraw.setScale(0, 100);
        StdDraw.enableDoubleBuffering(); //Calling this method stops things from being drawn immediately after a draw method is called. This allows you to call many different draw methods without anything being drawn on the screen; when you call StdDraw.show(), everything will be drawn at once.

        double xPos = 50; // px
        double yPos = 50; // px
        double xVel = 45; // px/sec
        double halfWidth = 10;
        double halfHeight = 20;

        double timeElapsed = 0.017;
        while (true) {
            xPos = xPos + xVel * timeElapsed;

            if(xPos > 100){
                xVel = -1*xVel;
            }
            if(xPos < 0){
                xVel = -1*xVel;
            }

            System.out.println(StdDraw.mouseX() + ", " + StdDraw.mouseY());

            double rand = Math.random();
            boolean isPointInRect = isPointInRectangle(StdDraw.mouseX(),StdDraw.mouseY(), xPos, yPos, halfWidth, halfHeight);
            if(isPointInRect){
                StdDraw.setPenColor(StdDraw.YELLOW);
            }else{
                StdDraw.setPenColor(StdDraw.BLACK);
            }

            StdDraw.filledRectangle(xPos, yPos, halfWidth,halfHeight);


            StdDraw.show();
            StdDraw.pause((int) (timeElapsed * 1000));
            StdDraw.clear();
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


}